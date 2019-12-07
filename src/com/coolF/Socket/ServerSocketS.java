package com.coolF.Socket;

import java.io.*;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.channels.*;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.*;

/**
 * @Author ChenWenFei
 * @create 2019-12-06 11:55
 */
public class ServerSocketS {

    public static void main(String[] args) {

        new ServerSocketS().SimpleBIOServerClient();
    }

    /**
     * 基础server端写法
     */
    public  void normalServer(){
        try {
            int port = 5533;
            ServerSocket server = new ServerSocket(port);

            System.out.println("server：等待连接……");

            Socket socket = server.accept();

            InputStream input = socket.getInputStream();
            int len = 0;
            byte[] bytes = new byte[1024];
            StringBuilder sb = new StringBuilder();
            while ((len = input.read(bytes)) != -1) {
                sb.append(new String(bytes, 0, len, "UTF-8"));
            }

            System.out.println("get message from client: " + sb);

            OutputStream output = socket.getOutputStream();
            output.write("Hello Client,I get the message!".getBytes("UTF-8"));

            input.close();
            socket.close();
            server.close();
        }catch (IOException e){
            System.out.println("server-Exception: "+e.toString());
        }

    }

    /**
     * 消息通讯优化后的server端写法
     * Jedis简单实现方式
     */
    public  void optimizeServer(){
        try {
            int port = 5533;
            ServerSocket server = new ServerSocket(port);
            System.out.println("server: 等待连接 ……");
            Socket socket = server.accept();
            InputStream input = socket.getInputStream();

            byte[] bytes;
            // 因为可以复用Socket且能判断长度，所以可以一个Socket用到底
            while (true) {
                int first = input.read();
                if (first == -1)
                    break;
                int second = input.read();
                int length = (first << 8) + second;
                bytes = new byte[length];
                input.read(bytes);
                System.out.println("get message from client: " + new String(bytes, "UTF-8"));
            }

            input.close();
            socket.close();
            server.close();
        } catch (IOException e) {
            System.out.println("server-Exception: "+e.toString());
        }
    }

    /**
     * 使用线程池优化server并发处理能力
     * 目的：
     *      线程复用，创建线程耗时，回收线程慢
     *      防止短时间内高并发，指定线程池大小，超过数量将等待，方式短时间创建大量线程导致资源耗尽，服务挂掉
     */
    public void cycleServer(){
        try {
            int port = 5533;
            ServerSocket server = new ServerSocket(port);
            System.out.println("server: 等待连接……");

            //如果使用多线程，那就需要线程池，防止并发过高时创建过多线程耗尽资源
            ExecutorService threadPool = Executors.newFixedThreadPool(100);

            while (true) {
                Socket socket = server.accept();

                Runnable runnable=()-> {
                    try {
                        InputStream input = socket.getInputStream();
                        byte[] bytes = new byte[1024];
                        int len;
                        StringBuilder sb = new StringBuilder();
                        while ((len = input.read(bytes)) != -1) {
                            sb.append(new String(bytes, 0, len, "UTF-8"));
                        }
                        System.out.println("get message from client: " + sb);

                        input.close();
                        socket.close();
                    }catch (IOException e){
                        e.printStackTrace();
                    }
                };
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * BIO
     * 实现一个简单的Socket，服务器端只发给客户端信息，再由客户端打印出来
     */
    public void SimpleBIOServerClient(){
        int port = 5533;

        //服务器端
        Thread sTread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    ServerSocket server = new ServerSocket(port);
                    while (true) {
                        //等待连接
                        Socket socket = server.accept();
                        Thread sHanderThread = new Thread(new Runnable() {
                            @Override
                            public void run() {
                                try(PrintWriter print=new PrintWriter(socket.getOutputStream())) {
                                    print.println("Hello World!");
                                    print.flush();
                                }catch (IOException e){
                                    e.printStackTrace();
                                }
                            }
                        });
                        sHanderThread.start();
                    }
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        });
        sTread.start();

        //Socket端（接收信息并打印）
        try (Socket cSocket = new Socket(InetAddress.getLocalHost(),port)){
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(cSocket.getInputStream()));
            bufferedReader.lines().forEach(s -> System.out.println("客户端：" + s));
        }catch (IOException e){
            e.printStackTrace();
        }


    }

    /**
     * NIO多复用
     */
    public void SimpleNIOServerClient(){
        int port = 5533;
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(4, 4, 60L,
                TimeUnit.SECONDS, new LinkedBlockingDeque<Runnable>());
        threadPool.execute(new Runnable() {
            @Override
            public void run() {
                try(Selector selector = Selector.open();
                    ServerSocketChannel channel = ServerSocketChannel.open();){
                    channel.bind(new InetSocketAddress(InetAddress.getLocalHost(),port));
                    channel.configureBlocking(false);
                    channel.register(selector, SelectionKey.OP_ACCEPT);
                    while (true){
                        selector.select(); //阻塞等待就绪的Channal
                        Set<SelectionKey> selectionKeys = selector.selectedKeys();
                        Iterator<SelectionKey> iterator = selectionKeys.iterator();
                        while (iterator.hasNext()){
                            SelectionKey key = iterator.next();
                            try (SocketChannel sChannel = ((ServerSocketChannel) key.channel()).accept()) {
                                sChannel.write(Charset.defaultCharset().encode("你好，世界"));
                            }
                            iterator.remove();
                        }
                    }
                }catch (IOException e){
                    e.printStackTrace();
                }

            }
        });

        // Socket 客户端（接收信息并打印）
        try (Socket cSocket = new Socket(InetAddress.getLocalHost(), port)) {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(cSocket.getInputStream()));
            bufferedReader.lines().forEach(s -> System.out.println("NIO 客户端：" + s));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

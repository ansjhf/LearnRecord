package com.coolF.Socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * @Author ChenWenFei
 * @create 2019-12-06 12:50
 */
public class SocketClient {

    public static void main(String[] args) {
        new SocketClient().optimizeClient();
    }

    public  void normalClient() {

        try {
            String host = "127.0.0.1";
            int port = 5533;
            Socket socket = new Socket(host, port);

            OutputStream output = socket.getOutputStream();

            System.out.println("Client想Server发送消息……");

            String message = "你好 ServerSocketS!";
            socket.getOutputStream().write(message.getBytes("UTF-8"));
            //通过shutdownOutput高速服务器已经发送完数据，后续只能接受数据
            socket.shutdownOutput();

            InputStream input = socket.getInputStream();
            byte[] bytes = new byte[1024];
            int len = 0;
            StringBuilder sb = new StringBuilder();
            while ((len = input.read(bytes)) != -1) {
                sb.append(new String(bytes, 0, len, "UTF-8"));
            }
            System.out.println("get message from server: " + sb);

            output.close();
            socket.close();
        }catch (IOException e){
            System.out.println("Client_Exception: "+ e.toString());
        }
    }


    public void optimizeClient(){
        try {
            String host = "127.0.0.1";
            int port = 5533;
            Socket socket = new Socket(host, port);
            OutputStream output = socket.getOutputStream();
            String message = "Hello SocketServer!";
            //首先需要计算得知消息的长度
            byte[] sendBytes = message.getBytes("UTF-8");
            //然后将消息的长度优先发送出去
            output.write(sendBytes.length >> 8);
            output.write(sendBytes.length);
            //然后将消息再次发送出去
            output.write(sendBytes);
            output.flush();

            message = "Second Message!";
            sendBytes = message.getBytes("UTF-8");
            output.write(sendBytes.length >> 8);
            output.write(sendBytes.length);
            output.write(sendBytes);
            output.flush();

            output.close();
            socket.close();

        }catch (IOException e){
            System.out.println("Client-Exception: "+e.toString());
        }
    }
}

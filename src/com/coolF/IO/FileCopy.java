package com.coolF.IO;

/**
 * @Author ChenWenFei
 * @create 2019-12-05 18:33
 */
import java.io.*;

public class FileCopy {
    public static void main(String args[]){
        if (args.length != 2){  //参数不是两个
            System.out.println("错误的执行方式,命令调用:java Copy 源文件路径 目标文件路径");
            System.exit(1);
        }
        //判断要拷贝的源文件路径是否存在
        if (CopyUtil.fileExists(args[0])){
            CopyUtil.createParentDirectory(args[1]);    //创建目标父目录
            System.out.println(CopyUtil.copy(args[0],args[1])?"文件拷贝成功":"文件拷贝失败");
        }else {
            System.out.println("源文件不存在1");
        }

    }
}

/**
 * 文件拷贝处理类
 * 1,判断拷贝源文件是否存在
 * 2,判断目标父路径是否存在,如不存在则应该创建
 * 3,文件拷贝处理操作
 */
class CopyUtil { //该类不需要保存任何的属性,所以建议将构造方法私有化,使用static方法

    private CopyUtil() {
    }    //构造方法私有化

    /**
     * 判断拷贝的原路径是否存在
     *
     * @param path 输入原路径信息
     * @return 如果该路径真是存在返回true, 否则返回false
     */
    public static boolean fileExists(String path) {
        return new File(path).exists();
    }

    //根据传入的路径判断其父路径是否存在，如果不存在则创建
    public static void createParentDirectory(String path) {
        File file = new File(path);
        if (!file.getParentFile().exists()) {    //路径不存在
            file.getParentFile().mkdirs();  //创建目录
        }
    }

    //实现文件的拷贝处理
    public static boolean copy(String srcPath, String desPath) {
        boolean flag = false;
        File inFile = new File(srcPath);
        File outFile = new File(desPath);
        InputStream input = null;
        OutputStream output = null;
        try {
            input = new FileInputStream(inFile);
            output = new FileOutputStream(outFile);
            copyHandle(input, output);   //完成具体的文件拷贝处理
            flag = true;    //如果没有异常,则一定会执行此语句
        } catch (IOException e) {
            flag = false;
        } finally {
            try {
                input.close();
                output.close();
            } catch (IOException e) {
            }
        }

        return flag;
    }

    //实现具体的文件拷贝操作
    public static void copyHandle(InputStream input, OutputStream output) throws IOException {

        long start = System.currentTimeMillis();
        //InputStream 读取单字节方法: int read()
        //OutputStream 输出单字节方法: void write(int data)
        int temp = 0;

        //开发中尽量少用do{}while 结构
//        do{
//            temp = input.read();    //读取单个字节数据
//            output.write(temp);     //通过输出流输出
//        }while (temp != -1);    //如果有数据继续读取


        //读取速度慢
//        //1: temp = input.read() 表示读取输入流中的一个字节
//        //2: (temp = input.read()) != -1 判断这个读取后的字节(保存在temp)是否为-1,如果不是则表示有内容
//        while ((temp = input.read()) != -1){
//            output.write(temp);
//        }

        //优化拷贝速度
        //temp = input.read(data) 表示将数据读取都字节数组之中,而后返回数据读取个数
        //(temp = input.read(data)) != -1 判断这个读取的个数是否为-1,如果不是则表示有内容
        byte data[] = new byte[2048];
        while ((temp = input.read(data)) != -1) {
            output.write(data, 0, temp);  //输出部分字节数组
        }

        long end = System.currentTimeMillis();
        System.out.println("拷贝文件所花费的时间: " + (end - start));
    }
}
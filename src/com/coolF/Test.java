package com.coolF;

import java.io.File;


/**
 * @Author ChenWenFei
 * @create 2019-11-29 20:46
 */
public class Test {

    public static void main(String[] args) throws Exception {

        File file = new File("/Users/a/Downloads/临时文件夹/java/", "abc.txt");

        String message = "Hello SocketServer!";
        System.out.println(message.getBytes("UTF-8").length >> 8);


    }
}

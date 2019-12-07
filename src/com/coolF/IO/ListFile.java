package com.coolF.IO;

/**
 * @Author ChenWenFei
 * @create 2019-12-05 18:53
 */
import java.io.File;

public class ListFile {

    public static void listFile(String str){
        File file = new File(str);
        if (file.exists()) {
            listDir(file);
        }
    }


    //列出指定目录中的全部子目录信息
    private static void listDir(File file){

        File result[] = file.listFiles();
        if (file.isDirectory()){
            if (result != null) {
                for (int x = 0; x < result.length; x++) {
                    listDir(result[x]);
                }
            }
        }
        System.out.println(file);
    }
}
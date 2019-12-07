package com.coolF.IO;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @Author ChenWenFei
 * @create 2019-12-06 10:55
 */
public class testWriteFile {

    public static void WriteFile(File file , String str){
        FileWriter fw = null;
        try {
            fw = new FileWriter(file);
            fw.write(str);
        }catch (IOException e){
            System.out.println("write-Exception: "+e.toString());
        }finally {
            if (fw != null){
                try {
                    fw.close();
                }catch (IOException e){
                    System.out.println("close-Exception: "+e.toString());
                }
            }
        }
    }
}

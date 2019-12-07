package com.coolF.IO;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * @Author ChenWenFei
 * @create 2019-12-06 10:15
 */
public class testReadFile {

    public static void read(File file){

        FileReader fr = null;
        try {
            fr = new FileReader(file);
            char[] buf = new char[1024];
            int len = 0;
            while ((len = fr.read(buf)) != -1) {
                System.out.println(new String(buf, 0, len));
            }
        }catch (IOException e){
            System.out.println("read-Exception: "+e.toString());
        }finally {
            if (fr != null){
                try {
                    fr.close();
                }catch (IOException e){
                    System.out.println("close-Exception: "+e.toString());
                }
            }
        }

    }
}

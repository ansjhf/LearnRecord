package com.coolF.IO;

import java.io.*;

/**
 * @Author ChenWenFei
 * @create 2019-12-05 18:34
 */
public class FileCopyUnit {

    public static void copy(String srcPath,String descPath){

        long start = System.currentTimeMillis();

        File file = new File(descPath);
        if (!file.exists() || !file.exists()) {
            System.out.println("路径不存在");
            file.getParentFile().mkdirs();
            System.out.println("创建目标路径成功"+" : "+file.getPath());
        }

        InputStream input = null;
        OutputStream output = null;
        try {
            input = new FileInputStream(new File(srcPath));
            output = new FileOutputStream(new File(descPath));
            int temp = 0;
            byte data[] = new byte[1024];
            while ((temp = input.read(data)) != -1) {
                output.write(data, 0, temp);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            if (input != null || output!=null) {
                try {
                    input.close();
                    output.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        long end = System.currentTimeMillis();
        System.out.println("拷贝成功!");
        System.out.println("拷贝文件所花费的时间: "+(end-start));
    }
}

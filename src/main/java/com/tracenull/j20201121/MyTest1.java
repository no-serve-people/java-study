package com.tracenull.j20201121;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 首先，对比下普通字节流和缓冲字节流的效率：
 * https://mp.weixin.qq.com/s/RGRYdbaQcIS8nWIkDiVDww
 */
public class MyTest1 {
    public static void main(String[] args) throws Exception {
        File file = new File("/Users/ixingjue/IdeaProjects/javastudy/src/main/java/com/tracenull/j20201121/1.txt");
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 3000000; i++) {
            sb.append("abcdefghigklmnopqrstuvwsyz");
        }

        byte[] bytes = sb.toString().getBytes();
        long start = System.currentTimeMillis();
        write(file, bytes);
        long end = System.currentTimeMillis();

        long start2 = System.currentTimeMillis();
        bufferedWrite(file, bytes);
        long end2 = System.currentTimeMillis();
        System.out.println("普通字节流耗时：" + (end - start) + " ms");
        System.out.println("缓冲字节流耗时：" + (end2 - start2) + " ms");

    }

    // 普通字节流
    public static void write(File file, byte[] bytes) throws IOException {
        FileOutputStream os = new FileOutputStream(file);
        os.write(bytes);
        os.close();
    }

    // 缓冲字节流
    public static void bufferedWrite(File file, byte[] bytes) throws IOException {
        BufferedOutputStream bo = new BufferedOutputStream(new FileOutputStream(file));
        bo.write(bytes);
        bo.close();
    }
}

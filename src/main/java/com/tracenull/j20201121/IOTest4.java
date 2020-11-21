package com.tracenull.j20201121;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class IOTest4 {
    public static void write(File file) throws IOException {
        FileWriter fw = new FileWriter(file, true);

        // 要写入的字符串
        String string = "松下问童子，言师采药去。只在此山中，云深不知处。";
        fw.write(string);
        fw.close();
    }

    public static String read(File file) throws IOException {
        FileReader fr = new FileReader(file);
        // 一次性取多少个字节
        char[] chars = new char[1024];
        // 用来接收读取的字节数组
        StringBuilder sb = new StringBuilder();
        // 读取到的字节数组长度，为-1时表示没有数据
        int length;
        // 循环取数据
        while ((length = fr.read(chars)) != -1) {
            // 将读取的内容转换成字符串
            sb.append(chars, 0, length);
        }
        // 关闭流
        fr.close();

        return sb.toString();
    }
}

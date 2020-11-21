package com.tracenull.j20201121;

import java.io.File;

/**
 * FileTest
 * https://mp.weixin.qq.com/s/RGRYdbaQcIS8nWIkDiVDww
 */
public class FileTest {
    public static void main(String[] args) throws Exception {
        File file = new File("/Users/ixingjue/IdeaProjects/javastudy/src/main/java/com/tracenull/j20201121/1.txt");
        // 判断文件是否存在
        if (!file.exists()) {
            // 不存在则创建
            file.createNewFile();
        }
        System.out.println("文件的绝对路径：" + file.getAbsolutePath());
        System.out.println("文件的大小：" + file.length());
        // 刪除文件
        file.delete();
    }
}

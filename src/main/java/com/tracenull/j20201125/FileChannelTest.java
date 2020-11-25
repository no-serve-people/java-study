package com.tracenull.j20201125;

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 给大忙人们看的Java NIO教程之Channel
 * https://mp.weixin.qq.com/s/79UIcvuwjJnHYvL_XPucoA
 */
public class FileChannelTest {
    public static void main(String[] args) throws Exception {
        RandomAccessFile aFile = new RandomAccessFile("/Users/ixingjue/IdeaProjects/javastudy/src/main/java/com/tracenull/j20201125/1.txt", "rw");
        FileChannel inChannel = aFile.getChannel();

        ByteBuffer buf = ByteBuffer.allocate(48);

        int bytesRead = inChannel.read(buf);

        while (bytesRead != -1) {
            System.out.println("Read" + bytesRead);

            buf.flip();

            while (buf.hasRemaining()) {
                System.out.println((char) buf.get());
            }

            buf.clear();
            bytesRead = inChannel.read(buf);
        }

        aFile.close();
    }
}

package com.tracenull.j20201108.xvliehua;

import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.nio.ByteBuffer;

public class Xvliehuatest2 {
    public static void main(String[] args) throws Exception {
        User user = new User();
        user.setUsername("test");
        user.setPassword("test");

        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            ByteArrayOutputStream os = new ByteArrayOutputStream();
            ObjectOutputStream out = new ObjectOutputStream(os);
            out.writeObject(user);
            out.flush();
            out.close();
            byte[] testByte = os.toByteArray();
            os.close();
        }
        long endTime = System.currentTimeMillis();

        System.out.println("ObjectOutputStream 序列化时间：" + (endTime - startTime));

        long startTime1 = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            ByteBuffer byteBuffer = ByteBuffer.allocate(2048);

            byte[] userName = user.getUsername().getBytes();
            byte[] password = user.getPassword().getBytes();
            byteBuffer.putInt(userName.length);
            byteBuffer.put(userName);
            byteBuffer.putInt(password.length);
            byteBuffer.put(password);

            byteBuffer.flip();
            byte[] bytes = new byte[byteBuffer.remaining()];
        }
        long endTime1 = System.currentTimeMillis();
        System.out.print("ByteBuffer 序列化时间：" + (endTime1 - startTime1) + "\n");
    }
}

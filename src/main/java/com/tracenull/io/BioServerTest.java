package com.tracenull.io;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 阻塞IO
 */
public class BioServerTest {
    static ExecutorService threadPool = Executors.newCachedThreadPool();

    public static void main(String[] args) throws IOException {
        ServerSocket socket = new ServerSocket(8082);
        System.out.println("start");
        while (true) {
            Socket accept = socket.accept(); // 可能出现阻塞
            threadPool.submit(() -> {
                byte[] request = new byte[1024];
                accept.getInputStream().read(request);// 可能出现阻塞
                Thread.sleep(10000); // 测试模拟阻塞

                System.out.println(new String(request));
                return request.toString();
            });
        }
    }
}

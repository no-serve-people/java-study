package com.tracenull.j20210311;

import java.util.concurrent.CountDownLatch;

/**
 * https://mp.weixin.qq.com/s/ga3x8LYxDMgCzdfn6UUT_w
 * 多个线程等待：模拟并发，让并发线程一起执行。
 */
public class TestCountDownLatch1 {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(1);

        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                try {
                    // 所有请求都阻塞在这里等待
                    countDownLatch.await();
                    // 调用调试接口
                    System.out.println(Thread.currentThread().getName() + "开始执行……");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }

        // 让请求都准备好
        Thread.sleep(2000);
        // 让所有的请求统一请求
        countDownLatch.countDown();
    }
}

package com.tracenull.j20210311;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadLocalRandom;

/**
 * https://mp.weixin.qq.com/s/ga3x8LYxDMgCzdfn6UUT_w
 * 单个线程等待：多个线程(任务)完成后，进行汇总合并
 */
public class TestCountDownLatch2 {
    public static void main(String[] args) throws InterruptedException {
        int count = 3;

        CountDownLatch countDownLatch = new CountDownLatch(count);

        for (int i = 0; i < count; i++) {
            final int index = i;

            new Thread(() -> {
                try {
                    Thread.sleep(1000 + ThreadLocalRandom.current().nextInt(1000));
                    System.out.println("finish" + index + Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    countDownLatch.countDown();
                }
            }).start();
        }
        countDownLatch.await();// 主线程在阻塞，当计数器==0，就唤醒主线程往下执行。
        System.out.println("主线程:在所有任务运行完成后，进行结果汇总");
    }
}

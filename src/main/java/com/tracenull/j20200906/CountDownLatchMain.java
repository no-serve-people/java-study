package com.tracenull.j20200906;

import java.util.concurrent.CountDownLatch;

/**
 * https://mp.weixin.qq.com/s/SmRcVLNlTVtFGobu028CmA
 */
public class CountDownLatchMain {
    public static void main(String[] args) throws Exception {
        CountDownLatch latch = new CountDownLatch(3);

        new Thread(() -> {
            String threadName = Thread.currentThread().getName();

            System.out.println(String.format("线程%s准备调用await方法。。。", threadName));
            await0(latch);
            System.out.println(String.format("线程%s解除阻塞继续运行......", threadName));
        }, "thirdThread").start();

        Thread.sleep(500L);
        new Thread(() -> {
            String threadName = Thread.currentThread().getName();
            System.out.println(String.format("线程%s准备调用await方法......", threadName));
            await0(latch);
            System.out.println(String.format("线程%s解除阻塞继续运行......", threadName));
        }, "firstThread").start();
        Thread.sleep(500L);

        new Thread(() -> {
            String threadName = Thread.currentThread().getName();
            System.out.println(String.format("线程%s准备调用await方法......", threadName));
            await0(latch);
            System.out.println(String.format("线程%s解除阻塞继续运行......", threadName));
        }, "secondThread").start();
        Thread.sleep(500L);

        long count = latch.getCount();
        System.out.println("main线程释放CountDownLatch......");

        for (long i = 0; i < count; i++) {
            latch.countDown();
        }
        Thread.sleep(Long.MAX_VALUE);
    }

    private static void await0(CountDownLatch latch) {
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

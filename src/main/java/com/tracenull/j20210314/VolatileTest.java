package com.tracenull.j20210314;

/**
 * Volatile
 * https://mp.weixin.qq.com/s/H62xmS-yVdYYWTYPGdmhkg
 */
public class VolatileTest {

    private static volatile int count = 0;
    private static final int times = Integer.MAX_VALUE;

    public static void main(String[] args) {

        long curTime = System.nanoTime();

        Thread decThread = new DecThread();
        decThread.start();

        // 使用run()来运行结果为0,原因是单线程执行不会有线程安全问题
        // new DecThread().run();

        System.out.println("Start thread: " + Thread.currentThread() + " i++");

        for (int i = 0; i < times; i++) {
            count++;
        }

        System.out.println("End thread: " + Thread.currentThread() + " i--");

        // 等待decThread结束
        while (decThread.isAlive()) ;

        long duration = System.nanoTime() - curTime;
        System.out.println("Result: " + count);
        System.out.format("Duration: %.2fs\n", duration / 1.0e9);
    }

    private static class DecThread extends Thread {

        @Override
        public void run() {
            System.out.println("Start thread: " + Thread.currentThread() + " i--");
            for (int i = 0; i < times; i++) {
                count--;
            }
            System.out.println("End thread: " + Thread.currentThread() + " i--");
        }
    }
}

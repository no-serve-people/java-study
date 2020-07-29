package com.tracenull.basic;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class VolatileDemoBlog {
    private Lock lock = new ReentrantLock();

    private int number = 0;

    public int getNumber() {
        return this.number;
    }
    /**
     * 【注】不加次会导致最后结果可能小于500
     * 例如：number = 5;
     * (1) 线程A读取number的值。
     * (2) 线程B读取number的值。
     * (3) 线程B执行加1操作。
     * (4) 线程B写入最新的number的值。
     * 结果：线程B工作内存：number=6;
     *     线程A工作内存：number=5;
     * (5) 线程A执行加1操作。
     * (6) 线程A写入最新的number值。
     * 结果：线程A工作内存：number=6;
     * 【两次number++,只增加了1】主要不是原子性导致的结果。
     *
     * 【解决方案---保证number自增操作的原子性】
     * (1) 使用synchronized关键字。
     * (2) 使用ReentrantLock(java.until.concurrent.locks包下)
     * (3) 使用AtomicInterger(vava.util.concurrent.atomic包下)
     */
    public void increase() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        lock.lock();

        try {
            this.number++;
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        VolatileDemoBlog volDemo = new VolatileDemoBlog();

        for (int i = 0; i < 500; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    volDemo.increase();
                }
            }).start();
        }
        // 如果还有子线程在运行，主线程就让出CPU资源，
        // 直到所有的子线程都运行完了，主线程再继续往下执行
        while (Thread.activeCount() > 2) {
            Thread.yield();
        }

        System.out.println("number:" + volDemo.getNumber());
    }
}

package com.tracenull.j20210208;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * synchronized分别修饰同一个类对象的非静态方法和当前对象时互斥
 * https://mp.weixin.qq.com/s/gKsD1U38h4MJczEFC33ydw
 */
public class SynchronizeAndObjectLock3 {
    public static void main(String[] args) {
        // 【注意】当且仅当是同一个SynchronizeAndObjectLock3对象
        SynchronizeAndObjectLock3 synchronizeAndObjectLock3 = new SynchronizeAndObjectLock3();
        new Thread(() -> {
            synchronizeAndObjectLock3.test1();
        }).start();

        new Thread(() -> {
            synchronizeAndObjectLock3.test2();
        }).start();
    }

    public void test1() {
        synchronized (this) {
            System.out.println(new Date() + " " + Thread.currentThread().getName() + " begin...");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (Exception e) {
            }
            System.out.println(new Date() + " " + Thread.currentThread().getName() + " end...");
        }
    }

    public synchronized void test2() {
        System.out.println(new Date() + " " + Thread.currentThread().getName() + " begin...");
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (Exception e) {
        }
        System.out.println(new Date() + " " + Thread.currentThread().getName() + " end...");
    }
}

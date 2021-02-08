package com.tracenull.j20210208;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * 3.3 synchronized修饰不同对象的两个非静态方法时不会互斥
 * https://mp.weixin.qq.com/s/gKsD1U38h4MJczEFC33ydw
 */
public class SynchronizeAndObjectLock {
    public static void main(String[] args) throws Exception {
        new Thread(() -> {
            // 这里new 了一个SynchronizeAndObjectLock对象
            new SynchronizeAndObjectLock().test1();
        }).start();

        new Thread(() -> {
            // 这里new 了另一个SynchronizeAndObjectLock对象
            new SynchronizeAndObjectLock().test2();
        }).start();
    }

    public synchronized void test1() {
        System.out.println(new Date() + " " + Thread.currentThread().getName() + " begin...");
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (Exception e) {
        }
        System.out.println(new Date() + " " + Thread.currentThread().getName() + " end...");
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

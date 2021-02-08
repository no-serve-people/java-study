package com.tracenull.j20210208;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * 3.1 synchronized修饰同一个类对象的两个非静态方法时互斥
 * https://mp.weixin.qq.com/s/gKsD1U38h4MJczEFC33ydw
 */
public class SynchronizeAndObjectLock2 {

    public static void main(String[] args) {
        // 【注意】当且仅当是同一个SynchronizeAndObjectLock2对象
        SynchronizeAndObjectLock2 synchronizeAndObjectLock2 = new SynchronizeAndObjectLock2();
        new Thread(() -> {
            synchronizeAndObjectLock2.test1();
        }).start();

        new Thread(() -> {
            synchronizeAndObjectLock2.test2();
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

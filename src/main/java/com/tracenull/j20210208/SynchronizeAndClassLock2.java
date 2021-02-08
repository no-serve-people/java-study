package com.tracenull.j20210208;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * 2.2 synchronized分别修饰同一个类的静态方法和当前类时互斥
 * https://mp.weixin.qq.com/s/gKsD1U38h4MJczEFC33ydw
 */
public class SynchronizeAndClassLock2 {
    public static void main(String[] args) {
        new Thread(() -> {
            // new了一个ClassLock2对象
            new ClassLock2().test1();
            // ClassLock2.test1();
        }).start();
        new Thread(() -> {
            // new了另一个ClassLock2对象
            new ClassLock2().test2();
            // ClassLock2.test2();
        }).start();

    }
}


class ClassLock2 {
    public synchronized static void test1() {
        System.out.println(new Date() + " " + Thread.currentThread().getName() + " begin...");
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (Exception e) {
        }
        System.out.println(new Date() + " " + Thread.currentThread().getName() + " end...");
    }


    public static void test2() {
        // 【注意】synchronized (SynchronizeAndClassLock2.class)不会互斥
        synchronized (ClassLock2.class) {
            System.out.println(new Date() + " " + Thread.currentThread().getName() + " begin...");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (Exception e) {
            }
            System.out.println(new Date() + " " + Thread.currentThread().getName() + " end...");
        }
    }
}

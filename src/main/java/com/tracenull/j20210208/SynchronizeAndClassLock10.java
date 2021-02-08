package com.tracenull.j20210208;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * https://mp.weixin.qq.com/s/gKsD1U38h4MJczEFC33ydw
 * 2.3 synchronized分别修饰同一个静态对象时互斥
 */
public class SynchronizeAndClassLock10 {
    public static void main(String[] args) {
        new Thread(() -> {
            new RunObject1().test1();
        }).start();

        new Thread(() -> {
            new RunObject2().test2();
        }).start();
    }
}

class RunObject1 {
    public static void test1() {
        // 【1】synchronized (StaticLock2.staticLock1) {
        synchronized (StaticLock2.staticLock) {
            System.out.println(new Date() + " " + Thread.currentThread().getName() + " begin...");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (Exception e) {
            }
            System.out.println(new Date() + " " + Thread.currentThread().getName() + " end...");
        }
    }
}

class RunObject2 {
    public static void test2() {
        synchronized (StaticLock2.staticLock) {
            System.out.println(new Date() + " " + Thread.currentThread().getName() + " begin...");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (Exception e) {
            }
            System.out.println(new Date() + " " + Thread.currentThread().getName() + " end...");
        }
    }
}

class StaticLock2 {
    public static Object staticLock = new Object();
}
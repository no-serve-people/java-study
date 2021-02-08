package com.tracenull.j20210208;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * 4 synchronized修饰当前类和当前对象时不会互斥
 * https://mp.weixin.qq.com/s/gKsD1U38h4MJczEFC33ydw
 */
public class ClassAndObjectLock {
    public static void main(String[] args) throws Exception {
        new Thread(() -> {
            ClassAndObjectLock.test1();
        }).start();

        new Thread(() -> {
            new ClassAndObjectLock().test2();
        }).start();
    }

    public static void test1() {
        synchronized (ClassAndObjectLock.class) {
            System.out.println(new Date() + " " + Thread.currentThread().getName() + " begin...");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (Exception e) {
            }
            System.out.println(new Date() + " " + Thread.currentThread().getName() + " end...");
        }
    }

    public void test2() {
        synchronized (this) {
            System.out.println(new Date() + " " + Thread.currentThread().getName() + " begin...");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (Exception e) {
            }
            System.out.println(new Date() + " " + Thread.currentThread().getName() + " end...");
        }
    }
}

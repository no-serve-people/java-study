package com.tracenull.j20210208;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * 2.1 synchronized修饰同一个类的两个静态方法时互斥
 * https://mp.weixin.qq.com/s/gKsD1U38h4MJczEFC33ydw
 */
public class SynchronizeAndClassLock {
    public static void main(String[] args) {
        new Thread(() -> {
            // new了一个ClassLock对象
            new ClassLock().test1();
        }).start();

        new Thread(() -> {
            // new了另一个ClassLock对象
            new ClassLock().test2();
        }).start();
    }
}

class ClassLock {

    public synchronized static void test1() {
        System.out.println(new Date() + " " + Thread.currentThread().getName() + " begin...");

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (Exception e) {
            System.out.println(new Date() + " " + Thread.currentThread().getName());
        }
    }

    // 【注意】public static void test2(){ 不会互斥，因为此时test2没有使用类锁。
    public synchronized static void test2() {
        System.out.println(new Date() + " " + Thread.currentThread().getName() + " begin...");
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (Exception e) {
        }
        System.out.println(new Date() + " " + Thread.currentThread().getName() + " end...");
    }
}

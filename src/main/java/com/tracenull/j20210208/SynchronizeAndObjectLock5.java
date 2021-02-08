package com.tracenull.j20210208;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * 3.4 synchronized代码块修饰同一个对象时互斥
 * https://mp.weixin.qq.com/s/gKsD1U38h4MJczEFC33ydw
 */
public class SynchronizeAndObjectLock5 {
    private Object objectLock = new Object();

    public static void main(String[] args) throws Exception {

        SynchronizeAndObjectLock5 synchronizeAndObjectLock5 = new SynchronizeAndObjectLock5();
        new Thread(() -> {
            synchronizeAndObjectLock5.test1();
        }).start();

        new Thread(() -> {
            synchronizeAndObjectLock5.test2();
        }).start();
    }

    public void test1() {
        synchronized (objectLock) {
            System.out.println(new Date() + " " + Thread.currentThread().getName() + " begin...");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (Exception e) {
            }
            System.out.println(new Date() + " " + Thread.currentThread().getName() + " end...");
        }

    }

    public void test2() {
        synchronized (objectLock) {
            System.out.println(new Date() + " " + Thread.currentThread().getName() + " begin...");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (Exception e) {
            }
            System.out.println(new Date() + " " + Thread.currentThread().getName() + " end...");
        }
    }
}

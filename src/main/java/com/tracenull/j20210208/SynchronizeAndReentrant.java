package com.tracenull.j20210208;

/**
 * 5.2.1 不同方法，synchronized是可重入的
 * https://mp.weixin.qq.com/s/gKsD1U38h4MJczEFC33ydw
 */
public class SynchronizeAndReentrant {
    public static void main(String[] args) throws Exception {
        SynchronizeAndReentrant synchronizeAndReentrant = new SynchronizeAndReentrant();
        synchronizeAndReentrant.test1();
    }

    public synchronized void test1() {
        System.out.println(" test1 method is called...");
        test2();
    }

    public synchronized void test2() {
        System.out.println(" test2 method is called...");
    }
}

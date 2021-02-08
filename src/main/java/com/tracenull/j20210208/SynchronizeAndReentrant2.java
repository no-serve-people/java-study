package com.tracenull.j20210208;

/**
 * 5.2.2 相同方法，synchronized是可重入的
 * https://mp.weixin.qq.com/s/gKsD1U38h4MJczEFC33ydw
 */
public class SynchronizeAndReentrant2 {
    int i = 1;

    public static void main(String[] args) throws Exception {
        SynchronizeAndReentrant2 synchronizeAndReentrant = new SynchronizeAndReentrant2();
        synchronizeAndReentrant.test1();
    }

    public synchronized void test1() {

        System.out.println(" test1 method is called " + i++ + "st time...");
        while (i < 5) {
            test1();
        }
    }
}

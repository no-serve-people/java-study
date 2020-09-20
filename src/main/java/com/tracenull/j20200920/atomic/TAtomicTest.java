package com.tracenull.j20200920.atomic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * https://mp.weixin.qq.com/s/vbXAgNH9PyL16PmjgnGKZA
 */
public class TAtomicTest implements Runnable {
    AtomicInteger atomicInteger = new AtomicInteger();

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
//            System.out.println(atomicInteger.getAndIncrement());
//            System.out.println(atomicInteger.incrementAndGet());
//            System.out.println(atomicInteger.getAndDecrement());
            System.out.println(atomicInteger.decrementAndGet());
        }
    }

    public static void main(String[] args) {
        TAtomicTest tAtomicTest = new TAtomicTest();
        Thread t1 = new Thread(tAtomicTest);
        Thread t2 = new Thread(tAtomicTest);
        t1.start();
        t2.start();
    }
}

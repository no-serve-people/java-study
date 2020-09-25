package com.tracenull.j20200925;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 演示volatile 不保证原子性
 * https://juejin.im/post/6861885337568804871
 */
public class VolatileAtomicity {
    public static volatile int number = 0;

    //    public static void increase() {
//        number++;
//    }
    public synchronized static void increase() {
        number++;
    }

    public static AtomicInteger atomicInteger = new AtomicInteger();

    public static void main(String[] args) {
        for (int i = 0; i < 50; i++) {
            new Thread(() -> {
                for (int i1 = 0; i1 < 1000; i1++) {
//                    increase();
                    atomicInteger.getAndIncrement();
                }
            }, String.valueOf(i)).start();
        }
        // 当所有累加线程都结束
        while (Thread.activeCount() > 2) {
            Thread.yield();
        }

        System.out.println(atomicInteger);
    }
}

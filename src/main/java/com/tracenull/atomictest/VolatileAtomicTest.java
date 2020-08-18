package com.tracenull.atomictest;


import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class VolatileAtomicTest {
    public static int num = 0;

//    public synchronized static void increase() {
//        num++;
//    }
//    static Lock lock=new ReentrantLock();
//    public  static void increase() {
//        try {
//            lock.lock();
//            num++;
//        }finally {
//            lock.unlock();
//        }
//
//    }

    public static void increase() {
        num++;
    }

    public static void main(String[] args) throws Exception {
        Thread[] threads = new Thread[10];

        AtomicInteger atomicInteger = new AtomicInteger();
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(() -> {
                for (int i1 = 0; i1 < 1000; i1++) {
//                    increase();
                    num = atomicInteger.incrementAndGet();
                }
            });

            threads[i].start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        System.out.println(num);
    }
}

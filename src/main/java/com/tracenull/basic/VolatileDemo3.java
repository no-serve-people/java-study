package com.tracenull.basic;

import java.util.concurrent.atomic.AtomicInteger;

public class VolatileDemo3 {
    public static void main(String[] args) {
        MyData3 myData3 = new MyData3();
        for (int i = 0; i < 20; i++) {
            new Thread(() -> {
                for (int i1 = 0; i1 < 1000; i1++) {
                    myData3.addAtmic();
                    myData3.addPlusPlus();
                }
            }, String.valueOf(i)).start();
        }

        while (Thread.activeCount() > 2) {
            Thread.yield();
        }
        System.out.println(Thread.currentThread().getName() + "\t finally number value: " + myData3.number);
        System.out.println(Thread.currentThread().getName() + "\t AtomicInteger type,finally number  value: "
                + myData3.atomicInteger);
    }
}

class MyData3 {
    volatile int number = 0;

    public void addPlusPlus() {
        number++;
    }

    AtomicInteger atomicInteger = new AtomicInteger();

    public void addAtmic() {
        atomicInteger.getAndIncrement();
    }
}
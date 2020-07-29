package com.tracenull.basic;

import java.util.concurrent.TimeUnit;

/**
 * 验证可见性
 */
public class VolatileDemo {
    public static void main(String[] args) {
        MyData myData = new MyData();
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "\t come in");

            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            myData.addTo60();
            System.out.println(Thread.currentThread().getName() + "\t updated number: " + myData.number);
        }, "AAA").start();
        while (myData.number == 0) {
        }
        System.out.println(Thread.currentThread().getName() + "\t mission is over");

    }
}

class MyData {
    volatile int number = 0;

    public void addTo60() {
        number = 60;
    }
}
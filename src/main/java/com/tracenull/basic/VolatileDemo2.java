package com.tracenull.basic;

class MyData2 {
     volatile int number = 0;

    public void addPlusPlus() {
        number++;
    }
}

/**
 * 不保证原子性
 */
public class VolatileDemo2 {
    public static void main(String[] args) {
        MyData2 myData2 = new MyData2();
        for (int i = 0; i < 20; i++) {
            new Thread(() -> {
                for (int i1 = 0; i1 < 1000; i1++) {
                    myData2.addPlusPlus();
                }
            }, String.valueOf(i)).start();
        }
        while (Thread.activeCount() > 2) {
            Thread.yield();
        }
        System.out.println(Thread.currentThread().getName() + "\t finally number value: " + myData2.number);
    }
}

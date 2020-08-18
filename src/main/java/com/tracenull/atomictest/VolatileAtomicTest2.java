package com.tracenull.atomictest;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

public class VolatileAtomicTest2 {
    private volatile int value;


    private static long offset;
    private static Unsafe unsafe;

    static {
        try {
            Field theUnsafeField = Unsafe.class.getDeclaredField("theUnsafe");
            theUnsafeField.setAccessible(true);
            unsafe = (Unsafe) theUnsafeField.get(null);
            Field field = VolatileAtomicTest2.class.getDeclaredField("value");
            offset = unsafe.objectFieldOffset(field);//获得偏移地址
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void increment(int num) {
        int tempValue;
        do {
            tempValue = unsafe.getIntVolatile(this, offset);// 拿到值
        } while (!unsafe.compareAndSwapInt(this, offset, tempValue, value + num));// cas自旋
    }

    public static void main(String[] args) {
        Thread[] threads = new Thread[10];

        VolatileAtomicTest2 atomicInteger = new VolatileAtomicTest2();
        for (int i = 0; i < 10; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    atomicInteger.increment(1);  //自增1
                }
            });
            threads[i].start();
        }

        for (int i = 0; i < threads.length; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("x=" + atomicInteger.value);
    }
}

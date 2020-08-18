package com.tracenull.threadlocal;

import java.text.SimpleDateFormat;
import java.util.Random;

public class ThreadLocalExample implements Runnable {
    private static final ThreadLocal<SimpleDateFormat> threadLocal = ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyyMMdd HHmm"));

    @Override
    public void run() {
        System.out.println("Thread Name= " + Thread.currentThread().getName() + " default formatter = " + threadLocal.get().toPattern());

        try {
            Thread.sleep(new Random().nextInt(1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        threadLocal.set(new SimpleDateFormat());
        System.out.println("Thread Name= " + Thread.currentThread().getName() + " Formatter = " + threadLocal.get().toPattern());
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadLocalExample threadLocalExample = new ThreadLocalExample();
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(threadLocalExample, "" + i);
            Thread.sleep(new Random().nextInt(1000));
            thread.start();
        }
    }
}

package com.tracenull.basic;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

public class SemaphoreDemo {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(2, true);
        ReentrantLock reentrantLock = new ReentrantLock();
        new Thread(new MyRunnable(1, semaphore, reentrantLock), "A").start();
        new Thread(new MyRunnable(2, semaphore, reentrantLock), "B").start();
        new Thread(new MyRunnable(1, semaphore, reentrantLock), "C").start();
    }
}

class MyRunnable implements Runnable {
    private int n;
    private Semaphore semaphore;
    private ReentrantLock lock;

    public MyRunnable(int n, Semaphore semaphore, ReentrantLock lock) {
        this.n = n;
        this.semaphore = semaphore;
        this.lock = lock;
    }

    @Override
    public void run() {
        try {
            semaphore.acquire(n);
            System.out.println("剩余可用许可证：" + semaphore.drainPermits());
            System.out.println(Thread.currentThread().getName() + "执行完成。。。");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release();
        }
    }
}

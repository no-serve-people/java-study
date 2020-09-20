package com.tracenull.j20200920.atomic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * https://mp.weixin.qq.com/s/vbXAgNH9PyL16PmjgnGKZA
 */
public class CASLock {
    AtomicInteger atomicInteger = new AtomicInteger();
    Thread currentThread = null;

    public void tryLock() throws Exception {
        boolean isLock = atomicInteger.compareAndSet(0, 1);
        if (!isLock) {
            throw new Exception("加锁失败");
        }
        currentThread = Thread.currentThread();
        System.out.println(currentThread + "tryLock");
    }

    public void unlock() {
        int lockValue = atomicInteger.get();
        if (lockValue == 0) {
            return;
        }
        if (currentThread == Thread.currentThread()) {
            atomicInteger.compareAndSet(1, 0);
            System.out.println(currentThread + " unlock");
        }
    }

    public static void main(String[] args) {
        CASLock casLock = new CASLock();
        for (int i = 0; i < 5; i++) {

            new Thread(() -> {
                try {
                    casLock.tryLock();
                    Thread.sleep(10000);
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    casLock.unlock();
                }
            }).start();
        }
    }
}

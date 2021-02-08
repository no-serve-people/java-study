package com.tracenull.j20210208;

/**
 * 5.4 唤醒/等待需要synchronized锁
 * https://mp.weixin.qq.com/s/gKsD1U38h4MJczEFC33ydw
 */
public class NotifyNeedSynchronized {
    public static Object lock = new Object();

    public static void main(String[] args) throws Exception {
        // 抛出IllegalMonitorStateException
        // lock.notify();
        lock.wait();
    }
}

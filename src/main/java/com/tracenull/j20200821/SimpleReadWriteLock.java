package com.tracenull.j20200821;

import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * https://mp.weixin.qq.com/s/Pp5uf5A-PR0M3nTTQAUCxA
 */
public class SimpleReadWriteLock {
    private int readLockNum = 0;
    private int writeLockNum = 0;
    private int writeRequests = 0;

    public synchronized void acquireReadLock() throws InterruptedException {
        while (writeLockNum > 0 || writeRequests > 0) {
            wait();
        }
        readLockNum++;
    }

    public synchronized void releaseReadLock() {
        readLockNum--;
        notifyAll();
    }

    public synchronized void acquireWriteLock() throws InterruptedException {
        writeRequests++;
        while (readLockNum > 0 || writeLockNum > 0) {
            wait();
        }

        writeRequests--;
        writeLockNum++;
    }

    public synchronized void releaseWriteLock() throws InterruptedException {
        writeLockNum--;

        notifyAll();
    }
}

class ReentrantReadWriteLockDemo {
    private final Map<String, String> map = new TreeMap<String, String>();

    private final ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();

    private final Lock r = rwl.readLock();
    private final Lock w = rwl.writeLock();

    public String get(String key) {
        r.lock();
        try {
            return map.get(key);
        } finally {
            r.unlock();
        }
    }

    public String put(String key, String value) {
        w.lock();
        try {
            return map.put(key, value);
        } finally {
            w.unlock();
        }
    }

    public void clear() {
        w.lock();
        try {
            map.clear();
        } finally {
            w.unlock();
        }
    }
}

package com.tracenull.j20200918;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * https://blog.csdn.net/ljfirst/article/details/108635283?utm_source=app
 */
public class RightThreadLocalDemo4 {
    public static void main(String[] args) {
        for (int i = 0; i < 10000; i++) {
            new Task().calc(10);
            // 通过下方的Evaluate Expression 可以看出在80前后回收了 线程里面的内容
            // 但是仅仅回收了map 的 key（当前的ThreadLocal），并不是回收Value。
            // 因此存在内存溢出的问题。

            if (i == 80) {
                System.gc();
            }
        }
    }

    static class Task {
        ThreadLocal<Integer> value;
        public int calc(int i) {
            value = new ThreadLocal<>();
            value.set((value.get() == null ? 0 : value.get()) + i);

            return value.get();
        }
    }
}

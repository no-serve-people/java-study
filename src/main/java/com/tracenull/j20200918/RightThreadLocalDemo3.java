package com.tracenull.j20200918;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * https://blog.csdn.net/ljfirst/article/details/108635283?utm_source=app
 */
public class RightThreadLocalDemo3 {
    public static ExecutorService tpool = Executors.newFixedThreadPool(10);

    public static void main(String[] args) {
        Thread t = new Thread(() -> {
            Tools.tl.set("bbb");
            System.out.println(Thread.currentThread().getName() + "：======" + Tools.tl.get());
            // 这句话不加会导致后续的线程复用时，threadlocal也被复用，因此造成线程不安全
            Tools.tl.remove();
        });
        tpool.submit(t);

        Thread t2 = new Thread(() -> {
            Tools.dd();
            System.out.println(Thread.currentThread().getName() + ":======" + Tools.tl.get());
            /*
            ddd.tl.remove()：这句话不加会导致后续的线程复用时，threadlocal也被复用，因此造成线程不安全
            现象：所有的pool-1-thread-1 只会出现一次pool-1-thread-1:======bbb，
            pool-1-thread-2没有清除threadlocal，因此会出现多次 pool-1-thread-2aaaa
            */
        });

        tpool.submit(t2);

        for (int i = 0; i < 100; i++) {
            tpool.submit(() -> {
                System.out.println(Thread.currentThread().getName() + Tools.tl.get());
            });
        }
        tpool.shutdown();
    }
}

class Tools {
    static ThreadLocal<String> tl = new ThreadLocal<>();

    public static void dd() {
        tl.set("aaaa");
    }
}

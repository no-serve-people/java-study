package com.tracenull.j20200918;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * https://blog.csdn.net/ljfirst/article/details/108635283?utm_source=app
 */
public class RightThreadLocalDemo {
    public static ExecutorService tpool = Executors.newFixedThreadPool(10);

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 1000; i++) {
            int fi = i;
            tpool.submit(() -> {
                String date = new RightThreadLocalDemo().date(fi);
                System.out.println(Thread.currentThread().getName() + " " + date);
            });
        }
        Thread.sleep(100);
        tpool.shutdown();
    }

    public String date(int second) {
        Date date = new Date(1000 * second);
        SimpleDateFormat df = datefmt1.get();
        // 此处证明了ThreadLocal即使是static 对象，其在线程中也不仅仅是一个，而是以副本的形式存在于线程中
        System.out.println(Thread.currentThread().getName() + "=======" + System.identityHashCode(df));

        return df.format(date);
    }

    //此处是新建 ThreadLocal
    public static ThreadLocal<SimpleDateFormat> datefmt1 = ThreadLocal.withInitial(() -> new SimpleDateFormat("mm:ss"));
}

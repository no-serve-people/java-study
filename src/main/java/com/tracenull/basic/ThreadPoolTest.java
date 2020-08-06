package com.tracenull.basic;

import java.util.concurrent.*;

public class ThreadPoolTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        ExecutorService service = Executors.newFixedThreadPool(1);
//        Runnable r = () -> {
//            System.out.println("a");
//            System.out.println(1 / 0);
//        };
//            Future<?> submit = service.submit(r);

//            service.execute(r);

//        Object o = submit.get();
//        System.out.println(o);
//        service.shutdown();
        ThreadFactory factory = r -> {
            Thread thread = Executors.defaultThreadFactory().newThread(r);
            thread.setUncaughtExceptionHandler((t, e) -> {
                System.out.println(t + "" + e);
                e.printStackTrace();
            });
            return thread;
        };
        ExecutorService service = Executors.newFixedThreadPool(1, factory);
        Runnable r = () -> {
            System.out.println("a");
            System.out.println(1 / 0);
        };

        service.execute(r);
        service.shutdown();
    }
}

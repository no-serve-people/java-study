package com.tracenull.j20201029;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 线程池最佳线程数量到底要如何配置？
 * https://mp.weixin.qq.com/s/u-mC-HS11wAcV6r-piKq8A
 */
public class MyThreadPool implements Runnable {
    private static final ExecutorService executorService=new ThreadPoolExecutor(
            8,
            10,
            30,
            TimeUnit.SECONDS,
            new ArrayBlockingQueue<>(500),
            new ThreadPoolExecutor.AbortPolicy()
    );
    @Override
    public void run() {
        System.out.println("MyThreadPool run");
    }

    public static void main(String[] args) {
        int availableProcessors = Runtime.getRuntime().availableProcessors();

        System.out.println("线程数"+availableProcessors);
        try {
            executorService.execute(new MyThreadPool());
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            executorService.shutdown();
        }
    }
}

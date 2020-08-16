package com.tracenull.completionservice;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class JDKThreadPoolExecutorTest {
    public static void main(String[] args) throws Exception {
        ExecutorService executorService = Executors.newCachedThreadPool();
        ArrayList<Future<Integer>> list = new ArrayList<>();

        Future<Integer> future_15 = executorService.submit(() -> {
            TimeUnit.SECONDS.sleep(15);
            System.out.println("执行时长为15s的执行完成。");
            return 15;
        });

        list.add(future_15);

        Future<Integer> future_5 = executorService.submit(() -> {
            TimeUnit.SECONDS.sleep(5);
            System.out.println("执行时长为5s的执行完成。");
            return 5;
        });
        list.add(future_5);

        Future<Integer> future_10 = executorService.submit(() -> {
            TimeUnit.SECONDS.sleep(10);
            System.out.println("执行时长为10s的执行完成。");
            return 10;
        });
        list.add(future_10);

        System.out.println("开始准备获取结果");
        for (Future<Integer> future : list) {
            System.out.println("future.get() = " + future.get());
        }

        Thread.currentThread().join();
    }
}

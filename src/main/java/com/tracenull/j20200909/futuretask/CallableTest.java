package com.tracenull.j20200909.futuretask;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * https://mp.weixin.qq.com/s/H5t0Kiz0iOTTpms1VVTfaw
 */
@Slf4j
public class CallableTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable<String> callable = () -> {
            log.info("当前线程:{}", Thread.currentThread().getName());
            return "lvsshen的技术小屋";
        };
        FutureTask<String> myFutureTask = new FutureTask<>(callable);
        new Thread(myFutureTask).start();

        System.out.println(String.format("当前线程%s,取出的值%s", Thread.currentThread().getName(), myFutureTask.get()));
    }
}

package com.tracenull.j20200909.futuretask;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.locks.LockSupport;

/**
 * https://mp.weixin.qq.com/s/H5t0Kiz0iOTTpms1VVTfaw
 *
 * @param <T>
 */
@Slf4j
public class MyFutureTask<T> implements Runnable {
    Callable<T> callable;
    T result;
    volatile String state = "NEW";
    LinkedBlockingQueue<Thread> queue = new LinkedBlockingQueue<Thread>();


    public MyFutureTask(Callable<T> callable) {
        this.callable = callable;
    }

    public T get() {
        if ("END".equals(state)) {
            return result;
        }

        while (!"END".equals(state)) {
            queue.add(Thread.currentThread());
            LockSupport.park();
        }
        return result;
    }

    @Override
    public void run() {
        try {
            result = callable.call();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            state = "END";
        }
        Thread th = queue.poll();
        if (queue != null) {
            LockSupport.unpark(th);
            th = queue.poll();
        }
    }

    public static void main(String[] args) {
        Callable<String> callable = () -> {
            log.info("当前线程:{}", Thread.currentThread().getName());
            return "lvsshen的技术小屋";
        };
        // 自定futuretask
        MyFutureTask<String> myMyFutureTask = new MyFutureTask<>(callable);
        new Thread(myMyFutureTask).start();
        System.out.printf("当前线程%s,取出的值%s", Thread.currentThread().getName(), myMyFutureTask.get());
    }
}

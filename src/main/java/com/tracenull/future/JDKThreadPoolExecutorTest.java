package com.tracenull.future;

import org.omg.CORBA.TIMEOUT;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class JDKThreadPoolExecutorTest {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(2, 5, 60, TimeUnit.SECONDS, new LinkedBlockingDeque<>(10));
        AtomicInteger atomicInteger = new AtomicInteger();
//        executor.execute(() -> {
//            System.out.println("why技术");
//        });
//
//        Thread.currentThread().join();
        Future<?> future = executor.submit(() -> {
            System.out.println("关注why技术");
            // 在这里进行计算逻辑
            atomicInteger.set(5201314);
//            return "这次一定";
        },atomicInteger);

        System.out.println("future的内容：" + future.get());
        Thread.currentThread().join();

    }
}

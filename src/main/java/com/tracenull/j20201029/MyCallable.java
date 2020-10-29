package com.tracenull.j20201029;

import java.util.concurrent.*;

/**
 * 线程池最佳线程数量到底要如何配置？
 * https://mp.weixin.qq.com/s/u-mC-HS11wAcV6r-piKq8A
 */
public class MyCallable implements Callable {

    @Override
    public Object call() throws Exception {
        System.out.println("Mycallable call");
        return "success";
    }

    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newSingleThreadExecutor();

        try {
            Future<String> future = threadPool.submit(new MyCallable());
            System.out.println(future.get());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            threadPool.shutdown();
        }
    }
}

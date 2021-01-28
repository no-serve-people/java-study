package com.tracenull.j20210128.inheritablethreadlocal;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Java 多线程上下文传递在复杂场景下的实践
 * https://mp.weixin.qq.com/s/JXHsdLwujT0pRKIImA1-3g
 */
public class InheritableThreadLocalTest01 {
    static InheritableThreadLocal<String> inheritableThreadLocal = new InheritableThreadLocal<>();

    // step1
//    public static void main(String[] args) throws InterruptedException {
//        ExecutorService executorService = Executors.newFixedThreadPool(1);
//        inheritableThreadLocal.set("i am a inherit parent");
//        executorService.execute(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println(inheritableThreadLocal.get());
//            }
//        });
//
//        TimeUnit.SECONDS.sleep(1);
//        inheritableThreadLocal.set("i am a new inherit parent");// 设置新的值
//
//        executorService.execute(new Runnable() {
//            @Override
//            public void run() {
//
//                System.out.println(inheritableThreadLocal.get());
//            }
//        });
//
//    }

    // step2
    public static void main(String[] args) throws InterruptedException {

        ExecutorService executorService = Executors.newFixedThreadPool(1);

        inheritableThreadLocal.set("i am a inherit parent");
        executorService.execute(new Runnable() {
            @Override
            public void run() {

                System.out.println(inheritableThreadLocal.get());
                inheritableThreadLocal.set("i am a old inherit parent");// 子线程中设置新的值


            }
        });

        TimeUnit.SECONDS.sleep(1);
        inheritableThreadLocal.set("i am a new inherit parent");// 主线程设置新的值

        executorService.execute(new Runnable() {
            @Override
            public void run() {

                System.out.println(inheritableThreadLocal.get());
            }
        });
    }

}

package com.tracenull.j20201012.order;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * https://mp.weixin.qq.com/s/BTUZM32NwmAywjsuiX_Xvg
 * 使用单个线程池
 */
public class ThreadLoopThree {
    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("thread start : " + Thread.currentThread().getName() + " run one");
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("thread start : " + Thread.currentThread().getName() + " run two");
            }
        });

        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("thread start : " + Thread.currentThread().getName() + " run three");
            }
        });

        ExecutorService executor = Executors.newSingleThreadExecutor();
        // 将线程依次加入到线程池中
        executor.submit(t1);
        executor.submit(t2);
        executor.submit(t3);
        // 及时将线程池关闭
        executor.shutdown();
    }
}

package com.tracenull.j20210128;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicIntegerArray;

/**
 * 数组类型原子类
 * https://mp.weixin.qq.com/s/nq9xaZ9nGcEOx4_oPgW8EA
 */
public class AtomicExample7 {
    static AtomicIntegerArray pageRequest = new AtomicIntegerArray(new int[10]);

    // 模拟访问一次
    public static void request(int page) throws InterruptedException {
        // 模拟耗时5毫秒
        TimeUnit.MILLISECONDS.sleep(5);
        // pageCountIndex为pageCount数组的下标，表示页面对应数组中的位置
        int pageCountIndex = page - 1;
        pageRequest.incrementAndGet(pageCountIndex);
    }

    public static void main(String[] args) throws InterruptedException {
        long startTime = System.currentTimeMillis();

        int threadSize = 100;
        // 100个形成一组
        CountDownLatch countDownLatch = new CountDownLatch(threadSize);
        // 开100个线程
        for (int i = 0; i < threadSize; i++) {
            Thread thread = new Thread(() -> {
                // 每个线程访问10页
                try {
                    for (int page = 1; page <= 10; page++) {
                        // 每页10次
                        for (int i1 = 0; i1 < 10; i1++) {
                            try {
                                request(page);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    // 每次都减少一次
                    countDownLatch.countDown();
                }
            });
            thread.start();
        }

        countDownLatch.await();
        long endTime = System.currentTimeMillis();
        System.out.println(Thread.currentThread().getName() + ",耗时：" + (endTime - startTime));

        for (int pageIndex = 0; pageIndex < 10; pageIndex++) {
            System.out.println("第" + (pageIndex + 1) + "个页面访问次数为" + pageRequest.get(pageIndex));
        }
    }
}

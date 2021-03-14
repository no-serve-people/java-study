package com.tracenull.j20210314;

import java.util.Random;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * https://mp.weixin.qq.com/s/ouaUOfN2EFpbnaJrvk1B7w
 * Semaphore
 */
public class SemaphoreDemo {
    public static void main(String[] args) {
        SemaphoreDemo semaphoreDemo = new SemaphoreDemo();
        int count = 9;

        CyclicBarrier cyclicBarrier = new CyclicBarrier(count);

        Semaphore semaphore = new Semaphore(5);

        for (int i = 0; i < count; i++) {
            String vipNo = "vip-00" + i;
            new Thread(() -> {
                try {
                    cyclicBarrier.await();
                    boolean tryAcquire = semaphore.tryAcquire(3000L, TimeUnit.MICROSECONDS);
                    if (!tryAcquire) {
                        System.out.println("获取令牌失败：" + vipNo);
                    }
                    // 执行操作逻辑-这里模拟访问数据库
                    System.out.println("当前线程" + Thread.currentThread().getName());
                    semaphoreDemo.service(vipNo);
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    semaphore.release();
                }
            }).start();
        }
    }


    public void service(String vipNo) throws InterruptedException {
        System.out.println("楼上出来迎接贵宾一位，贵宾编号" + vipNo + ",...");
        Thread.sleep(new Random().nextInt(3000));
        System.out.println("欢迎贵宾出门，贵宾编号" + vipNo);
    }
}

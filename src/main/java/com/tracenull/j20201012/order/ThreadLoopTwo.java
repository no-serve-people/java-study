package com.tracenull.j20201012.order;

import java.util.concurrent.CountDownLatch;

/**
 * https://mp.weixin.qq.com/s/BTUZM32NwmAywjsuiX_Xvg
 * CountDownLatch
 */
public class ThreadLoopTwo {
    public static void main(String[] args) {
        // 设置线程 1 的信号量为 0
        CountDownLatch cOne = new CountDownLatch(0);
        // 设置线程 2 的信号量为 1
        CountDownLatch cTwo = new CountDownLatch(1);
        // 设置线程 3 的信号量为 1
        CountDownLatch cThree = new CountDownLatch(1);
        // 因为 cOne 为 0 ,故 t1 可以直接执行
        Thread t1 = new Thread(new Work(cOne, cTwo));
        // 线程 t1 执行完毕之后,此时的 cTwo 为 0 , t2 开始执行
        Thread t2 = new Thread(new Work(cTwo, cThree));
        // 线程 t2 执行完毕,此时 cThree 为 0 , t3 开始执行
        Thread t3 = new Thread(new Work(cThree, cThree));

        t1.start();
        t2.start();
        t3.start();
    }

    static class Work implements Runnable {

        CountDownLatch cOne;
        CountDownLatch cTwo;

        public Work(CountDownLatch cOne, CountDownLatch cTwo) {
            super();
            this.cOne = cOne;
            this.cTwo = cTwo;
        }

        @Override
        public void run() {
            try {
                // 当前一个线程信号量为 0 时,才执行
                cOne.await();
                System.out.println("thread start : " + Thread.currentThread().getName());
                // 后一个线程信号量减 1
                cTwo.countDown();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

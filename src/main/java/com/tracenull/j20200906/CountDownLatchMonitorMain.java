package com.tracenull.j20200906;

/**
 * https://mp.weixin.qq.com/s/SmRcVLNlTVtFGobu028CmA
 */
public class CountDownLatchMonitorMain {
    public static void main(String[] args) throws Exception {
        final Object monitor = new Object();
        new Thread(() -> {
            String threadName = Thread.currentThread().getName();
            System.out.println(String.format("线程%s准备调用wait方法......", threadName));
            block0(monitor);
            System.out.println(String.format("线程%s解除阻塞继续运行......", threadName));
        }, "firstThread").start();

        Thread.sleep(500L);
        new Thread(() -> {
            String threadName = Thread.currentThread().getName();
            System.out.println(String.format("线程%s准备调用wait方法......", threadName));
            block0(monitor);
            System.out.println(String.format("线程%s解除阻塞继续运行......", threadName));
        }, "secondThread").start();
        Thread.sleep(500L);
        System.out.println("main线程notifyAll......");

        wakeup0(monitor);
        Thread.sleep(Long.MAX_VALUE);
    }

    private static void block0(Object monitor) {
        synchronized (monitor) {
            try {
                monitor.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static void wakeup0(Object monitor) {
        synchronized (monitor) {
            monitor.notifyAll();
        }
    }
}

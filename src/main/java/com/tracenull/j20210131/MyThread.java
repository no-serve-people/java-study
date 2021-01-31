package com.tracenull.j20210131;

/**
 * 腾讯面试官：如何停止一个正在运行的线程？我一脸蒙蔽。。。
 * https://mp.weixin.qq.com/s/u8gKEqW5-g09Q3Lc2jXAUA
 */
public class MyThread extends Thread {
    @Override
    public void run() {
        super.run();
        for (int i = 0; i < 500000; i++) {
            System.out.println("i=" + (i + 1));
        }
    }
}

class Run {
    public static void main(String[] args) {
        MyThread thread = new MyThread();
        thread.start();

        try {
            // 1. 停止不了的线程
            Thread.sleep(2000);
            thread.interrupt();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

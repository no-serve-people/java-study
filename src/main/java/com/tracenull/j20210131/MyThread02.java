package com.tracenull.j20210131;

/**
 * 腾讯面试官：如何停止一个正在运行的线程？我一脸蒙蔽。。。
 * https://mp.weixin.qq.com/s/u8gKEqW5-g09Q3Lc2jXAUA
 */
public class MyThread02 extends Thread {
    @Override
    public void run() {
        super.run();

        for (int i = 0; i < 500000; i++) {
            i++;
        }
    }
}

class Run02 {

    public static void main(String[] args) {
//        MyThread02 thread = new MyThread02();
//        thread.start();
//
//        try {
//            Thread.sleep(2000);
//            thread.interrupt();
//
//            System.out.println("stop 1??" + thread.interrupted());
//            System.out.println("stop 2??" + thread.interrupted());
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        Thread.currentThread().interrupt();

        System.out.println("stop 1??" + Thread.interrupted());
        System.out.println("stop 2??" + Thread.interrupted());

        System.out.println("End");
    }
}

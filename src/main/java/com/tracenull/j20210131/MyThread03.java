package com.tracenull.j20210131;

/**
 * 腾讯面试官：如何停止一个正在运行的线程？我一脸蒙蔽。。。
 * https://mp.weixin.qq.com/s/u8gKEqW5-g09Q3Lc2jXAUA
 */
public class MyThread03 extends Thread {
    public void run() {
        super.run();
        for (int i = 0; i < 500000; i++) {
            if (this.interrupted()) {
                System.out.println("线程已经终止， for循环不再执行");
                break;
            }
            System.out.println("i=" + (i + 1));
        }
    }
}

class Run03 {
    public static void main(String args[]) {
        Thread thread = new MyThread03();
        thread.start();
        try {
            Thread.sleep(2000);
            thread.interrupt();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
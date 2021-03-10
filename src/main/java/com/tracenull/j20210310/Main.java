package com.tracenull.j20210310;

/**
 * https://blog.csdn.net/DTXK1024/article/details/106545618
 * Java多线程情况下保持全局变量线程安全 在多线程中，想要安全地改变全局变量，需要使用关键字Synchronized
 */
public class Main {
    static int data1 = 0;
    static int data2 = 0;
    static ThreadSafeClass tsc = new ThreadSafeClass();

    public static void main(String[] args) {
        ThreadTest t1 = new ThreadTest();
        ThreadTest t2 = new ThreadTest();
        t1.start();
        t2.start();

        Thread main = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(50);
                    System.out.println("data1:" + String.valueOf(data1));
                    System.out.println("data2:" + String.valueOf(data2) + "(synchronized)");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        main.start();
    }

    /**
     * 测试用线程
     *
     * @author TangSky
     */
    public static class ThreadTest extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 10000; i++) {
                // 改变变量1，采用赋值方式，不用自加方式
                int tmp = data1;
                tmp += 2;
                data1 = tmp;
                // 改变变量2
                tsc.change();
            }
        }
    }

    /**
     * 安全地改变全局变量
     *
     * @author TangSky
     */
    public static class ThreadSafeClass {
        public synchronized void change() {
            // 与data1统一采用赋值方式
            int tmp = data2;
            tmp += 2;
            data2 = tmp;
        }
    }
}

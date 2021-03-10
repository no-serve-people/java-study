package com.tracenull.j20210310;

/**
 * https://blog.csdn.net/happydecai/article/details/84435360
 * 【多线程】java多线程全局变量共享问题
 */
public class Counter {

    private int x = 0;

    // 计数方法
    public void count() {
        for (int i = 0; i < 10; i++) {
            x = x + i;
        }
        System.out.println(Thread.currentThread().getName() + "--" + x);
    }

    public static void main(String[] args) {
        // 定义线程实现接口
        Runnable runnable = new Runnable() {
            Counter counter = new Counter();

            @Override
            public void run() {
                counter.count();
            }
        };

        for (int i = 0; i < 10; i++) {
            new Thread(runnable).start();
        }
    }

}
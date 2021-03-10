package com.tracenull.j20210310;

/**
 * https://blog.csdn.net/happydecai/article/details/84435360
 * ThreadLocal
 */
public class Counter02 {
    ThreadLocal<Integer> th = new ThreadLocal<Integer>() {
        @Override
        protected Integer initialValue() {
            return 0;
        }
    };

    public static void main(String[] args) {

        Counter02 counter02 = new Counter02();
        counter02.count();

    }


    // 计数方法
    public void count() {
        for (int i = 0; i < 10; i++) {
            th.set(th.get() + i);
        }

        System.out.println(Thread.currentThread().getName() + "--" + th.get());
    }
}

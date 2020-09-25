package com.tracenull.j20200925;

/**
 * https://juejin.im/post/6861885337568804871
 */
public class VolatileResort {
    static int num = 0;
//    static boolean flag = false;
    static volatile boolean flag = false;

    public static void init() {
        num = 1;
        flag = true;
    }

    public static void add() {
        if (flag) {
            num = num + 5;
            System.out.println("num:" + num);
        }
    }

    public static void main(String[] args) {
        init();
        new Thread(() -> {
            add();
        }, "子线程").start();
    }
}

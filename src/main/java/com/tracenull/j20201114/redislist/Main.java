package com.tracenull.j20201114.redislist;

public class Main {
    public static void main(String[] args) {
        // 启动生产者
        new Thread(new Producer()).start();
        // 启动消费者
        new Thread(new Consumer()).start();
    }
}

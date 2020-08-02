package com.tracenull.basic;

public class ThreadLocalDemo {
    public static void main(String[] args) {
        final ThreadLocal threadLocal = new InheritableThreadLocal();
        threadLocal.set("帅的一笔");

        new Thread(() -> {
            System.out.println("张三帅么 =" + threadLocal.get());
        }).start();
        threadLocal.remove();
    }
}

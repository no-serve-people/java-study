package com.tracenull.j20200918;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * https://blog.csdn.net/ljfirst/article/details/108635283?utm_source=app
 */
public class RightThreadLocalDemo2 {
    static ThreadLocal<User> tl = new ThreadLocal<>();

    public static ExecutorService tpool = Executors.newFixedThreadPool(10);

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            int fg = i;
            tpool.submit(() -> {
                new Service1().service("ljfirst---" + fg);
            });
        }

        tpool.shutdown();
    }
}

class Service1 {
    public void service(String n) {
        User u = new User(n);
        RightThreadLocalDemo2.tl.set(u);
        new Service2().service();
    }
}

class Service2 {
    public void service() {
        User u = RightThreadLocalDemo2.tl.get();
        System.out.println(Thread.currentThread().getName() + "   ---Service2().service():  " + u.name);
        new Service3().service();
    }
}

class Service3 {
    public void service() {
        User u = RightThreadLocalDemo2.tl.get();
        System.out.println(Thread.currentThread().getName() + "   ---Service3().service():  " + u.name);
        new Service4().service();
    }
}

class Service4 {
    public void service() {
        User u = RightThreadLocalDemo2.tl.get();
        System.out.println(Thread.currentThread().getName() + "   ---Service4().service():  " + u.name);
        //不用的时候记得remove
        RightThreadLocalDemo2.tl.remove();
    }
}

class User {
    String name;

    public User(String name) {
        this.name = name;
    }
}

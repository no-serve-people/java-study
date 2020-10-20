package com.tracenull.j20201020;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * https://mp.weixin.qq.com/s/wk9Dr57D8FmfnGFKohhHqA
 */
public class Buf {
    private final int MAX = 5;
    private final ArrayList<Integer> list = new ArrayList<>();

    synchronized void put(int v) throws InterruptedException {
//        if (list.size() == MAX) {
        while (list.size() == MAX) {
            wait();
        }
        list.add(v);
        notifyAll();
    }

    synchronized int get() throws InterruptedException {
        if (list.size() == 0) {
            wait();
        }
        int v = list.remove(0);
        notifyAll();
        return v;
    }

    synchronized int size() {
        return list.size();
    }

    public static void main(String[] args) {
//        final Buf buf = new Buf();
//        ExecutorService es = Executors.newFixedThreadPool(11);
//        for (int i = 0; i < 1; i++) {
//            es.execute(() -> {
//                while (true) {
//                    try {
//                        buf.put(1);
//                        Thread.sleep(20);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                        break;
//                    }
//                }
//            });
//        }
//
//        for (int i = 0; i < 10; i++) {
//            es.execute(() -> {
//                while (true) {
//                    try {
//                        buf.get();
//                        Thread.sleep(10);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                        break;
//                    }
//                }
//            });
//        }
        final Buf buf = new Buf();
        ExecutorService es = Executors.newFixedThreadPool(11);
        ScheduledExecutorService printer = Executors.newScheduledThreadPool(1);
        printer.scheduleAtFixedRate(() -> {
            System.out.println(buf.size());
        }, 0, 1, TimeUnit.SECONDS);

        for (int i = 0; i < 10; i++) {
            es.execute(() -> {
                while (true) {
                    try {
                        buf.put(1);
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        break;
                    }
                }
            });
        }

        for (int i = 0; i < 1; i++) {
            es.execute(() -> {
                while (true) {
                    try {
                        buf.get();
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        break;
                    }
                }
            });
        }

    }
}

package com.tracenull.j20210318;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * 我们首先先来看下关于使用CyclicBarrier的一个demo：比如游戏中有个关卡的时候，每次进入下一关的时候都需要进行加载一些地图、特效背景音乐什么的只有全部加载完了才能够进行游戏:
 * https://mp.weixin.qq.com/s/fNFeMsCRgriGsw3lo19kdA
 */
public class CyclicBarrierExample {
    static class PreTaskThread implements Runnable {
        private String task;
        private CyclicBarrier cyclicBarrier;

        public PreTaskThread(String task, CyclicBarrier cyclicBarrier) {
            this.task = task;
            this.cyclicBarrier = cyclicBarrier;
        }

        @Override
        public void run() {
            for (int i = 0; i < 4; i++) {
                Random random = new Random();
                try {
                    Thread.sleep(random.nextInt(1000));
                    System.out.println(String.format("关卡%d的任务%s完成", i, task));
                    cyclicBarrier.await();
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }
        }

        public static void main(String[] args) {
            CyclicBarrier cyclicBarrier = new CyclicBarrier(3, () -> {
                System.out.println("本关卡所有的前置任务完成,开始游戏....");
            });
            new Thread(new PreTaskThread("加载地图数据", cyclicBarrier)).start();
            new Thread(new PreTaskThread("加载人物模型", cyclicBarrier)).start();
            new Thread(new PreTaskThread("加载背景音乐", cyclicBarrier)).start();
        }
    }
}

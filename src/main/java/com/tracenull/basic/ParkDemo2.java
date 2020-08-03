package com.tracenull.basic;

import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class ParkDemo2 {
    public static void main(String[] args) {
        Integer parkSpace2 = 3;
        System.out.println("这里有" + parkSpace2 + "个停车位,先到先得啊！");
        Semaphore semaphore = new Semaphore(parkSpace2, true);

        Thread threadA = new Thread(new ParkCar2(1, "布加迪", semaphore), "赵四");
        Thread threadB = new Thread(new ParkCar2(2, "法拉利", semaphore), "刘能、谢广坤");
        Thread threadC = new Thread(new ParkCar2(1, "劳斯莱斯", semaphore), "why哥");

        threadA.start();
        threadC.start();
        threadB.start();
        //模拟大爷劝退
        threadB.interrupt();
    }
}

class ParkCar2 implements Runnable {

    private int n;
    private String carName;
    private Semaphore semaphore;

    public ParkCar2(int n, String carName, Semaphore semaphore) {
        this.n = n;
        this.carName = carName;
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        if (semaphore.availablePermits() < n) {
            System.out.println(Thread.currentThread().getName() + "来停车,但是停车位不够了,等着吧");
        }
        try {
            semaphore.acquire(n);
        } catch (InterruptedException e) {
            // 如果出现终端立即返回
            System.err.println(Thread.currentThread().getName() + "被门口大爷劝走了。");
            return;
        }
        try {

            System.out.println(Thread.currentThread().getName() + "把自己的" + carName + "停进来了," + "剩余停车位:" + semaphore.availablePermits() + "辆");
            //模拟停车时长
            int parkTime = ThreadLocalRandom.current().nextInt(1, 6);
            TimeUnit.SECONDS.sleep(parkTime);
            System.out.println(Thread.currentThread().getName() + "把自己的" + carName + "开走了,停了" + parkTime + "小时");
        } catch (InterruptedException e) {
//            System.err.println(Thread.currentThread().getName() + "被门口大爷劝走了。");
        } finally {
            semaphore.release(n);
            System.out.println(Thread.currentThread().getName() + "走后,剩余停车位:" + semaphore.availablePermits() + "辆");
        }
    }
}

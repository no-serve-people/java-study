package com.tracenull.j20201208;

import lombok.Getter;
import lombok.Setter;

import java.text.DateFormat;
import java.util.Date;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * Java自带的延迟队列
 * https://mp.weixin.qq.com/s/bYv_uUztHhr6sSatldUQYA
 */
public class DelayQueueTest {
    private static DelayQueue delayQueue = new DelayQueue();

    public static void main(String[] args) throws Exception {
        producer();
        consumer();
    }

    public static void producer() {
        delayQueue.put(new MyDelay(1000, "消息1"));
        delayQueue.put(new MyDelay(3000, "消息2"));
    }

    public static void consumer() throws Exception {
        System.out.println("开始执行时间：" + DateFormat.getDateTimeInstance().format(new Date()));
        while (!delayQueue.isEmpty()) {
            System.out.println(delayQueue.take());
        }
        System.out.println("结束执行时间：" + DateFormat.getDateTimeInstance().format(new Date()));
    }

    static class MyDelay implements Delayed {

        long delayTime = System.currentTimeMillis();

        @Getter
        @Setter
        private String msg;

        public MyDelay(long delayTime, String msg) {
            this.delayTime = (this.delayTime + delayTime);
            this.msg = msg;
        }

        @Override
        public long getDelay(TimeUnit unit) {
            return unit.convert(delayTime - System.currentTimeMillis(), TimeUnit.MILLISECONDS);
        }

        @Override
        public int compareTo(Delayed o) {
            if (this.getDelay(TimeUnit.MILLISECONDS) > o.getDelay(TimeUnit.MILLISECONDS)) {
                return 1;
            } else if (this.getDelay(TimeUnit.MILLISECONDS) < o.getDelay(TimeUnit.MILLISECONDS)) {
                return -1;
            } else {
                return 0;
            }
        }

        @Override
        public String toString() {
            return this.msg;
        }
    }
}

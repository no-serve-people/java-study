package com.tracenull.j20210324;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * java并发编程工具类JUC第三篇:DelayQueue延时队列
 * https://juejin.cn/post/6942992107648843812
 */
public class DelayObject implements Delayed {
    private String name;
    private long time; // 延时时间

    public DelayObject(String name, long delayTime) {
        this.name = name;
        this.time = System.currentTimeMillis() + delayTime;
    }

    @Override
    public long getDelay(TimeUnit unit) {
        long diff = time - System.currentTimeMillis();

        return unit.convert(diff, TimeUnit.MICROSECONDS);
    }

    @Override
    public int compareTo(Delayed obj) {
        if (this.time < ((DelayObject) obj).time) {
            return -1;
        }
        if (this.time > ((DelayObject) obj).time) {
            return 1;
        }
        return 0;
    }

    @Override
    public String toString() {
        Date date = new Date(time);
        SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        return "\nDelayObject{" +
                "name='" + name + '\'' +
                ", time=" + sd.format(date) +
                '}';
    }
}

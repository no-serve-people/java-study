package com.tracenull.j20210324;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.DelayQueue;

public class DelayObjectTest {

    @Test
    public void testDelayObject() throws InterruptedException {
        // 实例化一个delayqueue
        BlockingQueue<DelayObject> DQ = new DelayQueue<>();
        // 向DelayQueue添加四个元素对象，注意延时时间不同

        DQ.add(new DelayObject("A", 1000 * 10));// 延时10秒
        DQ.add(new DelayObject("B", 4000 * 10));  //延时40秒
        DQ.add(new DelayObject("C", 3000 * 10));  //延时30秒
        DQ.add(new DelayObject("D", 2000 * 10));  //延时20秒

        SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        //将对象从DelayQueue取出，注意取出的顺序与延时时间有关
        System.out.println(DQ.take());  //取出A
        System.out.println(DQ.take());  //取出D
        System.out.println(DQ.take());  //取出C
        System.out.println(DQ.take());  //取出B

    }
}
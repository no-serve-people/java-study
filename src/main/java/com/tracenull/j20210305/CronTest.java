package com.tracenull.j20210305;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

/**
 * 定时轮询
 * https://www.cnblogs.com/xinrong2019/p/14295782.html
 */
public class CronTest {
    public static void main(String[] args) {
        //  方案1 * 定时轮询
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
//
//        Timer timer = new Timer();
//
//        TimerTask timerTask = new TimerTask() {
//            @Override
//            public void run() {
//                System.out.println("用户没有付款，交易取消:" +
//                        simpleDateFormat.format(new Date(System.currentTimeMillis())));
//
//                timer.cancel();
//            }
//        };
//
//        System.out.println("等待用户付款：" + simpleDateFormat.format(new Date(System.currentTimeMillis())));
//        // 10s后执行 timerTask
//        timer.schedule(timerTask, 10 * 1000);
        // 方案2 ScheduledExecutorService
        SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");

        ThreadFactory factory = Executors.defaultThreadFactory();

        // 使用线程池
        ScheduledThreadPoolExecutor service = new ScheduledThreadPoolExecutor(10, factory);
        System.out.println("等待用户付款10s：" + format.format(new Date(System.currentTimeMillis())));


        service.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("用户未付款，交易取消：" + format.format(new Date()));
            }
        }, 10, TimeUnit.SECONDS);
    }
}

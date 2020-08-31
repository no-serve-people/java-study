package com.tracenull.j20200831;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * https://mp.weixin.qq.com/s/WqYmB9G1TDPHL1YP4r6B9g
 */
public class ConcurrentHashMapDemo {
    public final static int THREAD_POOL_SIZE = 5;

    public static void main(String[] args) throws InterruptedException {
        // 方案1 性能好
//        Map<String, String> map = new ConcurrentHashMap<>();
        // 方案2 性能一般
        Map<String, String> map = Collections.synchronizedMap(new HashMap<>());

        long startTime = System.nanoTime();
        ExecutorService crunchifyExServer = Executors.newFixedThreadPool(THREAD_POOL_SIZE);

        for (int i = 0; i < THREAD_POOL_SIZE; i++) {
            crunchifyExServer.execute(new Runnable() {
                @SuppressWarnings("unused")
                @Override
                public void run() {
                    for (int i1 = 0; i1 < 500000; i1++) {
                        map.put("itwang" + i1, "沉默王二");
                    }
                }
            });
        }

        crunchifyExServer.shutdown();
        crunchifyExServer.awaitTermination(Long.MAX_VALUE, TimeUnit.DAYS);
        long endTime = System.nanoTime();

        long totalTime = (endTime - startTime) / 1000000L;

        System.out.println(totalTime + "ms");
    }

}

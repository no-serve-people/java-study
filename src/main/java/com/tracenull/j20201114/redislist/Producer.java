package com.tracenull.j20201114.redislist;

import redis.clients.jedis.Jedis;

/**
 * redis之延时队列
 * https://mp.weixin.qq.com/s/p1Vmi3MKmcpnDkqGmHhR9Q
 */
public class Producer implements Runnable {

    @Override
    public void run() {
        Jedis jedis = RedisConnection.getConnection();

        int i = 0;

        while (true) {
            String s = String.valueOf(i++);
            // 生产者往队列里写入数据
            jedis.rpush("MSG_PIPELINE", s);
            System.out.println("Producer write in redis = " + s);

            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                System.out.println("生产者线程被打断");
            }
        }
    }
}

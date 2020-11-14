package com.tracenull.j20201114.redislist;

import redis.clients.jedis.Jedis;

import java.util.List;

public class Consumer implements Runnable {
    @Override
    public void run() {
        // 消费者使用阻塞读来实现未读取到消息时线程等待
        Jedis jedis = RedisConnection.getConnection();
        while (true) {
            /**
             * int timeout 单次等待超时时间。如果超过这个时间没有获取到队列中的消息，则会返回null，
             *             并且再次重试获取队列中的消息
             * String key  redis List 的key
             */
            List<String> rpop = jedis.brpop(10, "MSG_PIPELINE");

            System.out.println("Consumer read redis = " + rpop);
        }
    }
}

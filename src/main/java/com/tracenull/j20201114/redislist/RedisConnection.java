package com.tracenull.j20201114.redislist;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class RedisConnection {
    private static String host = "localhost";
    private static int port = 6379;
    private static String password = "123456";

    public static Jedis getConnection() {
        JedisPoolConfig config = new JedisPoolConfig();
        JedisPool jedisPool = new JedisPool(config, host, port, 1000, password);
        return jedisPool.getResource();
    }
}

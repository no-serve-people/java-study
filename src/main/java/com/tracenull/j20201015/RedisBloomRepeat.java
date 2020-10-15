package com.tracenull.j20201015;

import redis.clients.jedis.Jedis;

import java.util.Arrays;

/**
 * https://mp.weixin.qq.com/s/13gVM8ufQN-qrVdAA_yvLQ
 * Redis 布隆过滤器去重
 */
public class RedisBloomRepeat {
    // 布隆过滤器 key
    private static final String _KEY = "URLREPEAT_KEY";
    // 待去重 URL
    public static final String[] URLS = {
            "www.apigo.cn",
            "www.baidu.com",
            "www.apigo.cn"
    };

    public static void main(String[] args) {
        Jedis jedis = new Jedis("127.0.0.1", 6379);
        jedis.auth("123456");

        for (int i = 0; i < URLS.length; i++) {
            String url = URLS[i];
            boolean exists = bfExists(jedis, _KEY, url);
            if (exists) {
                // 重复的 URL
                System.out.println("URL 已存在了：" + url);
            } else {
                bfAdd(jedis, _KEY, url);
            }
        }
    }

    /**
     * 添加元素
     *
     * @param jedis Redis 客户端
     * @param key   key
     * @param value value
     * @return boolean
     */
    public static boolean bfAdd(Jedis jedis, String key, String value) {
        String luaStr = "return redis.call('bf.add', KEYS[1], KEYS[2])";
        Object result = jedis.eval(luaStr, Arrays.asList(key, value), Arrays.asList());

        if (result.equals(1L)) {
            return true;
        }
        return false;
    }

    /**
     * 查询元素是否存在
     *
     * @param jedis Redis 客户端
     * @param key   key
     * @param value value
     * @return boolean
     */
    public static boolean bfExists(Jedis jedis, String key, String value) {
        String luaStr = "return redis.call('bf.exists', KEYS[1], KEYS[2])";
        Object result = jedis.eval(luaStr, Arrays.asList(key, value),
                Arrays.asList());
        if (result.equals(1L)) {
            return true;
        }
        return false;
    }
}

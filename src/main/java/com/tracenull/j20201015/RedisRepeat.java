package com.tracenull.j20201015;

import redis.clients.jedis.Jedis;

/**
 * Redis Set 集合去重
 * https://mp.weixin.qq.com/s/13gVM8ufQN-qrVdAA_yvLQ
 */
public class RedisRepeat {
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
            Long result = jedis.sadd("urlrepeat", url);
            if (result == 0) {
                // 重复的 URL
                System.out.println("URL 已存在了：" + url);
            }
        }
    }
}

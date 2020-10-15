package com.tracenull.j20201015;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;

import java.nio.charset.Charset;

/**
 * Guava 布隆过滤器去重
 * https://mp.weixin.qq.com/s/13gVM8ufQN-qrVdAA_yvLQ
 */
public class GuavaRepeat {
    // 待去重 URL
    public static final String[] URLS = {
            "www.apigo.cn",
            "www.baidu.com",
            "www.apigo.cn"
    };

    public static void main(String[] args) {
        BloomFilter<String> filter = BloomFilter.create(Funnels.stringFunnel(Charset.defaultCharset()), 10, // 期望处理的元素数量
                0.01);// 期望的误报概率

        for (int i = 0; i < URLS.length; i++) {
            String url = URLS[i];
            if (filter.mightContain(url)) {
                // 用重复的 URL
                System.out.println("URL 已存在了：" + url);
            } else {
                // 将 URL 存储在布隆过滤器中
                filter.put(url);
            }
        }
    }
}

package com.tracenull.j20201015;

import java.util.HashSet;
import java.util.Set;

/**
 * 使用 Java 的 Set 集合判重
 * https://mp.weixin.qq.com/s/13gVM8ufQN-qrVdAA_yvLQ
 */
public class URLRepeat {
    // 待去重 URL
    public static final String[] URLS = {
            "www.apigo.cn",
            "www.baidu.com",
            "www.apigo.cn"
    };

    public static void main(String[] args) {
        Set<String> set = new HashSet();
        for (int i = 0; i < URLS.length; i++) {
            String url = URLS[i];

            boolean result = set.add(url);
            if (!result) {
                // 重复的 URL
                System.out.println("URL 已存在了：" + url);
            }
        }
    }


}

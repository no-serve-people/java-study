package com.tracenull.j20201208;

import org.junit.Test;

/**
 * https://mp.weixin.qq.com/s/kTrx3T3e1w4EcFYyQcw9PQ
 * 高并发下如何生成随机数
 * 使用Random生成随机数
 */
public class TestRandom {
    @Test
    public void testRandom() {
        for (int i = 0; i < 10; i++) {
            double random = Math.random();
            System.out.println(random);
        }
    }
}

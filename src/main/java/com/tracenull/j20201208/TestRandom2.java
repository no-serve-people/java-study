package com.tracenull.j20201208;

import java.util.concurrent.ThreadLocalRandom;

/**
 * 使用ThreadLocalRandom生成随机数
 * https://mp.weixin.qq.com/s/kTrx3T3e1w4EcFYyQcw9PQ
 */
public class TestRandom2 {
    public static void main(String[] args) {
        new TestRandom2().testThreadLocalRandom();
    }

    public void testThreadLocalRandom() {
        for (int i = 0; i < 3; i++) {
            new Thread(() ->
                    System.out.println(Thread.currentThread().getName() + ":" +
                            ThreadLocalRandom.current().nextDouble())).start();
        }
    }
}

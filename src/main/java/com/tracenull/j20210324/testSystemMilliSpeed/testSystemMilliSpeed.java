package com.tracenull.j20210324.testSystemMilliSpeed;

import org.junit.Test;

/**
 * 缓慢的System.currentTimeMillis() - 疑问号
 * https://juejin.cn/post/6942539017476898847?utm_source=gold_browser_extension
 */
public class testSystemMilliSpeed {
    @Test
    public void testSystemMilliSpeed() {
        long sum = 0;
        long t1 = System.currentTimeMillis();
        for (int i = 0; i < 50000000; i++) {
            sum += System.currentTimeMillis();
        }


        long t2 = System.currentTimeMillis();

        System.out.println("[System.currentTimeMillis()] Sum = " + sum + "; time spent = " + (t2 - t1) +
                " ms; or " + (t2 - t1) * 1.0E6 / 50000000 + " ns / iter");

    }
}

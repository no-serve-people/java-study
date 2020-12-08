package com.tracenull.j20201208;

import java.util.concurrent.ConcurrentSkipListMap;

/**
 * 跳表在Java中的应用
 * https://mp.weixin.qq.com/s/SYE8DP0YMrGl_Lc2CILPjg
 */
public class ConcurrentSkipListMapTest {
    public static void main(String[] args) {
        final ConcurrentSkipListMap<Integer, String> skipListMap = new ConcurrentSkipListMap<>();
        skipListMap.put(3, "3");
        skipListMap.put(6, "6");
        skipListMap.put(7, "7");
        skipListMap.put(9, "9");
        skipListMap.put(12, "12");
        skipListMap.put(17, "17");
        skipListMap.put(19, "19");
        skipListMap.put(21, "21");
        skipListMap.put(25, "25");
        skipListMap.put(26, "26");
        System.out.println("skipListMap =" + skipListMap);
    }
}

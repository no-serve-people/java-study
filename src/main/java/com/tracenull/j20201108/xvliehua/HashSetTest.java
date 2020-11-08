package com.tracenull.j20201108.xvliehua;

import java.util.HashSet;
import java.util.Set;

/**
 * 为什么我不建议你使用Java序列化
 * https://juejin.im/post/6890958788719804429
 */
public class HashSetTest {
    public static void main(String[] args) {
        Set root = new HashSet();
        Set s1 = root;
        Set s2 = new HashSet();

        for (int i = 0; i < 100; i++) {
            Set t1 = new HashSet();
            Set t2 = new HashSet();
            t1.add("test");// 使t2不等于t1
            s1.add(t1);
            s1.add(t2);
            s2.add(t1);
            s2.add(t2);
            s1 = t1;
            s2 = t2;
        }
    }
}

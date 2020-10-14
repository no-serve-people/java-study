package com.tracenull.j20201014;

import java.util.ArrayList;
import java.util.List;

/**
 * ArrayList 插入 1000w 条数据之后，我怀疑了 Java 虚拟机。。。
 * https://mp.weixin.qq.com/s/0LGrSEv5MPVL0qM33T0UkQ
 */
public class ArrayListTest {
    public static void main(String[] args) {
        List<Integer> list0 = new ArrayList<Integer>();
        long start0 = System.currentTimeMillis();
        for (int i = 0; i < 10000000; i++) {
            list0.add(i);
        }
        System.out.println(System.currentTimeMillis() - start0);

        long start1 = System.currentTimeMillis();
        List<Integer> list1 = new ArrayList<Integer>();
        for (int i = 10000000; i < 20000000; i++) {
            list1.add(i);
        }
        System.out.println(System.currentTimeMillis() - start1);
    }
}

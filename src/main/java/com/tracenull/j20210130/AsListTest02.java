package com.tracenull.j20210130;

import java.util.Arrays;
import java.util.List;

/**
 * asList 产生的列表不可操作
 * https://mp.weixin.qq.com/s/HZ76aKVdAas869lD7UmCyA
 */
public class AsListTest02 {
    public static void main(String[] args) {
        Integer[] ints = {1, 2, 3, 4, 5};
        List list = Arrays.asList(ints);
        list.add(6);
    }
}

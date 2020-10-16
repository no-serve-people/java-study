package com.tracenull.j20201016;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Java数组转List的三种方式及对比
 * https://mp.weixin.qq.com/s/XualNk3k9Dd3ygDEjLmgsQ
 */
public class ListTest {
    public static void main(String[] args) {
//        testArrayCastToListError();
//        testArrayCastToListRight();
        testArrayCastToListEfficient();
    }

    // 一.最常见方式（未必最佳）
    private static void testArrayCastToListError() {
        String[] strArray = new String[2];
        List list = Arrays.asList(strArray);
        // 对转换后的list插入一条数据
        list.add("1");
        System.out.println(list);
    }
    // 二.数组转为List后，支持增删改查的方式

    private static void testArrayCastToListRight() {
        String[] strArray = new String[2];
        ArrayList<String> list = new ArrayList<>(Arrays.asList(strArray));
        list.add("1");
        System.out.println(list);
    }
    // 三.通过集合工具类Collections.addAll()方法(最高效)

    private static void testArrayCastToListEfficient() {
        String[] strArray = new String[2];
        ArrayList<String> arrayList = new ArrayList<>(strArray.length);
        Collections.addAll(arrayList, strArray);
        arrayList.add("1");
        System.out.println(arrayList);
    }
}

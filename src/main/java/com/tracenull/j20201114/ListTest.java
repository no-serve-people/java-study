package com.tracenull.j20201114;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Java中5种List的去重方法及它们的效率对比，你用对了吗？
 * https://mp.weixin.qq.com/s/NnGQi_9HsKhYDWN6Jrh-ow
 */
public class ListTest {

    // 01、使用两个for循环实现List去重(有序)
    public static List removeDuplicationBy2For(List<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            for (int i1 = 0; i1 < list.size(); i1++) {
                if (list.get(i).equals(list.get(i1))) {
                    list.remove(i1);
                }
            }
        }

        return list;
    }

    // 使用List集合contains方法循环遍历(有序)
    public static List removeDuplicationByContains(List<Integer> list) {
        List<Integer> newList = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            boolean isContains = newList.contains(list.get(i));

            if (!isContains) {
                newList.add(list.get(i));
            }
        }

        list.clear();
        list.addAll(newList);

        return list;
    }

    // 03、使用HashSet实现List去重(无序)
    public static List removeDuplicationByHashSet(List<Integer> list) {
        HashSet set = new HashSet(list);
        // 把List集合所有元素清空
        list.clear();
        // 把HashSet对象添加至List集合
        list.addAll(set);

        return list;
    }

    // 04、使用TreeSet实现List去重(有序)

    public static List removeDuplicationByTreeSet(List<Integer> list) {
        TreeSet set = new TreeSet(list);

        //把List集合所有元素清空
        list.clear();
        //把HashSet对象添加至List集合
        list.addAll(set);
        return list;
    }

    // 05 使用java8新特性stream实现List去重(有序)

    public static List removeDuplicationByStream(List<Integer> list) {
        List newList = list.stream().distinct().collect(Collectors.toList());

        return newList;
    }

    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        List<Integer> list3 = new ArrayList<>();
        List<Integer> list4 = new ArrayList<>();
        List<Integer> list5 = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < 100000; i++) {
            int value = random.nextInt(10000);
            list1.add(value);
            list2.add(value);
            list3.add(value);
            list4.add(value);
            list5.add(value);
        }

        long startTime;
        long endTime;

        startTime = System.currentTimeMillis();

        removeDuplicationByHashSet(list1);
        endTime = System.currentTimeMillis();
        System.out.println("使用HashSet实现List去重时间:" + (endTime - startTime) + "毫秒");
        startTime = System.currentTimeMillis();
        removeDuplicationByTreeSet(list2);
        endTime = System.currentTimeMillis();
        System.out.println("使用TreeSet实现List去重时间:" + (endTime - startTime) + "毫秒");
        startTime = System.currentTimeMillis();
        removeDuplicationByStream(list3);
        endTime = System.currentTimeMillis();
        System.out.println("使用java8新特性stream实现List去重:" + (endTime - startTime) + "毫秒");
        startTime = System.currentTimeMillis();
        removeDuplicationBy2For(list4);
        endTime = System.currentTimeMillis();
        System.out.println("使用两个for循环实现List去重:" + (endTime - startTime) + "毫秒");
        startTime = System.currentTimeMillis();
        removeDuplicationByContains(list5);
        endTime = System.currentTimeMillis();
        System.out.println("使用List集合contains方法循环遍历:" + (endTime - startTime) + "毫秒");
    }
}

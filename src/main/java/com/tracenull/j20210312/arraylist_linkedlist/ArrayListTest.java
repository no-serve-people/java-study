package com.tracenull.j20210312.arraylist_linkedlist;

import java.util.ArrayList;
import java.util.LinkedList;


/**
 * 面试官：兄弟，说说 ArrayList 和 LinkedList 有什么区别
 * https://mp.weixin.qq.com/s/8BRrFzSp0wS9Jo-gB-NCeQ
 */
public class ArrayListTest {
    public static void addFromMidTest(int num) {
        ArrayList<String> list = new ArrayList<>(num);
        int i = 0;

        long timeStart = System.currentTimeMillis();

        while (i < num) {
            int temp = list.size();
            list.add(temp / 2 + "沉默王二");
            i++;
        }

        long timeEnd = System.currentTimeMillis();

        System.out.println("ArrayList从集合中间位置新增元素花费的时间" + (timeEnd - timeStart));

    }
}

class LinkedListTest {
    public static void addFromMidTest(int num) {
        LinkedList<String> list = new LinkedList<String>();
        int i = 0;
        long timeStart = System.currentTimeMillis();
        while (i < num) {
            int temp = list.size();
            list.add(temp / 2, i + "沉默王二");
            i++;
        }
        long timeEnd = System.currentTimeMillis();

        System.out.println("LinkedList从集合中间位置新增元素花费的时间" + (timeEnd - timeStart));
    }
}

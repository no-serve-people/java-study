package com.tracenull.basic;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteArrayListDemo {
    public static void main(String[] args) {
//        List<String> list = new ArrayList<>();
//        List<String> list = new CopyOnWriteArrayList<>();

//        list.add("沉默王二");
//        list.add("沉默王三");
//        list.add("一个文章真特么有趣的程序员");

//        list.forEach((item)->{
//            if ("沉默王二".equals(item)){
//                list.remove(item);
//            }
//        });


//        for (String str : list) {
//            if ("沉默王二".equals(str)) {
//                list.remove(str);
//            }
//        }

        CopyOnWriteArrayList<String> list1 = new CopyOnWriteArrayList<>(new String[]{"沉默王二", "沉默王三"});
//        list1.add("沉默王四");
        Iterator<String> itr = list1.iterator();
                list1.add("沉默王四");
//        list1.forEach(System.out::println);
        while (itr.hasNext()){
            System.out.println(itr.next()+" ");
        }
    }
}

package com.tracenull.basic.compute;

import java.util.HashMap;

public class computeTest {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("1", 1);
        map.put("2", 2);
        map.put("3", 3);
        /** -----------测试compute---------- */
//        Integer integer = map.compute("3", (k, v) -> v + 1);
//
//        // key不管存在不在都会执行后面的函数，并保存到map中
//        Integer integer1 = map.compute("4", (k, v) -> {
//            if (v == null) return 0;
//            return v + 1;
//        });

        /** -----------测试computeIfAbsent---------- */

//        Integer integer = map.computeIfAbsent("3", (key) -> 4);
//
//        Integer integer1 = map.computeIfAbsent("4", key -> 4);
//
//        System.out.println(integer);
//        System.out.println(integer1);
//        System.out.println(map.toString());


        //只对map中存在的key对应的value进行操作
        Integer integer = map.computeIfPresent("3", (k,v) -> v+1 );
        Integer integer1 = map.computeIfPresent("4", (k,v) -> {
            if (v==null)return 0;
            return v+1;
        } );
        System.out.println(integer);
        System.out.println(integer1);
        System.out.println(map.toString());


    }
}

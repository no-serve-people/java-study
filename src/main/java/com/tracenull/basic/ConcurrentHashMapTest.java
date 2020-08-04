package com.tracenull.basic;

import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapTest {
    public static void main(String[] args) {
        ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>(16);
        String why = map.get("why");

        System.out.println("第一次获取why=" + why);
//        String test = map.computeIfAbsent("why", key -> getValue());
//        System.out.println(test);
        String test2 = map.computeIfAbsent("AaAa", key -> {
            return map.computeIfAbsent("BbBb", key2 -> String.valueOf(42));
        });
        System.out.println(map);
        why = map.get("why");
        System.out.println("第二次获取key=" + why);
    }

    private static String getValue() {
        return "why技术";
    }
}

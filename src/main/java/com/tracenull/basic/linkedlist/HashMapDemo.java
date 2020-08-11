package com.tracenull.basic.linkedlist;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class HashMapDemo {
    public static void main(String[] args) {
//        Map<String, String> hashMap = new HashMap<>();
//        Map<String, String> hashMap = new LinkedHashMap<>();
//        hashMap.put("沉", "沉默王二");
//        hashMap.put("默", "沉默王二");
//        hashMap.put("王", "沉默王二");
//        hashMap.put("二", "沉默王二");
//        hashMap.put(null, null);
//
////        System.out.println(hashMap.keySet());
//        for (String key : hashMap.keySet()) {
//            System.out.println(key + " : " + hashMap.get(key));
//        }
        Map<String, String> linkedHashMap = new LinkedHashMap<>(16, .75f, true);
        linkedHashMap.put("沉", "沉默王二");
        linkedHashMap.put("默", "沉默王二");
        linkedHashMap.put("王", "沉默王二");
        linkedHashMap.put("二", "沉默王二");

        System.out.println(linkedHashMap);
        linkedHashMap.get("默");
        System.out.println(linkedHashMap);

        linkedHashMap.get("王");
        System.out.println(linkedHashMap);
    }
}

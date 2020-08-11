package com.tracenull.basic.linkedlist;

import java.util.LinkedHashMap;
import java.util.Map;

public class MyLinkedHashMap<K, V> extends LinkedHashMap<K, V> {
    private static final int MAX_ENTRIES = 5;

    public MyLinkedHashMap(int initialCapacity, float loadFactor, boolean accessOrder) {
        super(initialCapacity, loadFactor, accessOrder);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > MAX_ENTRIES;
    }
}

class Test {
    public static void main(String[] args) {
        MyLinkedHashMap<String, String> map = new MyLinkedHashMap<>(16, 0.75f, true);
        map.put("沉", "沉默王二");
        map.put("默", "沉默王二");
        map.put("王", "沉默王二");
        map.put("二", "沉默王二");
        map.put("一枚有趣的程序员", "一枚有趣的程序员");

        System.out.println(map);
        map.put("一枚有颜值的程序员", "一枚有颜值的程序员");
        System.out.println(map);

        map.get("默");
        map.put("一枚有才华的程序员", "一枚有才华的程序员");
        System.out.println(map);
    }
}

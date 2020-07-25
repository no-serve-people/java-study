package com.tracenull;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class FailFastExample {
    public static void main(String[] args) {
        Map<String, String> premiumPhone = new HashMap<String, String>();

        premiumPhone.put("Apple", "iPhone");
        premiumPhone.put("HTC", "HTC one");
        premiumPhone.put("Samsung", "S5");

        Iterator<String> iterator = premiumPhone.keySet().iterator();

        while (iterator.hasNext()) {
            System.out.println(premiumPhone.get(iterator.next()));
//            premiumPhone.put("sony", "Xperia");
        }
//        Set<String> set = premiumPhone.keySet();
//        for(String map1 : set){
//            System.out.println(premiumPhone.get(map1));
//        }

    }
}

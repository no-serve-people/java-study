package com.tracenull.j20210318;

import com.google.common.collect.Maps;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * https://mp.weixin.qq.com/s/ssNWbxMx8bmAMA2DBkyPNg
 * 如何优雅的统计List集合中元素重复出现次数
 */
public class ArrayList {
    public static void main(String[] args) {
        List<String> nameList = Arrays.asList("Lvshen", "Lvshen", "Zhouzhou", "Huamulan", "Huamulan", "Huamulan");
        // 方式一
//        Map<String, Integer> nameMap = Maps.newHashMap();
//
//        nameList.forEach(name -> {
//            Integer counts = nameMap.get(name);
//            nameMap.put(name, counts == null ? 1 : ++counts);
//        });
//
//        System.out.println(nameMap);
        // 方式2
//        Map<String, Long> nameMap = nameList.stream().collect(Collectors.groupingBy(p -> p, Collectors.counting()));
//                System.out.println(nameMap);
//        方式三

        Map<String, Integer> nameMap = Maps.newHashMap();
        nameList.forEach(name -> nameMap.compute(name, (k, v) -> v == null ? 1 : ++v));

        System.out.println(nameMap);

    }
}

package com.tracenull.j20200902;

import java.util.ArrayList;

/**
 * https://mp.weixin.qq.com/s/-E8kR-hwTgLddLksOXz2dA
 */
public class ListDemo {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<String>();
        list.add("保护环境");  //向列表中添加数据
        list.add("爱护地球");  //向列表中添加数据
        list.add("从我做起");  //向列表中添加数据

        list.add(1, "从我做起");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(i + ":" + list.get(i));
        }
    }
}

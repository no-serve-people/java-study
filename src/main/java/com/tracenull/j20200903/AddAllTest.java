package com.tracenull.j20200903;

import java.util.ArrayList;

/**
 * https://mp.weixin.qq.com/s/si63AhK8f3IkXhXFC4JAJw
 */
public class AddAllTest {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("保护环境");  //向列表中添加数据
        list.add("爱护地球");  //向列表中添加数据
        list.add("从我做起");  //向列表中添加数据
        list.add(1, "从我做起");  //在第1+1个元素的位置添加数据
        ArrayList<String> list_ad = new ArrayList<>();
        list_ad.add("公益广告");
//        System.out.println("是否添加成功" + ":" + list_ad.addAll(list));// 通过循环输出列表中的内容
        System.out.println("是否添加成功" + ":" + list_ad.addAll(0, list));// 通过循环输出列表中的内容
        for (int i = 0; i < list_ad.size(); i++) {
            System.out.println(i + ":" + list_ad.get(i));
        }
    }
}

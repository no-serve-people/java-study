package com.tracenull.j20201128;

import java.util.ArrayList;
import java.util.List;

/**
 * https://mp.weixin.qq.com/s/DNXAP3PGHE1zX_ax0TyA3Q
 */
public class subListTest {
    public static void main(String[] args) {
        /**
         * 从上面的结果也可以清晰地看出，subList 并不是 ArrayList 类型的实例，不能强转为 ArrayList 。
         */
//        List<Integer> integerList = new ArrayList<>();
//        integerList.add(0);
//        integerList.add(1);
//        integerList.add(2);
//
//        List<Integer> subList = integerList.subList(0, 1);
//        System.out.println(subList);
//        ArrayList<Integer> castList = (ArrayList<Integer>) subList;
//        System.out.println(castList);

        /**
         * 可以观察到，对子列表的修改最终对原始列表产生了影响。
         */
        List<String> stringList = new ArrayList<>();
        stringList.add("月");
        stringList.add("伴");
        stringList.add("小");
        stringList.add("飞");
        stringList.add("鱼");
        stringList.add("哈");
        stringList.add("哈");
        List<String> subList = stringList.subList(2, 4);
        System.out.println("子列表：" + subList.toString());
        System.out.println("子列表长度：" + subList.size());

        subList.set(1, "周星星");
        System.out.println("子列表：" + subList.toString());
        System.out.println("原始列表：" + stringList.toString());
    }
}

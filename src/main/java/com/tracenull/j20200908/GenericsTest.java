package com.tracenull.j20200908;

import java.util.ArrayList;
import java.util.List;

/**
 * https://blog.csdn.net/briblue/article/details/76736356
 */
public class GenericsTest {
    public static void main(String[] args) {
        ArrayList<String> l1 = new ArrayList<String>();
        ArrayList<Integer> l2 = new ArrayList<Integer>();
        // 类型擦除
        System.out.println(l1.getClass()==l2.getClass());
    }
}

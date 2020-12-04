package com.tracenull.j20201204.lxf;

/**
 * 获取父类的Class
 * https://www.liaoxuefeng.com/wiki/1252599548343744/1264804244564000
 */
public class Superclass {
    public static void main(String[] args) {
        Class<Integer> i = Integer.class;
        Class<? super Integer> n = i.getSuperclass();
        System.out.println(n);


        Class<? super Integer> o = n.getSuperclass();
        System.out.println(o);

        System.out.println(o.getSuperclass());
    }
}

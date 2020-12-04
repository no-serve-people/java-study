package com.tracenull.j20201204.lxf;

/**
 * 获取interface
 * https://www.liaoxuefeng.com/wiki/1252599548343744/1264804244564000
 */
public class Interface {
    public static void main(String[] args) {
        Class s = Integer.class;
        Class[] is = s.getInterfaces();
        for (Class i : is) {
            System.out.println(i);
        }
        Class s2 = Integer.class.getSuperclass();
        Class[] is2 = s2.getInterfaces();
        for (Class i : is2) {
            System.out.println(i);
        }
    }
}

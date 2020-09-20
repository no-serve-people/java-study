package com.tracenull.j20200920;

/**
 * https://juejin.im/post/6872738517798584328
 */
public class Test {
    public static void main(String[] args) {
        Integer i = null;
//        System.out.println(1 != 1 ? 0 : i);
        System.out.println(1 != 1 ? new Integer(0) : i);
//        System.out.println(1 == 1 ? 0 : i);
    }
}

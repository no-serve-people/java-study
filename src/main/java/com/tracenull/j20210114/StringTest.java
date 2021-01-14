package com.tracenull.j20210114;

/**
 * 公司大佬说我不懂String，一个String.intern()方法教他做人
 * https://juejin.cn/post/6908699519987875853
 */
public class StringTest {
    public static void main(String[] args) {
        // First Blood
//        String s = new String("1");
//        String s1 = s.intern();
//        System.out.println(s == s1);

        // Double kill
//        String s = new String("1");
//        String s1 = s.intern();
//        String s2 = "1";
//        System.out.println(s == s1);
//        System.out.println(s1 == s2); // true
        // Triple kill
        String s = new String("1");
        String t = new String("1");
        String s1 = s.intern();
        String s2 = "1";
        System.out.println(s == s1);
        System.out.println(s1 == s2);
        System.out.println(s == t);   // false
        System.out.println(s.intern() == t.intern());   // true
    }
}

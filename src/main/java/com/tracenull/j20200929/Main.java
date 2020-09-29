package com.tracenull.j20200929;

import java.util.Scanner;

/**
 * https://mp.weixin.qq.com/s/CQrhv5Z3DNrUlD1prH10CQ
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String a1 = in.next();
        String a2 = in.next();
        String a3 = in.next();

        Person<Contact> a = new Person<Contact>(new Contact(a1, a2, a3));
        System.out.println("——————————————————————————————————————————————");
        System.out.println(a);
        String b1 = in.next();
        String b2 = in.next();

        int b3 = in.nextInt();
        Person<Intro> b = new Person<Intro>(new Intro(b1, b2, b3));
        System.out.println(b);
    }
}

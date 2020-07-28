package com.tracenull.basic;

import java.lang.reflect.Field;

public class StringDemo {
    public static void main(String[] args) throws IllegalAccessException, NoSuchFieldException {
//        String str = "Python";
//        System.out.println(str); // Python
//
//        str = "Java";
//        System.out.println(str); // Java
//
//        str = str.substring(2);
//        System.out.println(str); // ava
        String str = "Hello Python";
        System.out.println(str);

        Field field = String.class.getDeclaredField("value");

        field.setAccessible(true);

        char[] value = (char[]) field.get(str);

        value[6] = 'J';
        value[7] = 'a';
        value[8] = 'v';
        value[9] = 'a';
        value[10] = '!';
        value[11] = '!';
        System.out.println(str);
    }
}

package com.tracenull.j20200908;

import java.util.ArrayList;
import java.util.List;

/**
 * https://www.runoob.com/java/java-generics.html
 */
public class GenericTest2 {
    public static void main(String[] args) {
        List<String> name = new ArrayList<String>();
        List<Integer> age = new ArrayList<Integer>();
        List<Number> number = new ArrayList<Number>();

        name.add("icon");
        age.add(18);
        number.add(314);


//        getUperNumber(name);//1
        getUperNumber(age);//2
        getUperNumber(number);//3
    }

    public static void getUperNumber(List<? extends Number> data) {
        System.out.println("data:" + data.get(0));
    }
}

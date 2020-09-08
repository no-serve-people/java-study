package com.tracenull.j20200908;

import net.sf.cglib.asm.$ConstantDynamic;

import java.util.ArrayList;
import java.util.List;

/**
 * https://www.runoob.com/java/java-generics.html
 */
public class GenericTest {
    public static void main(String[] args) {
        ArrayList<String> name = new ArrayList<String>();
        ArrayList<Integer> age = new ArrayList<Integer>();
        ArrayList<Number> number = new ArrayList<Number>();

        name.add("icon");
        age.add(18);
        number.add(314);
        getData(name);
        getData(age);
        getData(number);
    }

    public static void getData(List<?> data) {
        System.out.println("data:" + data.get(0));
    }
}

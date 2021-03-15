package com.tracenull.j20210315;

import static org.junit.Assert.*;

public class doubleListTest {
    public static void main(String[] args) {
        doubleList<Integer> list = new doubleList<>();
        list.add(66);
        list.addFirst(55);
        list.add(1,101);
        list.add(-2);
        list.add(555);
        list.addFirst(9999);
        System.out.println(list.toString());
        list.deleteFirst();
        list.delete(1);
        list.delete(1);
        list.deleteLast();
        list.deleteLast();
        System.out.println(list.toString());
        list.deleteLast();
        System.out.println(list.toString());

    }
}
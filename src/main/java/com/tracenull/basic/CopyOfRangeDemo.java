package com.tracenull.basic;

import java.util.Arrays;

public class CopyOfRangeDemo {
    public static void main(String[] args) {
        int arr[] = {0, 1, 2, 3, 4, 5, 6, 7, 8};

        int copyArr[]= Arrays.copyOfRange(arr,0,5);

        for (int i : copyArr) {
            System.out.println(i);
        }

    }
}

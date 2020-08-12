package com.tracenull.basic.array;

public class ArrayTest {
    // 自定义数组
    private long[] arr;
    // 有效数据长度
    private int element;

    public ArrayTest(int element) {
        arr = new long[9];
    }

    /**
     * 显示数组元素
     */
    public void display() {
        System.out.println("[");

        for (int i = 0; i < element; i++) {
            System.out.println(arr[i]+" ");
        }
        System.out.println("]");
    }
}

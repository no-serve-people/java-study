package com.tracenull.j20200929;

/**
 * https://mp.weixin.qq.com/s/EdAgtgZY0iLxVfbReruoSA
 */
public class DemoArray {
    public static void main(String[] args) {
//        int[] arr = new int[4];
//        arr[0] = 1;
//        arr[1] = 2;
//        System.out.println(arr);
//        System.out.println(arr[0]);
//        System.out.println(arr[1]);
//        System.out.println(arr[2]);
//        System.out.println(arr[3]);
//        System.out.println("-------------------------------------");
//        int[] arr1=new int[3];
//        arr1[0]=3;
//        arr1[1]=4;
//        arr1[2]=5;
//        System.out.println(arr1);//打印地址
//        System.out.println(arr1[0]);
//        System.out.println(arr1[1]);
//        System.out.println(arr1[2]);
//        int[] arr = new int[2];
//        arr[0] = 3;
//        arr[1] = 4;
//        System.out.println(arr);
//        System.out.println(arr[0]);
//        System.out.println(arr[1]);
//        int[] arr2 = arr;
//        arr2[0] = 1;
//        arr2[1] = 2;
//        System.out.println(arr);
//        System.out.println(arr[0]);
//        System.out.println(arr[1]);
//        System.out.println(arr2);
//        System.out.println(arr2[0]);
//        System.out.println(arr2[1]);
//        int[] arr = {1, 2, 3, 78, 2, 8, 9, 8, 52, 79, 10};
//        for (int i = 0; i < 11; i++) {
//            System.out.println(arr[i]);
//        }
//        System.out.println("该数组的长度");
//        System.out.println(arr.length);

        // 二维数组
//        int[][] arr = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
//
//        for (int i = 0; i < 3; i++) {
//            for (int j = 0; j < 3; j++) {
//                System.out.print(arr[i][j]);
//            }
//            System.out.println();
//        }
        // 数组翻转
//        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
//        for (int i = arr.length - 1; i >= 0; i--) {
//            System.out.print(arr[i] + " ");
//        }

        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        int temp = 0;
        for (int min = 0, max = arr.length - 1; min < max; min++, max--) {
            temp = arr[min];
            arr[min] = arr[max];
            arr[max] = temp;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i] + " ");
        }
    }
}

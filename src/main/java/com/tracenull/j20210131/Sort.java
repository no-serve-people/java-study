package com.tracenull.j20210131;

/**
 * 排序（上）——为什么插入排序比冒泡排序更受欢迎？
 * https://blog.csdn.net/every__day/article/details/83419170
 */
public class Sort {

    /**
     * 冒泡排序
     *
     * @param a
     * @return
     */
    public int[] bubbleSort(int[] a) {
        int n = a.length;
        if (n <= 1) {
            return a;
        }

        for (int i = 1; i < n; i++) {
            boolean flag = false;// 开关，当某次内层循环，没有数据交换时，已排好顺序，直接跳出循环。

            for (int i1 = 0; i1 < n - i; i1++) {
                if (a[i1] > a[i1 + 1]) {
                    int temp = a[i1];
                    a[i1] = a[i1 + 1];
                    a[i1 + 1] = temp;
                    flag = true;
                }
            }
            if (!flag) {
                break;
            }
        }
        return a;
    }

    /**
     * 插入排序
     *
     * @param a
     * @return
     */
    public int[] insertSort(int[] a) {
        int n = a.length;
        if (n <= 1) {
            return a;
        }
        for (int i = 1; i < n; i++) {
            int temp = a[i];

            int j = i - 1;
            for (; j >= 0; j--) {
                if (a[j] > temp) {
                    // 比temp 大的已排序数据后移一位
                    a[j + 1] = a[j];
                } else {
                    break;
                }
            }
            a[j + 1] = temp; // 空出来的位置，把temp放进去
        }

        return a;
    }

    public static void main(String[] args) {
        // 冒泡排序
        int sortarr[] = {4, 5, 6, 1, 3, 2};

        Sort sort = new Sort();
        int[] ints = sort.bubbleSort(sortarr);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
        System.out.println();


        // 冒泡排序
        int sortarr2[] = {7, 8, 6, 1, 3, 2};

        Sort sort2 = new Sort();
        int[] ints2 = sort.insertSort(sortarr);
        for (int anInt : ints2) {
            System.out.println(anInt);
        }
    }
}

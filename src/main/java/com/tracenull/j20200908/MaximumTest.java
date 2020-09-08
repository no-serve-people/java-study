package com.tracenull.j20200908;

/**
 * https://www.runoob.com/java/java-generics.html
 */
public class MaximumTest {
    public static <T extends Comparable<T>> T maximum(T x, T y, T z) {
        T max = x;// 假设x是初始最大值
        if (y.compareTo(max) > 0) {
            max = y;// y更大
        }
        if (z.compareTo(max) > 0) {
            max = z;
        }

        return max;
    }

    public static void main(String[] args) {
        System.out.printf("%d,%d和%d中最大的数为%d\n\n", 3, 4, 5, maximum(3, 4, 5));
        System.out.printf("%.1f,%.1f和%.1f中最大的数为%.1f\n\n", 6.6, 8.8, 7.7, maximum(6.6, 8.8, 7.7));
        System.out.printf("%s,%s和%s中最大的数为%s\n", "pear", "apple", "orange", maximum("pear", "apple", "orange"));
    }
}

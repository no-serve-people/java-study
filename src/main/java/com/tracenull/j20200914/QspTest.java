package com.tracenull.j20200914;

import java.util.Scanner;

/**
 * https://mp.weixin.qq.com/s/xseuB_ADzx602cjZwt5DKQ
 */
public class QspTest {
    private static int[] num = new int[100];

    public static void main(String[] args) {
        Scanner sr = new Scanner(System.in);
        for (int i = 0; ; i++) {
            num[i] = sr.nextInt();
            if (num[i] == 0) break;
        }

        for (int j = 0; j < num.length; j++) {
            if (num[j] == 0) break;
            text(num[j]);
        }
    }

    private static void text(int n) {
        int drink = 0;
        for (; ; ) {
            if (n == 2) {
                drink++;
                break;
            }
            if (n == 0 | n == 1) break;
            int input = n % 3;
            drink += (n - input) / 3;
            n = input + (n - input) / 3;
        }

        System.out.println(drink);
    }
}

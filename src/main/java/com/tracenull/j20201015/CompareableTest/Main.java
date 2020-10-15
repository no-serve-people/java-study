package com.tracenull.j20201015.CompareableTest;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * 比较器排序
 * https://mp.weixin.qq.com/s/lOxtk0NS6PigdLYvDwV6Yg
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Set<Students> allSet = new TreeSet<>();
        int i = 1;

        while (i <= 5) {
            int a = in.nextInt();
            String b = in.next();

            int c = in.nextInt();
            allSet.add(new Students(a, b, c));
            i++;
        }
        System.out.println(allSet);
    }
}

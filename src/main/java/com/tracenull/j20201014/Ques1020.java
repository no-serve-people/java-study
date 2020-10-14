package com.tracenull.j20201014;

/**
 * java每日一题20201014
 * https://mp.weixin.qq.com/s/nWutaBKARPfSKtECO-Lu-A
 */
public class Ques1020 {
    public static void main(String[] args) {
        int num = 0;
        String str01 = String.valueOf(num < 30 ? 20 : 30);
        String str02 = String.valueOf(num < 30 ? 20 : 30.0);
        System.out.println("str01与str02是否相等：" + str01.equals(str02));
    }
}

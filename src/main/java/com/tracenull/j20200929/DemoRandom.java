package com.tracenull.j20200929;

import java.util.Random;

/**
 * https://mp.weixin.qq.com/s/EdAgtgZY0iLxVfbReruoSA
 * 随机数
 */
public class DemoRandom {
    public static void main(String[] args) {
        Random r = new Random();
        int number = r.nextInt(100);
        int number2 = r.nextInt(59 - 30) + 30 + 1;
        int number3 = r.nextInt(99 - 45) + 45 + 1;
        System.out.println(number);
        System.out.println(number2);
        System.out.println(number3);
    }
}

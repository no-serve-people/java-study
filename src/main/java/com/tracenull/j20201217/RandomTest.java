package com.tracenull.j20201217;

import java.util.Random;

/**
 * 随机数生成
 * https://juejin.cn/post/6905917604465115149
 */
public class RandomTest {
    public static void main(String[] args) {
        Random random = new Random();
        StringBuffer code = new StringBuffer();
        for (int i = 0; i < 8; i++) {
            int number = random.nextInt(3);
            switch (number) {
                case 0:
                    code.append((char) (random.nextInt(26) + 65)); // 65 ~ 90
                    break;
                case 1:
                    code.append((char) (random.nextInt(26) + 97)); // 97 ~ 122
                    break;
                case 2:
                    code.append((char) (random.nextInt(9) + 48)); // 48 ~ 97
                    break;
            }
        }
        System.out.println(code.toString());
    }
}

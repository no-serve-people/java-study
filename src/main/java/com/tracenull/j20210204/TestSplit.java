package com.tracenull.j20210204;

import org.junit.Test;

/**
 * 字符串分隔(别忘了转义)
 * https://juejin.cn/post/6924566386136055816
 */
public class TestSplit {
    @Test
    public void testString() {
        String str = "java|php|c++";
//        String[] split = str.split("|");
        String[] split = str.split("\\|");

        for (String s : split) {
            System.out.println(s);
        }
    }
}

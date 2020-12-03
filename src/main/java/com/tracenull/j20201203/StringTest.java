package com.tracenull.j20201203;

import java.util.StringJoiner;

/**
 * 你只会用 StringBuilder？试试 StringJoiner，真香
 * https://mp.weixin.qq.com/s/beBCcEkqWDt2u77bV1yDmQ
 */
public class StringTest {
    public static void main(String[] args) {
        // 字面上理解就是用来拼接字符串的，一般需要分隔符进行拼接，如：
//        StringBuilder sb = new StringBuilder();
//        sb.append("hello");
//        sb.append(",");
//        sb.append("guys");
//        sb.append(",");
//        sb.append("AAA");
//
//        System.out.println(sb.toString());
//        System.out.println(sb);
// string joiner
//        StringJoiner stringJoiner = new StringJoiner(",");
//        stringJoiner.add("hello");
//        stringJoiner.add("guys");
//        stringJoiner.add("AAA");
//        System.out.println(stringJoiner.toString());
//        System.out.println(stringJoiner);

        // 流失api
//        StringJoiner sj = new StringJoiner(",").add("hello").add("guys").add("AAA");
//        System.out.println(sj.toString());
        // 前后缀拼接
//        StringJoiner stringJoiner = new StringJoiner(",", "[", "]");
//        stringJoiner.add("hello");
//        stringJoiner.add("guys");
//        stringJoiner.add("AAA");
//        System.out.println(stringJoiner.toString());

//        空值处理
        // 输出空白字符串：
//        StringJoiner stringJoiner = new StringJoiner(",");
        // 输出前后缀：
//        StringJoiner stringJoiner = new StringJoiner(",", "[", "]");
//        StringJoiner stringJoiner = new StringJoiner(",", "[", "]");
//        stringJoiner.setEmptyValue("void");
//        System.out.println(stringJoiner.toString());
//        String.join()
        String str = String.join(",", "hello", "guys", "AAA");
        System.out.println(str);
    }
}

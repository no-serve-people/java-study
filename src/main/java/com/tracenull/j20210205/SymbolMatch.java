package com.tracenull.j20210205;

import java.util.Scanner;
import java.util.Stack;

/**
 * Java实现括号匹配
 * https://blog.csdn.net/tsuixh/article/details/52794546
 */
public class SymbolMatch {
    public static void main(String[] args) {
        Stack<Character> stack = new Stack<>();

        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            String target = sc.nextLine();

            char[] bytes = target.toCharArray();
            // 将第一个字符压入栈
            stack.push(bytes[0]);
            /*
             * 从第二个字符开始，依次与栈中的字符匹配
             */
            for (int i = 0; i < bytes.length; i++) {
                Character c1 = stack.peek();

                Character c2 = bytes[i];

                if ((c1.toString().equals("(") && c2.toString().equals(")"))
                        || (c1.toString().equals("[") && c2.toString().equals("]"))
                        || (c1.toString().equals("{") && c2.toString().equals("}"))) {

                    stack.pop();
                } else {
                    stack.push(c2);
                }
            }

            boolean isMatch = stack.isEmpty();

            System.out.println("栈内内容：" + stack);
            System.out.println("括号匹配结果：" + isMatch);
        }

        sc.close();
    }
}

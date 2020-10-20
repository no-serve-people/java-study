package com.tracenull.j20201021;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * https://juejin.im/post/6884808410353631240?utm_source=gold_browser_extension
 */
public class isValidTest {
    public boolean isValid(String s) {
        int slen = s.length();// 括号的长度

        if (slen % 2 == 1) { // 括号不是成对出现直接返回 false
            return false;
        }
        // 把所有对比的括号存入 map，对比时用
        Map<Character, Character> map = new HashMap<>();

        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');
        // 定义栈，用于存取括号（辅助比较）
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < slen; i++) { // 循环所有字符
            char c = s.charAt(i);
            if (map.containsKey(c)) {// 为右边的括号，如 ')'、'}' 等
                if (stack.isEmpty() || stack.peek() != map.get(c)) {// 栈为空或括号不匹配
                    return false;
                }
                stack.pop();// 是一对括号，执行出栈（消除左右括号）
            } else {// 左边括号，直接入栈
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }

    public boolean isValid2(String s) {
        int len;

        do {
            len = s.length();
            // 消除成双成对的符号
            s.replace("()", "").replace("[]", "")
                    .replace("{}", "");
        } while (len != s.length());// 不能再进行替换了，replace 方法没有替换任何字符
        return s.length() == 0;
    }
}

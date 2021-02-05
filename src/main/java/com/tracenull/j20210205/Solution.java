package com.tracenull.j20210205;

/**
 * Java while循环、双指针、极简代码
 * https://leetcode-cn.com/problems/get-equal-substrings-within-budget/solution/java-whilexun-huan-shuang-zhi-zhen-ji-ji-ncye/
 */
public class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
       /*
            使用滑动窗口，比较窗口中要替换的字符是否满足开销，但是需要考虑下面的问题
            1 怎么保存窗口？其实窗口不用保存只要保存当前的开销即可
            2 怎么移动窗口？当前开销如果不大于给定开销则窗口可以扩大，如果大于了窗口要整体移动
            3 移动的时候需要做什么？移动的时候要重新计算窗口中的开销，即加右指针开销，减左指针开销
         */
        // 非法输入
        if (s == null || t == null) return -1;

        if (s.length() != t.length()) return -1;
        if (s.length() == 0) return 0;

        char[] sSchars = s.toCharArray();
        char[] tChars = t.toCharArray();
        // 保存每个位置的差，这样避免每次都计算，可以提高一定的效率
        int[] costArray = new int[s.length()];
        for (int i = 0; i < costArray.length; i++) {
            costArray[i] = Math.abs(sSchars[i] - tChars[i]);
        }

        int left = 0, right = 0;
        int currentCost = 0;
        for (int i = 0; i < s.length(); i++) {
            // 如果窗口内部的开销大于计划开销
            if (currentCost + costArray[right] > maxCost) {
                currentCost -= costArray[left--];
            }

            currentCost += costArray[right++];
        }

        return right - left;
    }

}

package com.tracenull.j20201009;

/**
 * https://mp.weixin.qq.com/s/aTlJsVc7LgNMo3S5Tq18Xg
 */
public class Solution {
    public int MoreThanHalfNum_Solution(int[] array) {
        if (array.length <= 0) {
            return 0;
        }
        int start = 0;
        int length = array.length;
        int end = length - 1;
        // 右移1位，相当于除2，效率更高
        int middle = length >> 1;
        // 当前位置
        int index = Partition(array, start, end);

        // 直到取到中位数，才是结果
        while (index != middle) {
            if (index > middle) {
                index = Partition(array, start, index - 1);
            } else {
                index = Partition(array, index + 1, end);
            }
        }
        int result = array[middle];
        // 需要统计该数字个数，必须要大于数组长度的一半才能算
        int times = 0;
        for (int i = 0; i < length; i++) {
            if (result == array[i]) {
                times++;
            }
        }

        if (times * 2 <= length) {
            result = 0;
        }

        return result;
    }

    // 快排中的每次排序实现，返回的是交换后start位置，也就是index一直改变的位置
    private int Partition(int[] array, int start, int end) {
        // 取平均值不一定是整数，所以必须除2取整，不能右移
        int flag = (array[start] + array[end]) / 2;

        while (start < end) {
            while (array[end] > flag) {
                end--;
            }
            swap(array, start, end);
            while (array[start] <= flag) {
                start++;
            }
            swap(array, start, end);
        }
        return start;
    }

    private void swap(int[] array, int num1, int num2) {
        int temp = array[num1];
        array[num1] = array[num2];
        array[num2] = temp;
    }

    private int MoreThanHalfNum_Solution2(int[] array) {
        int length = array.length;

        // 检测数组是否为空
        if (length == 0) {
            return 0;
        }
        // 初始化result和times参数
        int result = array[0];
        int times = 1;
        // 遍历数组（由于初始化过，所以直接从第二个数字开始）
        for (int i = 1; i < length; i++) {
            // 次数为0时写入下一个数字并将次数置1
            if (times == 0) {
                result = array[i];
                times = 1;
            }
            // 数字相同，加1
            else if (array[i] == result) {
                times++;
            }
            // 数字不同，减1
            else {
                times--;
            }
        }
        // 需要统计该数字个数，必须要大于数组长度的一半才能算
        times = 0;
        for (int i = 0; i < length; i++) {
            if (result == array[i]) {
                times++;
            }
        }
        if (times * 2 <= length) {
            result = 0;
        }

        return result;
    }
}




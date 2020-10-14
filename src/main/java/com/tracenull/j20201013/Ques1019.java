package com.tracenull.j20201013;

import java.util.List;

/**
 * https://mp.weixin.qq.com/s?__biz=MzI4ODEyMTgwMA==&mid=2650163209&idx=1&sn=fb8e8272448073b641848abe1405c7fe&chksm=f3c1deaec4b657b8e230ff3eb9dfcea522907a831417b393f6b78a8759effed44e48427f294c&scene=0#wechat_redirect
 */
public class Ques1019 {
    // 对数组求和
    public static int sum(int[] datas) {
        int sum = 0;
        for (int i = 0; i < datas.length; i++) {
            sum += datas[i];
        }
        return sum;
    }
    // 对列表求和
    public static int sum(List<Integer> datas) {
        int sum = 0;
        for (int i = 0; i < datas.size(); i++) {
            sum += datas.get(i);// 2
        }
        return sum;
    }
}

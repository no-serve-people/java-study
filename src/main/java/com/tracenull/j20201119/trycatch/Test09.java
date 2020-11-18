package com.tracenull.j20201119.trycatch;

import java.util.Scanner;

/**
 * 世上最真情的爱恋就是你在try我在catch（这我酸了...）
 * https://mp.weixin.qq.com/s/gcUAGjXe52f3RUP2TG8GTw
 */
public class Test09 {
    public static void main(String[] args) throws Exception {
        // 我再把异常往上抛，抛给main方法，main方法再抛就要抛给虚拟机，让虚拟机给你处理
        myTest();
    }


    public static void myTest() throws Exception {
        // 我太懒了，就直接用个Exception给全部异常包含住了哈哈
        int a, b;
        System.out.println("请输入两个数：");
        Scanner myin = new Scanner(System.in);
        a = myin.nextInt();//1.如果输入的不是int类型，程序出错。提出问题
        b = myin.nextInt();
        System.out.println(a / b);//2.除数可能为零
        int arr[] = {1, 2, 3, 4, 5};
        System.out.println(arr[5]); //3.数组下标越界
        System.out.println("try中的语句");
        System.out.println("程序继续向下执行：");
    }
}

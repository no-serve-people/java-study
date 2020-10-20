package com.tracenull.j20201018;

/**
 * 请问主程序是否有编译错误，为什么？
 * https://mp.weixin.qq.com/s/Cgre3e779JwlG7lj2VMcIA
 */
public class Ques1021 {
    public static void main(String[] args) {

        Ques1021 ques1021 = new Ques1021();
        ques1021.method01("test", 0);
        ques1021.method01("test", "tttt");
//        ques1021.method01("test");
//        ques1021.method01("test", null);
    }

    public void method01(String s, Integer... i){}

    public void method01(String s, String... str){}
}

package com.tracenull.j20201009;

/**
 * https://mp.weixin.qq.com/s/oHQlXjpoRrcqeBPRJS5Qjg
 */
public class Ques1013 {
    public static void main(String[] args) {
        new Obj();
    }
}

class Obj {
    String name;
    Other other = new Other();

    public Obj() {
        this("Object");
        System.out.println("无参构造函数");
    }

    public Obj(String name) {
        System.out.println("有参构造函数");
    }
}

class Other {
    public Other() {
        System.out.println("Other构造函数");
    }
}

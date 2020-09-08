package com.tracenull.j20200908;

/**
 * https://www.runoob.com/java/java-generics.html
 */
public class Box<T> {
    private T t;

    public void add(T t) {
        this.t = t;
    }

    public T get() {
        return t;
    }

    public static void main(String[] args) {
        Box<Integer> integerBox = new Box<Integer>();
        Box<String> stringBox = new Box<String>();
        integerBox.add(new Integer(10));
        stringBox.add(new String("菜鸟教程"));
        System.out.printf("整形值为:%d\n\n", integerBox.get());
        System.out.printf("字符串为:%s\n\n", stringBox.get());
    }
}

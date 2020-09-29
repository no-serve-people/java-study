package com.tracenull.j20200929.duotai;

/**
 * https://juejin.im/post/6871890430284267534?utm_source=gold_browser_extension
 * Java中多态的用法
 */
public class Animal {
    void eat() {
        System.out.println("Animal eat()");
    }
}

class Monkey extends Animal {

    void eat() {
        System.out.println(" Monkey eat()");
    }
}

class test2 {

    public static void start(Animal animal) {
        animal.eat();
    }

    public static void main(String[] args) {
        Monkey monkey = new Monkey();
        start(monkey);
    }
}


package com.tracenull.j20200929.duotai;

/**
 * https://juejin.im/post/6871890430284267534?utm_source=gold_browser_extension
 * Java中多态的用法
 */
public class polygon {
    void cal() {
        System.out.println("polygon.cal()");
    }

    polygon() {
        System.out.println("polygon before cal()");
        cal();
        System.out.println("polygon after cal()");
    }
}

class square extends polygon {
    private int border = 2;

    square(int i) {
        border = i;
        System.out.println("square.square(),border=" + border);
    }

    void cal() {
        System.out.println("square.cal(),border=" + border);
    }

}

class test {
    public static void main(String[] args) {
        new square(4);
    }
}

package com.tracenull.j20201119.trycatch;

/**
 * 世上最真情的爱恋就是你在try我在catch（这我酸了...）
 * https://mp.weixin.qq.com/s/gcUAGjXe52f3RUP2TG8GTw
 */
public class Test01 {
    public static void main(String[] args) {
        // 分母为0异常
        int b = 0;
        if (b != 0) {
            // 避免出现java.lang.ArithmeticException异常，给它加个if判断语句就可以了
            System.out.println(1 / b);
        }
        // 空指针异常
        String str = null;
        if (str != null) {
            System.out.println(str.charAt(0));
            // charAt是提取下标为0的字符，避免出现空指针异常：java.lang.NullPointerException，加一个非空判断
        }

        // 数组下标越界异常
        int i[] = new int[5];
        int a = 5;

        if (a < i.length) {
            // 避免java.lang.ArrayIndexOutOfBoundsException下标越界异常，增加关于边界的判断
            System.out.println(i[a]);
        }
        // 类型转换错误
        Animal dog = new Dog();
        // 强制类型转换易出现的错误（编译看左，运行看右）

        if (dog instanceof Cat) {
            // 避免java.lang.ClassCastException类型转换错误，可以用instanceof二元运算符，注意：左边对象，右边类
            Cat cat = (Cat) dog;
        }


    }
}


class Animal {
}

class Dog extends Animal {
}

class Cat extends Animal {
}
package com.tracenull.j20200910;

import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * https://mp.weixin.qq.com/s/fp0pvkycyl6mqQci3F6iMw
 */
public class MethodTest {
    public static void main(String[] args) {
//        // 使用双冒号::来构造静态函数引用
//        Function<String, Integer> fun = Integer::parseInt;
//        Integer value = fun.apply("123");
//        System.out.println(value);
//
//        // 使用双冒号::来构造非静态函数引用
//        String content = "Hello JDK8";
//        Function<Integer, String> func = content::substring;
//        String result = func.apply(1);
//        System.out.println(result);
//
//        // 构造函数引用
//        BiFunction<String, Integer, User> biFunction = User::new;
//        User user = biFunction.apply("mengday", 28);
//        System.out.println(user.toString());
//
//        // 函数引用也是一种函数式接口，所以也可以将函数引用作为方法的参数
//        sayHello(String::toUpperCase, "hello");
        // Optional类已经成为Java 8类库的一部分，在Guava中早就有了，可能Oracle是直接拿来使用了
        // Optional用来解决空指针异常，使代码更加严谨，防止因为空指针NullPointerException对代码造成影响
        String msg = "hello";
        Optional<String> optional = Optional.of(msg);
        // 判断是否有值，不为空
        boolean present = optional.isPresent();
        // 如果有值，则返回值，如果等于空则抛异常
        String value = optional.get();
        // 如果为空，返回else指定的值
        String hi = optional.orElse("hi");
        // 如果值不为空，就执行Lambda表达式

        optional.ifPresent(opt -> {
            System.out.println(opt);
        });
    }

    private static void sayHello(Function<String, String> func, String parameter) {
        String result = func.apply(parameter);
        System.out.println(result);
    }
}

final class Integer {
    public static int parseInt(String s) throws NumberFormatException {
        return parseInt(s);
    }
}

class User {
    private String username;
    private Integer age;

    public User() {
    }

    public User(String username, Integer age) {
        this.username = username;
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", age=" + age +
                '}';
    }
}

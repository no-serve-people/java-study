package com.tracenull.j20201024;

import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * https://mp.weixin.qq.com/s/8TnBMloYxGJ2az-E1tK3nA
 * Java 8 异步 API、循环、日期，用好提高生产力！
 */
public class TestAync {
    // runAsync() 异步无参返回
    private static void asyncThread() throws ExecutionException, InterruptedException {
        CompletableFuture async1 = CompletableFuture.runAsync(() -> {
            try {
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName());
                System.out.println("none return Async");
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        // 调用get()将等待异步逻辑处理完成
        async1.get();
    }

    // supplyAsync() 异步有参返回
    public static void asyncThread2() throws ExecutionException, InterruptedException {
        CompletableFuture<String> async2 = CompletableFuture.supplyAsync(() -> {
            return "hello";
        });
        String result = async2.get();
        // String result2 = async2.get(5L, TimeUnit.SECONDS);
        System.out.println(result);
    }

    public static void asyncThread3() throws ExecutionException, InterruptedException {
        CompletableFuture<String> a = CompletableFuture.supplyAsync(() -> "hello");
        CompletableFuture<String> b = CompletableFuture.supplyAsync(() -> "youth");
        CompletableFuture<String> c = CompletableFuture.supplyAsync(() -> "!");
        CompletableFuture<Void> all = CompletableFuture.allOf(a, b, c);
        all.get();
        String result = Stream.of(a, b, c)
                .map(CompletableFuture::join)
                .collect(Collectors.joining(" "));
        System.out.println(result);
    }

    public static void asyncThread4() throws ExecutionException, InterruptedException {
        CompletableFuture<String> a = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(20);
                return "hello";
            } catch (Exception e) {
                e.printStackTrace();
                return "none~";
            }
        });

        CompletableFuture<String> b = CompletableFuture.supplyAsync(() -> "youth");
        CompletableFuture<String> c = CompletableFuture.supplyAsync(() -> "!");
        CompletableFuture<Object> any = CompletableFuture.anyOf(a, b, c);
        String result = (String) any.get();
        System.out.println(result);
    }


    public static void listForeach() {
        List<String> list = new ArrayList<String>(5) {
            {
                add("A");
                add("B");
                add("H");
                add("O");
                add("M");
            }
        };

        list.forEach(System.out::println);
        list.forEach((item) -> System.out.println(item.concat("_")));
    }

    public static void arrForeach() {
        String[] strArr = new String[]{"A", "B", "C", "D"};
        Arrays.stream(strArr).forEach(System.out::println);
    }


    public static void numericForeach() {
        IntStream.range(0, 10).forEach(System.out::println);
    }

    public static void mapForeach() {
        Map<String, Object> map = new HashMap<String, Object>(5) {{
            put("a", 1);
            put("b", true);
            put("c", 23.44F);
            put("d", "hello");
            put("e", 11L);
        }};
        map.forEach((k, v) -> {
            System.out.println(k.concat(":").concat(String.valueOf(v)));
        });

        String str = "hello";
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        asyncThread();
//        asyncThread2();
//        asyncThread3();
//        asyncThread4();
//        listForeach();
//        arrForeach();
//        numericForeach();
        mapForeach();
    }
}

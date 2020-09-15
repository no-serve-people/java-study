package com.tracenull.j20200915;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.Collectors;

/**
 * https://juejin.im/post/6872532181500690446?utm_source=gold_browser_extension
 */
public class parallelStreamTest {
    static void parallelTest() {
        List<Integer> numbers = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9,
                10, 11, 12, 13, 14, 15, 16, 17, 18, 19,
                20, 21, 22, 23, 24, 25, 26, 27, 28, 29);

//        final long begin = System.currentTimeMillis();
//        numbers.parallelStream().map(k -> {
//            try {
//                Thread.sleep(1000);
//                System.out.println((System.currentTimeMillis() - begin) + "ms=>" + k + "\t" + Thread.currentThread());
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            return k;
//        }).collect(Collectors.toList());
        ForkJoinPool pool = new ForkJoinPool(30);
        final long begin = System.currentTimeMillis();
        try {
            pool.submit(() ->
                    numbers.parallelStream().map(k -> {
                        try {
                            Thread.sleep(1000);
                            System.out.println((System.currentTimeMillis() - begin) + "ms => " + k + " \t" + Thread.currentThread());
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        return k;
                    }).collect(Collectors.toList())).get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Thread(() -> parallelTest()).start();
        new Thread(() -> parallelTest()).start();
        new Thread(() -> parallelTest()).start();
        new Thread(() -> parallelTest()).start();
        new Thread(() -> parallelTest()).start();
        new Thread(() -> parallelTest()).start();
        new Thread(() -> parallelTest()).start();
        new Thread(() -> parallelTest()).start();
    }
}

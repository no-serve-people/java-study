package com.tracenull.completeablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class CompletableFutureTest {
    public static void main(String[] args) {
        CompletableFuture<String> completableFuture = new CompletableFuture<>();
        completableFuture.complete("Future's Result Here Manually");

        try {
            completableFuture.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("运行在一个单独的线程中");
        });

        try {
            future.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        CompletableFuture<String> future3 = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }
            System.out.println("运行在单独的线程中");
            return "我有返回值";
        });

        try {
            System.out.println(future3.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        CompletableFuture<String> future4 = CompletableFuture.supplyAsync(() -> {
            // 可以注释掉做快速返回 start
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }
            System.out.println("👍");
            ;
            //可以注释掉做快速返回 end
            return "赞";
        }).thenApply(first -> {
            System.out.println("在看");
            return first + "在看";
        }).thenApply(second -> second + "转发");

        System.out.println("三连");

        try {
            System.out.println(future4.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }
}

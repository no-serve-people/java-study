package com.tracenull.completeablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * https://www.v2ex.com/t/700517#reply7
 */
public class v2extest {
    public static void main(String[] args) {
        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> {
            String supplyAsyncResult = " " + Thread.currentThread().getName() + " Hello world!";
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(supplyAsyncResult);
            return supplyAsyncResult;
        }).thenApplyAsync(r -> {
            String thenApplyResult = Thread.currentThread().getName() + " then apply";
            System.out.println(thenApplyResult);
            return thenApplyResult;
        });

        try {
            System.out.println(completableFuture.get() + " finish!");
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}

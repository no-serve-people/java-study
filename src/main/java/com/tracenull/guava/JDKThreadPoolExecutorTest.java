package com.tracenull.guava;

import com.google.common.util.concurrent.*;
import com.sun.corba.se.impl.orbutil.closure.Future;
import com.sun.istack.internal.NotNull;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class JDKThreadPoolExecutorTest {
    public static void main(String[] args) throws InterruptedException {
        ListeningExecutorService executor = MoreExecutors.listeningDecorator(Executors.newCachedThreadPool());
        ListenableFuture<String> listenableFuture = executor.submit(() -> {
            System.out.println(Thread.currentThread().getName() + "-女神：我开始化妆了，好了我叫你。");
            TimeUnit.SECONDS.sleep(5);
//            return "化妆完毕了。";
            throw new Exception("男神约我看电影，就不和你吃饭了。");
        });

        Futures.addCallback(listenableFuture, new FutureCallback<String>() {
            @Override
            public void onSuccess(@NotNull String result) {
                System.out.println(Thread.currentThread().getName() + "-future的内容:" + result);
            }

            @Override
            public void onFailure(Throwable throwable) {
                System.out.println(Thread.currentThread().getName() + "-女神放你鸽子了。");
                throwable.printStackTrace();
            }
        });
        System.out.println(Thread.currentThread().getName() + "-等女神化妆的时候可以干点自己的事情。");
        Thread.currentThread().join();
    }
}

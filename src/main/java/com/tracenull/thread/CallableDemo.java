package com.tracenull.thread;

import java.util.concurrent.*;

public class CallableDemo {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();

        Task task = new Task();
        Future<Integer> result = executorService.submit(task);
        executorService.shutdown();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("主线程正在执行任务");
        try {
            System.out.println("task运行结果" + result.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        System.out.println("所有任务执行完毕！");

    }
}

class Task implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        System.out.println("子线程在进行计算");
        TimeUnit.SECONDS.sleep(3);
        int sum = 0;
        for (int i = 0; i < 100; i++) {
            sum += i;
        }
        return sum;
    }
}

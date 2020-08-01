package com.tracenull.basic;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;


public class SynchronizedMethod {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(3);
        Test summation = new Test();
//        IntStream.range(0, 1000).forEach(count -> service.submit(summation::calculate));
//
        for (int i = 0; i < 1000; i++) {
            service.execute(summation::calculate);
//            new Thread(summation::calculate).start();
        }
        service.awaitTermination(1000, TimeUnit.MILLISECONDS);
        System.out.println(summation.getSum());
    }
}

class Test {
    private int sum;

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public void calculate() {
        setSum(getSum() + 1);
    }

}


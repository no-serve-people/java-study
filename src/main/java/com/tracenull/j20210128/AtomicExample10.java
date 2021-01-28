package com.tracenull.j20210128;

import java.util.concurrent.atomic.AtomicMarkableReference;

/**
 * 引用类型原子类
 * https://mp.weixin.qq.com/s/sFUdghgUJvEAQamvTbYBHw
 */
public class AtomicExample10 {
    private static final Integer INIT_NUM = 10;
    private static final Integer TEM_NUM = 20;
    private static final Integer UPDATE_NUM = 100;
    // 初始标记
    private static final Boolean INITIAL_MARK = Boolean.FALSE;
    private static AtomicMarkableReference atomicMarkableReference = new AtomicMarkableReference(INIT_NUM, INITIAL_MARK);

    public static void main(String[] args) {
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + ": 初始值为: " + INIT_NUM + " ,标记为: " + INITIAL_MARK);

            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (atomicMarkableReference.compareAndSet(INIT_NUM, UPDATE_NUM, atomicMarkableReference.isMarked(), Boolean.TRUE)) {
                System.out.println(Thread.currentThread().getName() + " : 修改后的值: " + atomicMarkableReference.getReference() + " , 标记为: " + atomicMarkableReference.isMarked());
            } else {
                System.out.println(Thread.currentThread().getName() + ": CAS返回false");
            }
        }, "线程A").start();


        new Thread(() -> {
            Thread.yield();
            System.out.println(Thread.currentThread().getName() + " ： 初始值为：" + atomicMarkableReference.getReference() + " , 标记为： " + INITIAL_MARK);
            atomicMarkableReference.compareAndSet(atomicMarkableReference.getReference(), TEM_NUM, atomicMarkableReference.isMarked(), Boolean.TRUE);
            System.out.println(Thread.currentThread().getName() + " ： 修改后的值为：" + atomicMarkableReference.getReference() + " , 标记为： " + atomicMarkableReference.isMarked());
        }, "线程B").start();

    }

}

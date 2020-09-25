package com.tracenull.j20200925;

/**
 * https://juejin.im/post/6861885337568804871
 */
public class VolatileSingleton {
//    private static VolatileSingleton instance = null;
    private static volatile VolatileSingleton instance = null;

    private VolatileSingleton() {
        System.out.println(Thread.currentThread().getName() + "\t 我是构造方法SingletonDemo");
    }

    public static VolatileSingleton getInstance() {
        // 第一重检测
        if (instance == null) {
            // 锁定代码块
            synchronized (VolatileSingleton.class) {
                // 第二重检测
                if (instance == null) {
                    // 实例化对象
                    instance = new VolatileSingleton();
                }
            }
        }
        return instance;
    }
}

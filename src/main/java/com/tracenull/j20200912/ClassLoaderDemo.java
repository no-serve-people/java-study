package com.tracenull.j20200912;

/**
 * https://mp.weixin.qq.com/s?__biz=MzAxNjQwOTU0Mg==&mid=2247484238&idx=1&sn=356504dc8b4d9c7e2fd1add25a34c6b5&chksm=9bf475e7ac83fcf18134ea60318c3c0a1609c6efb81d6b25972d7d64898756c19e9f76bb83a8&scene=178#rd
 */
public class ClassLoaderDemo {
    public static void main(String[] args) {
        System.out.println(String.class.getClassLoader());
        ClassLoader loader = ClassLoaderDemo.class.getClassLoader();

        while (loader != null) {
            System.out.println(loader);
            loader = loader.getParent();
        }
    }
}

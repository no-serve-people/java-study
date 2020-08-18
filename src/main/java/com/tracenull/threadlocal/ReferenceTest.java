package com.tracenull.threadlocal;

import java.lang.ref.WeakReference;

public class ReferenceTest {
    public static void main(String[] args) throws InterruptedException {
        WeakReference r = new WeakReference(new String("I'm here"));
        WeakReference sr = new WeakReference("I'm here");
        System.out.println("before gc: r=" + r.get() + ", static=" + sr.get());

        System.gc();
        Thread.sleep(100);
        //只有r.get()变为null
        System.out.println("after gc: r=" + r.get() + ", static=" + sr.get());

    }
}

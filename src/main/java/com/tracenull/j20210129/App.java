package com.tracenull.j20210129;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/**
 * 对象的属性修改原子类
 * https://mp.weixin.qq.com/s?__biz=Mzg5MzI4OTcyNQ==&mid=2247483790&idx=2&sn=470709a66bfdf502e17359484e760531&chksm=c030541cf747dd0a2ea6d88fd7514f7ec212341d02c00df79153dcc21b501b783951ee341e16&cur_album_id=1714067689356247045&scene=189#rd
 */
public class App {
    private static AtomicIntegerFieldUpdater<App> updater = AtomicIntegerFieldUpdater.newUpdater(App.class, "count");
    private volatile int count = 100;

    public int getCount() {
        return count;
    }

    public static void main(String[] args) {
        System.out.println("=======");

        App app = new App();
        if (updater.compareAndSet(app, 100, 200)) {
            System.out.println("更新成功1---" + app.getCount());
        }

        if (updater.compareAndSet(app, 100, 120)) {
            System.out.println("更新成功2---" + app.getCount());
        } else {
            System.out.println("更新失败---" + app.getCount());
        }

        System.out.println("=======");
    }

}

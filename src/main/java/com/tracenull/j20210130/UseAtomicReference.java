package com.tracenull.j20210130;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.concurrent.atomic.AtomicReference;

/**
 * 引用类型原子类
 * https://mp.weixin.qq.com/s/FvQSeUAjfinfYtcFci2K8w
 */
public class UseAtomicReference {
    static AtomicReference<UserInfo> atomicUserRef;

    public static void main(String[] args) {
        UserInfo user = new UserInfo("Mark", 15);// 要修改的实体的实例
        atomicUserRef = new AtomicReference<>(user);
        UserInfo updateUser = new UserInfo("Bill", 17);
        boolean a = atomicUserRef.compareAndSet(user, updateUser);

        System.out.println(a);
        System.out.println(atomicUserRef.get());
        System.out.println(user);
    }

    // 定义一个实体类
    @Data
    @AllArgsConstructor
    static class UserInfo {
        private volatile String name;
        private int age;
    }

}


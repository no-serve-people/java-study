package com.tracenull.j20201204.dp;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 动态代理
 * https://www.liaoxuefeng.com/wiki/1252599548343744/1264804593397984
 */
public class dp {
    public static void main(String[] args) throws Exception {
        InvocationHandler handler = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println(method);
                if (method.getName().equals("morning")) {
                    System.out.println("good morning," + args[0]);
                }

                return null;
            }
        };

        Hello hello = (Hello) Proxy.newProxyInstance(
                Hello.class.getClassLoader(),
                new Class[]{Hello.class},
                handler
        );
        hello.morning("Bob");
    }

    interface Hello {
        void morning(String name);
    }
}

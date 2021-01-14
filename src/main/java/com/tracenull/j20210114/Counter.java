package com.tracenull.j20210114;

/**
 * 泛型
 */
public class Counter {
    public static void main(String[] args) {
        Holder<User> holder = new Holder<User>();
        User user = new User();
        user.name = "111111";
        holder.set(user);
        change(holder);
        System.out.println(holder.get().name);
    }

    static void change(Holder<User> holder) {
        User _user = new User();
        _user.name = "222222";
        holder.set(_user);
    }
}

class User {
    String name;
}

class Holder<T> {
    private T t;

    public T get() {
        return t;
    }

    public void set(T t) {
        this.t = t;
    }
}

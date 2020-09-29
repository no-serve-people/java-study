package com.tracenull.j20200929;

/**
 * https://mp.weixin.qq.com/s/CQrhv5Z3DNrUlD1prH10CQ
 */
public class Contact implements Info {
    private String address;
    private String telphone;
    private String zipcode;

    public Contact(String address, String telphone, String zipcode) {
        this.address = address;
        this.telphone = telphone;
        this.zipcode = zipcode;
    }

    public String getAddress() {
        return address;
    }

    public String getTelphone() {
        return telphone;
    }

    public String getZipcode() {
        return zipcode;
    }

    @Override
    public String toString() {
        return "联系方式：" + "\n" + "\t|- 联系电话：" + this.telphone +
                "\t|- 联系地址：" + this.address +
                "\t|- 邮政编码：" + this.zipcode;
    }
}

interface Info {
}

class Intro implements Info {
    private String name;
    private String sex;
    private int age;

    public Intro(String name, String sex, int age) {
        this.name = name;
        this.sex = sex;
        this.age = age;
    }

    public String getname() {
        return name;
    }

    public String getsex() {
        return sex;
    }

    public int getage() {
        return age;
    }

    public String toString() {
        return "基本信息：" + "\n" + "\t|- 名字：" + this.name +
                "\t|- 性别：" + this.sex +
                "\t|- 年龄：" + this.age;
    }
}


class Person<T extends Info> {
    private T info;

    public Person(T info) {
        this.info = info;
    }

    public T getinfo() {
        return info;
    }

    public String toString() {
        return this.info.toString();
    }
}

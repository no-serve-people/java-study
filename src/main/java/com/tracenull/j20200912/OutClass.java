package com.tracenull.j20200912;

/**
 * https://mp.weixin.qq.com/s/5NrYV4kXQ8Uwla1rUGD8fw
 */
public class OutClass {
    private String name;
    private int id;
    private String address;

    public class innerClass {
        private String innerName;

        public void fun() {
            System.out.println(OutClass.this.name + ": " + innerName);
            System.out.println(OutClass.this.id + ": " + innerName);
            System.out.println(OutClass.this.address + ": " + innerName);
        }

        public innerClass(String innerName) {
            this.innerName = innerName;
        }
    }
}

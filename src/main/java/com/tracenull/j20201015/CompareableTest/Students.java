package com.tracenull.j20201015.CompareableTest;

/**
 * 比较器排序
 * https://mp.weixin.qq.com/s/lOxtk0NS6PigdLYvDwV6Yg
 */
public class Students implements Comparable<Students> {
    private int age;
    private String name;
    private int grade;

    public Students(int age, String name, int grade) {
        this.age = age;
        this.name = name;
        this.grade = grade;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public int getGrade() {
        return grade;
    }

    @Override
    public String toString() {
        return "name:" + this.getName() + "age:" + this.getAge() + "grade:" + this.getGrade();
    }

    @Override
    public int compareTo(Students stu) {
        if (this.grade > stu.grade) {
            return 1;
        } else if (this.grade < stu.grade) {
            return -1;
        } else {
            return this.name.compareTo(name);
        }
    }
}

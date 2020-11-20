package com.tracenull.j20201120;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

/**
 * 使用TreeMap
 * https://www.liaoxuefeng.com/wiki/1252599548343744/1265117109276544
 */
public class MapTest {
    public static void main(String[] args) {
//        Map<String, Integer> map = new TreeMap<>();
//        map.put("orange", 1);
//        map.put("apple", 2);
//        map.put("pear", 3);
//        System.out.println(map.keySet());
//
//        for (String key : map.keySet()) {
//            System.out.println(key);
//        }

//        Map<Person, Integer> map = new TreeMap<>(new Comparator<Person>() {
//            @Override
//            public int compare(Person p1, Person p2) {
//                return p1.name.compareTo(p2.name);
//            }
//        });
//
//        map.put(new Person("Tom"), 1);
//        map.put(new Person("Bob"), 2);
//        map.put(new Person("Lily"), 3);
//        System.out.println(new Person("hhaa"));
//        System.out.println(map.keySet());
//        for (Person key : map.keySet()) {
//            System.out.println(key);
//        }
//
//        System.out.println(map.get(new Person("Bob")));


        Map<Student, Integer> map = new TreeMap<>(new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
//                                return s1.name.compareTo(s1.name);
//
                System.out.println(11);
                return s1.score > s2.score ? -1 : 1;
            }
        });

        map.put(new Student("Tom", 77), 1);
        map.put(new Student("Bob", 66), 2);
        map.put(new Student("Lily", 99), 3);

//        System.out.println(map.keySet());

//        System.out.println(map);

        System.out.println(map.get(new Student("Bob1", 66)));

        for (Student key : map.keySet()) {
            System.out.println(key);
        }

    }

}


//class Person {
//    public String name;
//
//    Person(String name) {
//        this.name = name;
//    }
//
//    @Override
//    public String toString() {
//        return "Person{" +
//                "name='" + name + '\'' +
//                '}';
//    }
//}

class Student {
    public String name;

    public int score;

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    @Override
    public String toString() {
        return String.format("{%s: score=%d}", name, score);
    }
}

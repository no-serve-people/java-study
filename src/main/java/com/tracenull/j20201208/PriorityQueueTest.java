package com.tracenull.j20201208;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 优先队列
 * https://mp.weixin.qq.com/s/bYv_uUztHhr6sSatldUQYA
 */
public class PriorityQueueTest {
    public static void main(String[] args) {
        PriorityQueue queue = new PriorityQueue(10, (Comparator<Student>) (v1, v2) -> {
            return v2.getScore() - v1.getScore();
        });
        // 构建实体类
        Student s1 = new Student(80, "lvshen");
        Student s2 = new Student(100, "zhouzhou");
        Student s3 = new Student(60, "hall");
        // 入队
        queue.offer(s1);
        queue.offer(s2);
        queue.offer(s3);

        while (!queue.isEmpty()) {
            Student item = (Student) queue.poll();
            System.out.println("name:" + item.getName() + "level" + item.getScore());
        }
    }
}

@Data
@AllArgsConstructor
class Student {
    private Integer score;
    private String name;
}

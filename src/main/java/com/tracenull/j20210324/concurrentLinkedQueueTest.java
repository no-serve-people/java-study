package com.tracenull.j20210324;

import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * https://blog.csdn.net/liyantianmin/article/details/50585641
 * ConcurrentLinkedQueue使用方法
 */
public class concurrentLinkedQueueTest {
    public static void main(String[] args) {
        ConcurrentLinkedQueue<String> concurrentLinkedQueue = new ConcurrentLinkedQueue<>();
        concurrentLinkedQueue.add("a");
        concurrentLinkedQueue.add("b");
        concurrentLinkedQueue.add("c");
        concurrentLinkedQueue.offer("d"); // 将指定元素插入到此队列的尾部。
        concurrentLinkedQueue.peek(); // 检索并移除此队列的头，如果此队列为空，则返回 null。
        concurrentLinkedQueue.poll(); // 检索并移除此队列的头，如果此队列为空，则返回 null。

        for (String str : concurrentLinkedQueue) {
            System.out.println(str);
        }
    }
}

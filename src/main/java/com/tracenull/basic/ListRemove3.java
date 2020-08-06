package com.tracenull.basic;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class ListRemove3 {
    public static void main(String[] args) {
        // 添加信息
        List<PenBean3> penBeanList = new ArrayList<PenBean3>();
        penBeanList.add(new PenBean3("铅笔", "black"));
        penBeanList.add(new PenBean3("铅笔", "white"));
        penBeanList.add(new PenBean3("铅笔", "black"));
        penBeanList.add(new PenBean3("中性笔", "white"));
        penBeanList.add(new PenBean3("中性笔", "white"));
        // 使用java8新特性stream进行List去重
        List<PenBean3> newPenBeanList = penBeanList.stream().distinct().collect(Collectors.toList());

        newPenBeanList.forEach(System.out::println);
    }
}

class PenBean3 {
    private String type;
    private String color;

    public PenBean3(String type, String color) {
        this.type = type;
        this.color = color;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "PenBean3{" +
                "type='" + type + '\'' +
                ", color='" + color + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PenBean3 penBean3 = (PenBean3) o;

        return Objects.equals(type, penBean3.type) &&
                Objects.equals(color, penBean3.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, color);
    }
}


package com.tracenull.basic;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;

public class ListRemove4 {
    public static void main(String[] args) {
        //添加信息
        List<PenBean4> penBeanList = new ArrayList<PenBean4>();
        penBeanList.add(new PenBean4("铅笔", "black"));
        penBeanList.add(new PenBean4("铅笔", "white"));
        penBeanList.add(new PenBean4("铅笔", "black"));
        penBeanList.add(new PenBean4("中性笔", "white"));
        penBeanList.add(new PenBean4("中性笔", "white"));

        // 新数据
        List<PenBean4> newPenBeanList = new ArrayList<PenBean4>();

        HashSet<PenBean4> set = new HashSet<>(penBeanList);

        newPenBeanList.addAll(set);
        //输出结果
        System.out.println("=========新数据======");
        for (PenBean4 penBean : newPenBeanList) {
            System.out.println(penBean.toString());
        }
    }
}

class PenBean4 {
    private String type;
    private String color;

    public PenBean4(String type, String color) {
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
        return "PenBean4{" +
                "type='" + type + '\'' +
                ", color='" + color + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PenBean4 penBean4 = (PenBean4) o;

        return Objects.equals(type, penBean4.type) &&
                Objects.equals(color, penBean4.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, color);
    }
}


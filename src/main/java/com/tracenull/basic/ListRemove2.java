package com.tracenull.basic;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ListRemove2 {
    public static void main(String[] args) {
        //添加信息
        List<PenBean2> penBeanList = new ArrayList<PenBean2>();
        penBeanList.add(new PenBean2("铅笔","black"));
        penBeanList.add(new PenBean2("铅笔","white"));
        penBeanList.add(new PenBean2("铅笔","black"));
        penBeanList.add(new PenBean2("中性笔","white"));
        penBeanList.add(new PenBean2("中性笔","white"));

        List<PenBean2> newPenBeanList = new ArrayList<PenBean2>();
        // 使用contain判断，是否有相同的元素
        for (PenBean2 penBean2 : penBeanList) {
            if (!newPenBeanList.contains(penBean2)){
                newPenBeanList.add(penBean2);
            }
        }

        //输出结果
        System.out.println("=========新数据======");
        for (PenBean2 penBean : newPenBeanList) {
            System.out.println(penBean.toString());
        }
    }
}


class PenBean2 {
    private String type;
    private String color;

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

    public PenBean2(String type, String color) {
        this.type = type;
        this.color = color;
    }

    @Override
    public String toString() {
        return "PenBean2{" +
                "type='" + type + '\'' +
                ", color='" + color + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PenBean2 penBean2 = (PenBean2) o;
        // 当type、color 内容都相等的时候，才返回true

        return Objects.equals(type, penBean2.type) &&
                Objects.equals(color, penBean2.color);
    }
}

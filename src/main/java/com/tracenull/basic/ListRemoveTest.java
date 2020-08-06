package com.tracenull.basic;

import java.util.ArrayList;
import java.util.List;

public class ListRemoveTest {
    public static void main(String[] args) {
        ArrayList<PenBean> penBeanList = new ArrayList<PenBean>();
        penBeanList.add(new PenBean("铅笔", "black"));
        penBeanList.add(new PenBean("铅笔", "white"));
        penBeanList.add(new PenBean("铅笔", "black"));
        penBeanList.add(new PenBean("中性笔", "white"));
        penBeanList.add(new PenBean("中性笔", "white"));

        //新数据
        List<PenBean> newPenBeanList = new ArrayList<PenBean>();
        // 传统重复判断
        for (PenBean penBean : penBeanList) {
            if (newPenBeanList.isEmpty()) {
                newPenBeanList.add(penBean);
            } else {
                boolean isSame = false;
                for (PenBean newPenBean : newPenBeanList) {
                    // 依靠type、color来判断，是否有重复元素
                    // 如果新集合包含元素，直接跳过
                    if (penBean.getType().equals(newPenBean.getType()) && penBean.getColor().equals(newPenBean.getColor())) {
                        isSame = true;
                        break;
                    }
                }

                if (!isSame) {
                    newPenBeanList.add(penBean);
                }
            }

        }

        //输出结果
        System.out.println("=========新数据======");
        for (PenBean penBean : newPenBeanList) {
            System.out.println(penBean.toString());
        }
    }
}

class PenBean {
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

    public PenBean(String type, String color) {
        this.type = type;
        this.color = color;
    }

    @Override
    public String toString() {
        return "PenBean{" +
                "type='" + type + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}

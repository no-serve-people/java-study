package com.tracenull.j20201231;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * 听说又有兄弟因为用YYYY-MM-dd被锤了...
 * https://juejin.cn/post/6911874152953708558
 */
public class Tests {
    @Test
    public void test() {
        SimpleDateFormat df1 = new SimpleDateFormat("YYYY-MM-dd");
        SimpleDateFormat df2 = new SimpleDateFormat("yyyy-MM-dd");

        Calendar c = Calendar.getInstance();
        // 2020年12月26日周六
        c.set(Calendar.DATE, 26);
        System.out.println("YYYY-MM-dd = " + df1.format(c.getTime()));
        System.out.println("YYYY-MM-dd = " + df2.format(c.getTime()));
        // 分割线
        System.out.println("========================");
        // 2020年12月27日 周日
        c.add(Calendar.DATE, 1);
        System.out.println("YYYY-MM-dd = " + df1.format(c.getTime()));
        System.out.println("YYYY-MM-dd = " + df2.format(c.getTime()));
    }
}

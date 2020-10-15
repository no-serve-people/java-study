package com.tracenull.j20201015;

import java.time.*;
import java.time.temporal.ChronoField;

/**
 * 为什么建议使用你 LocalDateTime ，而不是 Date？
 * https://mp.weixin.qq.com/s/bTC-ooiViG9IreMTndGpMw
 */
public class LocalDateTest {
    public static void main(String[] args) {
//        // 获取当前年月日
//        LocalDate localDate = LocalDate.now();
//        System.out.println(localDate);
//        // 构造指定的年月日
//        LocalDate localDate1 = LocalDate.of(2019, 9, 10);
//        System.out.println(localDate1);
//
//        int year = localDate.getYear();
//        System.out.println(year);
//        int year1 = localDate.get(ChronoField.YEAR);
//        System.out.println(year1);
//        Month month = localDate.getMonth();
//        System.out.println(month);
//
//        int month1 = localDate.get(ChronoField.MONTH_OF_YEAR);
//        System.out.println(month1);
//
//        int day = localDate.getDayOfMonth();
//        System.out.println(day);
//
//        int day1 = localDate.get(ChronoField.DAY_OF_MONTH);
//        System.out.println(day1);
//
//        DayOfWeek dayOfWeek = localDate.getDayOfWeek();
//        System.out.println(dayOfWeek);
//
//        int dayOfWeek1 = localDate.get(ChronoField.DAY_OF_WEEK);
//        System.out.println(dayOfWeek1);

//        // 只会获取几点几分几秒
//
//        LocalTime localTime = LocalTime.of(13, 51, 10);
//        System.out.println(localTime);
//        LocalTime localTime1 = LocalTime.now();
//        System.out.println(localTime1);

//        // 获取小时
//
//        LocalTime localTime = LocalTime.of(13, 51, 10);
//        int hour = localTime.getHour();
//        int hour1 = localTime.get(ChronoField.HOUR_OF_DAY);
//
//        // 获取分
        LocalTime localTime = LocalTime.now();
//        int minute = localTime.getMinute();
//        int minute1 = localTime.get(ChronoField.MINUTE_OF_HOUR);
//        //获取秒
//        int second = localTime.getSecond();
//        int second1 = localTime.get(ChronoField.SECOND_OF_MINUTE);
        LocalDate localDate = LocalDate.now();
        LocalDateTime localDateTime = LocalDateTime.now();
        LocalDateTime localDateTime1 = LocalDateTime.of(2019, Month.SEPTEMBER, 10, 14, 46, 56);
        LocalDateTime localDateTime2 = LocalDateTime.of(localDate, localTime);
        LocalDateTime localDateTime3 = localDate.atTime(localTime);
        LocalDateTime localDateTime4 = localTime.atDate(localDate);
    }
}

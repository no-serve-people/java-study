package com.tracenull.j20200902;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.*;

/**
 * https://www.cnblogs.com/yangyongjie/p/11017409.html
 * 线程安全测试
 */
public class SimpleDateFormatTest {
    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    static ExecutorService service = Executors.newFixedThreadPool(10);

    public static void main(String[] args) {

        for (int i = 0; i < 300; i++) {
            service.execute(() -> {
                try {
                    String dateString = simpleDateFormat.format(new Date());
                    Date parseDate = simpleDateFormat.parse(dateString);
                    String dateString2 = simpleDateFormat.format(parseDate);

                    System.out.println(dateString.equals(dateString2));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            });
        }

    }
}

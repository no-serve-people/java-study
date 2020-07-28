package com.tracenull.basic;

public class StringBuilderDemo {
    public static final int CYCLE_NUM_BIGGER = 10_000_000;
    public static final int CYCLE_NUM_LOWER = 10_000;
    public static final String str1 = "张三";
    public static final String str2 = "李四";
    public static final String str3 = "王五";
    public static final String str4 = "赵六";

    /**
     * 循环内 String 拼接字符串，一次循环后销毁
     */
    public static void useString() {
        for (int i = 0; i < CYCLE_NUM_BIGGER; i++) {
            String str = str1 + i + str2 + i + str3 + i + str4;
        }
    }

    /**
     * 循环内 使用 StringBuilder 拼接字符串，一次循环后销毁
     */
    public static void useStringBuilder() {
        // 一
//        for (int i = 0; i < CYCLE_NUM_BIGGER; i++) {
//            StringBuilder sb = new StringBuilder();
//            String s = sb.append(str1).append(i).append(str2).append(i).append(str3).append(i).append(str4).toString();
//        }
        // 二
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < CYCLE_NUM_BIGGER; i++) {
//            sb.setLength(0);
            sb.delete(0, sb.length());
            String s = sb.append(str1).append(i).append(str2).append(i).append(str3).append(i).append(str4).toString();
        }
    }

    /**
     * 多次循环拼接成一个字符串 用 String，这篇推荐看下：不能用 + 拼接字符串？
     */
    public static void useStringSpliceOneStr() {
        String str = "";
        for (int i = 0; i < CYCLE_NUM_LOWER; i++) {
            str += str1 + str2 + str3 + str4;
        }
    }

    /**
     * 多次循环拼接成一个字符串 用 StringBuilder
     */
    public static void useStringBuilderSpliceOneStr() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < CYCLE_NUM_LOWER; i++) {
            sb.append(str1).append(str2).append(str3).append(str4).append(i);
        }
    }

    public static int executeSometime(int kind, int num) throws InterruptedException {
        Thread.sleep(2000);
        int sum = 0;
        for (int i = 0; i < num + 5; i++) {
            long begin = System.currentTimeMillis();
            switch (kind) {
                case 1:
                    useString();
                    break;
                case 2:
                    useStringBuilder();
                    break;
                case 3:
                    useStringSpliceOneStr();
                    break;
                case 4:
                    useStringBuilderSpliceOneStr();
                    break;
                default:
                    return 0;
            }
            long end = System.currentTimeMillis();

            if (i > 5) {
                sum += (end - begin);
            }
        }
        return sum / num;
    }

    public static void main(String[] args) throws InterruptedException {
        int time = 0;
        int num = 5;
        time = executeSometime(1, num);
        System.out.println("String拼接 "+ CYCLE_NUM_BIGGER +" 次，" + num + "次平均时间：" + time + " ms");

        time = executeSometime(2, num);
        System.out.println("StringBuilder拼接 "+ CYCLE_NUM_BIGGER +" 次，" + num + "次平均时间：" + time + " ms");

        time = executeSometime(3, num);
        System.out.println("String拼接单个字符串 "+ CYCLE_NUM_LOWER +" 次，" + num + "次平均时间：" + time + " ms");

        time = executeSometime(4, num);
        System.out.println("StringBuilder拼接单个字符串  "+ CYCLE_NUM_LOWER +" 次，" + num + "次平均时间：" + time + " ms");
    }
}

package com.tracenull.j20200921;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * https://mp.weixin.qq.com/s/LSPJcBvoFhrLYwJ2NpdzjQ
 */
public class SkinBuy {
    // 可以购买的点券数量
    static int[] coupon = {10, 60, 180, 300, 680, 1180, 1980};

    public static void main(String[] args) {
        // 初始化变量，通过减去余额优惠卷等计算出实际需要购买的点券数量
        int money = getMoney();
        // 根据贪心算法得到如何购买的点券集合
        List<Integer> buy = getHowMoney(money);
        // 输出购买策略
        prin(buy, money);
    }


    private static void prin(List<Integer> buy, int money) {
        System.out.println("尊敬的腾讯抠门用户,您最少需要花 " + buy.size() + " 次才能刚好凑到" + money + "点券");
        System.out.println("您只需要这样购买点券：");
        buy.forEach(b -> {// 遍历点券集合输出即可
            System.out.println(b + " ");
        });
    }

    /**
     * 根据贪心算法求出购买点券的策略
     *
     * @param money 实际需要购买的点券数量
     * @return
     */
    private static List<Integer> getHowMoney(int money) {
        ArrayList<Integer> buy = new ArrayList<>();

        while (money > 0) {
            // 找到可以购买的点券数组中数额最大的但是不超过money点券数
            int maxCoupon = maxCoupon(money);
            money -= maxCoupon;
            buy.add(maxCoupon);
        }
        return buy;
    }

    /**
     * 找到可以购买的点券数组中数额最大的但是不超过money点券数
     *
     * @param money 实际需要购买的点券数量
     * @return
     */
    private static int maxCoupon(int money) {
        // 默认为10 - 最小点券购买数
        int maxCoupon = 10;
        for (int m : coupon) {
            // 有序数组才可以这样
            if (money >= m) {
                maxCoupon = m;
            }
        }

        return maxCoupon;
    }

    /**
     * 初始化变量，通过减去余额优惠卷等计算出实际需要购买的点券数量
     *
     * @return
     */
    private static int getMoney() {
        Scanner input = new Scanner(System.in);
        // 皮肤的价钱-888点券
        System.out.print("请输入您要购买皮肤的价格(点券)：");
        int price = input.nextInt();
        // 账户余额 - 8点券
        System.out.print("请输入您的账户余额：");
        int balance = input.nextInt();
        // 优惠券 - 50点券
        System.out.print("请输入您的优惠卷：");
        int discount = input.nextInt();
        // 实际需要购买的点券
        int money = price - balance - discount;
        return money;
    }
}

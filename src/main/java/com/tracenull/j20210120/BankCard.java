package com.tracenull.j20210120;


/**
 * 为什么要有 AtomicReference ？
 * https://mp.weixin.qq.com/s/TbiC9n9bs6TOSjLL3CtpTg
 */
public class BankCard {
    private final String accountName;
    private final int money;

    // 构造函数初始化 accountName 和 money
    public BankCard(String accountName, int money) {
        this.accountName = accountName;
        this.money = money;
    }

    // 不提供任何修改个人账户的 set 方法，只提供 get 方法
    public String getAccountName() {
        return accountName;
    }

    public int getMoney() {
        return money;
    }

    // 不提供任何修改个人账户的 set 方法，只提供 get 方法

    @Override
    public String toString() {
        return "BankCard{" +
                "accountName='" + accountName + '\'' +
                ", money='" + money + '\'' +
                '}';
    }
}

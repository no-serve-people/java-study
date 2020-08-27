package com.tracenull.j20200827.jdkproxy;

/**
 * https://mp.weixin.qq.com/s/9eNjFltvbllcvqRW2WkcBQ
 */
public class ChanelFactory implements SellPerfume {
    @Override
    public void sellPerfume(double price) {
        System.out.println("成功购买香奈儿品牌的香水，价格是：" + price + "元");
    }
}

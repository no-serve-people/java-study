package com.tracenull.j20200827.jdkproxy;

import java.lang.reflect.Proxy;

public class XiaoMing {
    public static void main(String[] args) {
        // 静态代理
//        ChanelFactory factory = new ChanelFactory();
//        XiaoHongSellProxy proxy = new XiaoHongSellProxy(factory);
//        proxy.sellPerfume(1999.99);
        // 动态代理
//        ChanelFactory chanelFactory = new ChanelFactory();
//        SellProxyFactory sellProxyFactory = new SellProxyFactory(chanelFactory);
//        SellPerfume sellPerfume = (SellPerfume) Proxy.newProxyInstance(chanelFactory.getClass().getClassLoader(), chanelFactory.getClass().getInterfaces(),
//                sellProxyFactory);
//
//        sellPerfume.sellPerfume(1999.99);

        // 红酒代理
        // 实例化一个红酒销售商
        RedWineFactory redWineFactory = new RedWineFactory();
        // 实例化代理工厂，传入红酒销售商引用控制对其的访问
        SellProxyFactory sellProxyFactory = new SellProxyFactory(redWineFactory);
        // 实例化代理对象，该对象可以代理售卖红酒
        SellWine sellWineProxy = (SellWine) Proxy.newProxyInstance(redWineFactory.getClass().getClassLoader(),
                redWineFactory.getClass().getInterfaces(),
                sellProxyFactory);
        // 代理售卖红酒
        sellWineProxy.sellWine(1999.99);
    }
}

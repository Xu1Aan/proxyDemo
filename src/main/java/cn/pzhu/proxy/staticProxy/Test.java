package cn.pzhu.proxy.staticProxy;

import cn.pzhu.proxy.Order;

/**
 * @BelongsProject: proxyDemo
 * @BelongsPackage: cn.pzhu.proxy.staticProxy
 * @Author: XuAn
 * @CreateTime: 2019-11-23 17:08
 * @Version: 1.0
 */
public class Test {
    public static void main(String[] args) {
        Order order = new Order();
        order.setUserId(2);
        OrderServiceStaticProxy orderServiceStaticProxy = new OrderServiceStaticProxy();
        orderServiceStaticProxy.saveOrder(order);
    }
}

package cn.pzhu.proxy.dynamicProxy;

import cn.pzhu.proxy.IOrderService;
import cn.pzhu.proxy.IOrderServiceImpl;
import cn.pzhu.proxy.Order;

/**
 * @BelongsProject: proxyDemo
 * @BelongsPackage: cn.pzhu.proxy.dynamicProxy
 * @Author: XuAn
 * @CreateTime: 2019-11-23 17:45
 * @Version: 1.0
 */
public class Test {
    public static void main(String[] args) {
        Order order = new Order();
        order.setUserId(2);
        IOrderService orderServiceDynamicProxy = (IOrderService) new OrderServiceDynamicProxy(new IOrderServiceImpl()).bind();
        orderServiceDynamicProxy.saverOrder(order);
    }
}

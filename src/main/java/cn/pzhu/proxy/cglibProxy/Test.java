package cn.pzhu.proxy.cglibProxy;

import cn.pzhu.proxy.IOrderService;
import cn.pzhu.proxy.IOrderServiceImpl;
import cn.pzhu.proxy.Order;
import cn.pzhu.proxy.dynamicProxy.OrderServiceDynamicProxy;

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
        IOrderService orderServiceCglibProxy = (IOrderService) new OrderServiceCglibProxy(new IOrderServiceImpl()).bind();
        orderServiceCglibProxy.saverOrder(order);
    }
}

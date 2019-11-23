package cn.pzhu.proxy.staticProxy;

import cn.pzhu.proxy.IOrderService;
import cn.pzhu.proxy.IOrderServiceImpl;
import cn.pzhu.proxy.Order;
import cn.pzhu.proxy.db.DataSourceContextHolder;

/**
 * @BelongsProject: proxyDemo
 * @BelongsPackage: cn.pzhu.proxy.staticProxy
 * @Author: XuAn
 * @CreateTime: 2019-11-23 16:28
 * @Version: 1.0
 */
public class OrderServiceStaticProxy {
    private IOrderService iOrderService;

    public int saveOrder(Order order){
        beforMethod(order);
        iOrderService = new IOrderServiceImpl();
        int result = iOrderService.saverOrder(order);
        AfterMethod();
        return result;
    }

    private void beforMethod(Order order){
        int userId = order.getUserId();
        int dbRouter = userId%2;
        System.out.println("静态代理分配到[db:"+dbRouter+"]数据处理");
        //分表
        DataSourceContextHolder.setDBType("db"+String.valueOf(dbRouter));

        System.out.println("静态代理 Before Code");
    }

    private  void AfterMethod(){
        System.out.println("静态代理 After Code");
    }

}

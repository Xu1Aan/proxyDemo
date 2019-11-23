package cn.pzhu.proxy.dynamicProxy;

import cn.pzhu.proxy.Order;
import cn.pzhu.proxy.db.DataSourceContextHolder;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @BelongsProject: proxyDemo
 * @BelongsPackage: cn.pzhu.proxy.dynamicProxy
 * @Author: XuAn
 * @CreateTime: 2019-11-23 17:21
 * @Version: 1.0
 */
public class OrderServiceDynamicProxy implements InvocationHandler {

    private Object target;

    public OrderServiceDynamicProxy(Object target) {
        this.target = target;
    }
    public Object bind(){
        Class cls = target.getClass();
        return Proxy.newProxyInstance(cls.getClassLoader(),cls.getInterfaces(),this);
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] objects) throws Throwable {
        Object argObject = objects[0];
        BefoerMethod(argObject);
        Object object = method.invoke(target,objects);
        AfterMethod();
        return object;
    }

    private void BefoerMethod(Object obj){
        int userId = 0;
        System.out.println("动态代理 Before code");
        if(obj instanceof Order){
            Order order = (Order) obj;
            userId = order.getUserId()%2;
        }
        int dbRouter = userId%2;
        System.out.println("动态代理分配到[db:"+dbRouter+"]数据处理");
        //分库
        DataSourceContextHolder.setDBType("db"+String.valueOf(dbRouter));
    }

    private  void AfterMethod(){
        System.out.println("动态代理 After Code");
    }
}

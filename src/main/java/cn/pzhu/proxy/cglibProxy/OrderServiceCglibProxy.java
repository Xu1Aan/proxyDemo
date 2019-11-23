package cn.pzhu.proxy.cglibProxy;

import cn.pzhu.proxy.Order;
import cn.pzhu.proxy.db.DataSourceContextHolder;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @BelongsProject: proxyDemo
 * @BelongsPackage: cn.pzhu.proxy.cglibProxy
 * @Author: XuAn
 * @CreateTime: 2019-11-23 18:26
 * @Version: 1.0
 */
public class OrderServiceCglibProxy implements MethodInterceptor {

    private Object traget;

    public OrderServiceCglibProxy(Object traget) {
        this.traget = traget;
    }

    public Object bind(){
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(traget.getClass());
        enhancer.setCallback(this);
        return enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        Object argObject = objects[0];
        BefoerMethod(argObject);
        Object object = method.invoke(traget,objects);
        AfterMethod();
        return object;
    }

    private void BefoerMethod(Object obj){
        int userId = 0;
        System.out.println("Cglib动态代理 Before code");
        if(obj instanceof Order){
            Order order = (Order) obj;
            userId = order.getUserId()%2;
        }
        int dbRouter = userId%2;
        System.out.println("Cglib动态代理分配到[db:"+dbRouter+"]数据处理");
        //分库
        DataSourceContextHolder.setDBType("db"+String.valueOf(dbRouter));
    }

    private  void AfterMethod(){
        System.out.println("Cglib动态代理 After Code");
    }
}

package cn.pzhu.proxy;

/**
 * @BelongsProject: proxyDemo
 * @BelongsPackage: cn.pzhu.proxy
 * @Author: XuAn
 * @CreateTime: 2019-11-23 16:16
 * @Version: 1.0
 */
public interface IOrderService {
    int saverOrder(Order order);//返回生效行数
}

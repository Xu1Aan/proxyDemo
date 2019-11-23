package cn.pzhu.proxy;

/**
 * @BelongsProject: proxyDemo
 * @BelongsPackage: cn.pzhu.proxy
 * @Author: XuAn
 * @CreateTime: 2019-11-23 16:18
 * @Version: 1.0
 */
public interface IOrderDao {
    int insert(Order order);//返回影响行数
}

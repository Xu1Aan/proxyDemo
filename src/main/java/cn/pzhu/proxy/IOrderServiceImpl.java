package cn.pzhu.proxy;

/**
 * @BelongsProject: proxyDemo
 * @BelongsPackage: cn.pzhu.proxy
 * @Author: XuAn
 * @CreateTime: 2019-11-23 16:21
 * @Version: 1.0
 */
public class IOrderServiceImpl implements IOrderService {
    //@Autowire
    private IOrderDao iOrderDao;
    @Override
    public int saverOrder(Order order) {
        iOrderDao = new IOrderDaoImpl();//spring用@Autowire自动注入，这里直接new
        System.out.println("Service层调用Dao层添加Order");
        return iOrderDao.insert(order);
    }
}

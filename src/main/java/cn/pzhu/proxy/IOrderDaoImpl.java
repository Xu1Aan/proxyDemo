package cn.pzhu.proxy;

/**
 * @BelongsProject: proxyDemo
 * @BelongsPackage: cn.pzhu.proxy
 * @Author: XuAn
 * @CreateTime: 2019-11-23 16:19
 * @Version: 1.0
 */
public class IOrderDaoImpl implements IOrderDao {
    @Override
    public int insert(Order order) {
        System.out.println("Dao层添加成功");
        return 1;
    }
}

package cn.pzhu.proxy;


import lombok.Data;

/**
 * @BelongsProject: proxyDemo
 * @BelongsPackage: cn.pzhu.proxy
 * @Author: XuAn
 * @CreateTime: 2019-11-23 16:12
 * @Version: 1.0
 */
@Data
public class Order {
    private Object orderinfo;
    private Integer userId;
}

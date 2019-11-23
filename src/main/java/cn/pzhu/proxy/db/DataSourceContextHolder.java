package cn.pzhu.proxy.db;

/**
 * @BelongsProject: proxyDemo
 * @BelongsPackage: cn.pzhu.proxy.db
 * @Author: XuAn
 * @CreateTime: 2019-11-23 16:51
 * @Version: 1.0
 */
public class DataSourceContextHolder {
    private static final ThreadLocal<String> CONTEXT_HOLDER = new ThreadLocal<String>();

    public static void setDBType(String dbType){
        CONTEXT_HOLDER.set(dbType);
    }

    public static String getDBType(){
        return (String)CONTEXT_HOLDER.get();
    }

    public static void clearDBtype(){
        CONTEXT_HOLDER.remove();
    }
}

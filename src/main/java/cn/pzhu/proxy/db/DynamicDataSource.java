package cn.pzhu.proxy.db;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * @BelongsProject: proxyDemo
 * @BelongsPackage: cn.pzhu.proxy.db
 * @Author: XuAn
 * @CreateTime: 2019-11-23 16:46
 * @Version: 1.0
 */
public class DynamicDataSource extends AbstractRoutingDataSource {

    @Override
    protected Object determineCurrentLookupKey() {
        return DataSourceContextHolder.getDBType();
    }


/*    18     <bean id="dataSource" class="com.mchange.v2.c3p0.ComboPooledDataSource">
      19         <property name="jdbcUrl" value="${jdbc.url}"></property>
      20         <property name="driverClass" value="${jdbc.driverName}"></property>
      21         <property name="user" value="${jdbc.username}"></property>
      22         <property name="password" value="${jdbc.pwd}"></property>
      23     </bean>*/
}

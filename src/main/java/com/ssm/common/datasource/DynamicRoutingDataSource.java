package com.ssm.common.datasource;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * @Description: 动态取数据源类 
 * @author harry.zhang
 * CreateDate:	2017年6月15日
 */
public class DynamicRoutingDataSource extends AbstractRoutingDataSource {

    @Override
    protected Object determineCurrentLookupKey() {
    	String key = DynamicDataSourceHolder.getDataSourceKey();
        return key;
    }
}

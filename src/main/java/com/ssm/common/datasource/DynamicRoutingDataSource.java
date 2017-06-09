package com.ssm.common.datasource;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

public class DynamicRoutingDataSource extends AbstractRoutingDataSource {

    @Override
    protected Object determineCurrentLookupKey() {
    	String key = DynamicDataSourceHolder.getDataSourceKey();
        return key;
    }
}

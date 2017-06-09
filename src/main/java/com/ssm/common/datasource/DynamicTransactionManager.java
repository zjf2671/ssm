package com.ssm.common.datasource;

import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionDefinition;

public class DynamicTransactionManager extends DataSourceTransactionManager {

	private static final long serialVersionUID = -8768493851518494908L;
	@Override
	protected void doBegin(Object transaction, TransactionDefinition definition) {
		//带事物选择master数据库
		//DynamicDataSourceHolder.setDataSourceKey(DynamicDataSourceHolder.DataSoureKey.MASTER);
		super.doBegin(transaction, definition);
	}
}

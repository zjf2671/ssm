package com.ssm.common.datasource;

import org.aspectj.lang.JoinPoint;

//@Aspect
//@Order(value = -9999)
//@Component
public class DynamicDataSourceCmsAop {
	
//    @Before("execution(* com.rong.code.modules.cms.service..*.*(..))")
    public void checkTransaction(JoinPoint joinPoint) {
    	try {
    		Thread.sleep(15);
    		DynamicDataSourceHolder.setDataSourceKey(DynamicDataSourceHolder.DataSoureKey.CMS);
    	} catch (Exception e) {
    		DynamicDataSourceHolder.setDataSourceKey(DynamicDataSourceHolder.DataSoureKey.CMS);
    		e.printStackTrace();
		}
    }
}

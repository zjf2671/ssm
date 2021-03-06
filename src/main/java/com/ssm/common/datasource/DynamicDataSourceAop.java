package com.ssm.common.datasource;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.stereotype.Component;

/**
 * @Description: 数据源切换切面
 * @author harry.zhang
 * CreateDate:	2017年6月15日
 */
@Component("dataSourceAdvice")
public class DynamicDataSourceAop implements MethodBeforeAdvice{
	    

	@Override
	public void before(Method method, Object[] args, Object target) throws Throwable {
		 
		  String cmsClassName = target.getClass().getName();
          if(cmsClassName.indexOf("com.ssm.cms.service") !=-1){
        	  DynamicDataSourceHolder.setDataSourceKey(DynamicDataSourceHolder.DataSoureKey.CMS);
          }else{    	
        	  DynamicDataSourceHolder.setDataSourceKey(DynamicDataSourceHolder.DataSoureKey.MASTER);
          }
		
	}
       
}

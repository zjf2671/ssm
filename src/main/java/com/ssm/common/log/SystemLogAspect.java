package com.ssm.common.log;

import java.util.Enumeration;
import java.util.logging.Level;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.json.JSONObject;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

//修改参考 http://blog.csdn.net/liyisong2008/article/details/42915575

/**
 * @Description: 日志收集切面 
 * @author harry.zhang
 * @CreateDate:	2017年12月11日
 * @version 1.0
 */
@Aspect
@Component
public class SystemLogAspect {

	// 注入Service用于把日志保存数据库
	// 本地异常日志记录对象
	private Logger logger = Logger.getLogger(SystemLogAspect.class);// Controller层切点

	@Pointcut("@annotation(com.ssm.common.log.SystemControllerLog)")
	public void controllerAspect() {
	}

	/**
	 * 前置通知 用于拦截Controller层记录用户的操作
	 *
	 * @param joinPoint
	 *            切点
	 */
	@Around("controllerAspect()")
	public Object log(ProceedingJoinPoint joinPoint) {
		try {
			if (joinPoint == null)
				return null;
			JSONObject message = new JSONObject();
			HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
					.getRequest();
			 String ip = getIpAddr(request);

			// 获取方法参数
			Enumeration<String> eParams = request.getParameterNames();
			while (eParams.hasMoreElements()) {
				String key = eParams.nextElement();
				String value = request.getParameter(key);				
				if (removefile(key)) {
					if ("type".equals(key))
						key = "rtype";
					message.put(key, value);
				}				
			}

			// 获取header参数
			Enumeration<?> headerNames = request.getHeaderNames();
			while (headerNames.hasMoreElements()) {
				String key = (String) headerNames.nextElement();
				String value = request.getHeader(key);
				// 时间戳单位统一
				if ("timestamp".equals(key) && StringUtils.isNotBlank(value) && value.length() > 10) {
					value = value.substring(0, 10);
				}			
				if (removefile(key)) {
					if ("type".equals(key))
						key = "rtype";
					message.put(key, value);
				}				
			}
			
			message.put("class", joinPoint.getTarget().getClass().getName());
			message.put("request_method", joinPoint.getSignature().getName());
			message.put("ip", ip);
			message.put("systemName", "wechatecom");
			logger.fatal(message.toString());

			return joinPoint.proceed();
		} catch (Throwable throwable) {
                    java.util.logging.Logger.getLogger(SystemLogAspect.class.getName()).log(Level.SEVERE, null, throwable);//输出到console
			logger.error(throwable.getMessage());
		}
		return null;
	}

	/**
	 * 過濾不需要的字段
	 */
	public boolean removefile(String key) {
		String[] args = { "content-", "accept-", "x-", "user-", "cache-", "upgrade-","password","accept","randomKey","acctoken","accesstokenid"};
		if (StringUtils.isBlank(key)) {
			return false;
		}
		for (String str : args) {
			if (key.startsWith(str)) {
				return false;
			}
		}
		return true;
	}

	public String getIpAddr(HttpServletRequest request) {
		String ipAddress = null;
		ipAddress = request.getHeader("x-forwarded-for");
		if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
			ipAddress = request.getHeader("Proxy-Client-IP");
		}
		if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
			ipAddress = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
			ipAddress = request.getRemoteAddr();
		}

		// 对于通过多个代理的情况，第一个IP为客户端真实IP,多个IP按照','分割
		if (ipAddress != null && ipAddress.length() > 15) { // "***.***.***.***".length()
			// = 15
			if (ipAddress.indexOf(",") > 0) {
				ipAddress = ipAddress.substring(0, ipAddress.indexOf(","));
			}
		}
		// 或者这样也行,对于通过多个代理的情况，第一个IP为客户端真实IP,多个IP按照','分割
		// return
		// ipAddress!=null&&!"".equals(ipAddress)?ipAddress.split(",")[0]:null;
		return ipAddress;
	}
}

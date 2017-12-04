package com.ssm.service.rabbitmq;

/**
 * @Description: 功能概要：消息产生,提交到队列中去 
 * @author harry.zhang
 * @CreateDate:	2017年12月4日
 * @version 1.0
 */
public interface MessageProducerService {
	
	/**
	 * 发送消息到指定队列
	 * @param queueKey
	 * @param message
	 */
	public void sendMessage(String queueKey, Object message);
}

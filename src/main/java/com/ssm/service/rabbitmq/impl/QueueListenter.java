package com.ssm.service.rabbitmq.impl;

import java.io.UnsupportedEncodingException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.stereotype.Service;

@Service
public class QueueListenter implements MessageListener{
	
	private Logger logger = LoggerFactory.getLogger(QueueListenter.class);

	@Override
	public void onMessage(Message message) {
		try {
			logger.info("receive message:{}",message);
			String str = new String(message.getBody(), "UTF-8");
			logger.info("=====获取消息:"+str);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

	}

}

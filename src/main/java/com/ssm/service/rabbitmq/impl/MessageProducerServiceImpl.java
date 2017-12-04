package com.ssm.service.rabbitmq.impl;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Service;

import com.ssm.service.rabbitmq.MessageProducerService;

@Service
public class MessageProducerServiceImpl implements MessageProducerService {
	private Logger logger = LoggerFactory.getLogger(MessageProducerService.class);

	@Resource
	private AmqpTemplate amqpTemplate;
	
	@Override
	public void sendMessage(String queueKey, Object message){
		  logger.info("to send message:{}",message);
		  amqpTemplate.convertAndSend(queueKey, message);
	}
}

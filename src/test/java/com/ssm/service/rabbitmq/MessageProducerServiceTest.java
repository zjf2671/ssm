package com.ssm.service.rabbitmq;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.ssm.SpringBastTest;

public class MessageProducerServiceTest extends SpringBastTest{
	
	@Autowired
	private MessageProducerService messageProducerService;

	@Test
	public void testProducer() {
		for(int i=0;i<10;i++){
			messageProducerService.sendMessage("queueTestKey","harrytest"+i);
		}
	}

}

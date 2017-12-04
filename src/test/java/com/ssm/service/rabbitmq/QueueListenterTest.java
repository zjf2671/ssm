package com.ssm.service.rabbitmq;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.ssm.SpringBastTest;
import com.ssm.service.rabbitmq.impl.QueueListenter;

public class QueueListenterTest extends SpringBastTest {
	
	@Autowired
	private QueueListenter queueListenter;

	@Test
	public void testConsumer() {
	}

}

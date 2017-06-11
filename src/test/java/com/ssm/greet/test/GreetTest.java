package com.ssm.greet.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ssm.po.greet.GreetingsPO;
import com.ssm.service.greet.GreetingsService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:spring-context*.xml" })
public class GreetTest {
	
	@Autowired
	private GreetingsService greetingsService;
	
	@Test
	public void findListTest(){
		System.out.println(greetingsService.findList().get(0).getText());
	}
	
	@Test
	public void save(){
		GreetingsPO po = new GreetingsPO();
		po.setClasses("note-4 ui-draggable");
		po.setStyle("transform: rotate(19deg); left: 94.3245px; top: 402.324px; z-index: 99; cursor: pointer;");
		po.setText("哎呦，不错哦！！");
		greetingsService.insert(po);
		System.out.println(po.getId());
	}

}

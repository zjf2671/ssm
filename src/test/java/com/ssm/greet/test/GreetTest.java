package com.ssm.greet.test;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.ssm.SpringBastTest;
import com.ssm.po.greet.GreetingsPO;
import com.ssm.service.greet.GreetingsService;

public class GreetTest extends SpringBastTest{
	
	@Autowired
	private GreetingsService greetingsService;
	
	@Test
	public void findListTest(){
		System.out.println(greetingsService.findList(new GreetingsPO()).get(0).getText());
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

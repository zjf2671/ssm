package com.ssm.service.greet;

import java.util.List;

import com.ssm.po.greet.GreetingsPO;

public interface GreetingsService {
	
	public List<GreetingsPO> findList(GreetingsPO po);

	public GreetingsPO insert(GreetingsPO greetingsPO);

	public GreetingsPO update(GreetingsPO greetingsPO);

}

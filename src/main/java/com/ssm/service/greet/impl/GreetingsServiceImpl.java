package com.ssm.service.greet.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssm.dao.greet.GreetingsDAO;
import com.ssm.po.greet.GreetingsPO;
import com.ssm.service.greet.GreetingsService;

@Service
public class GreetingsServiceImpl implements GreetingsService {
	
	@Autowired
	private GreetingsDAO greettingsDAO;

	@Override
	public List<GreetingsPO> findList() {
		
		return greettingsDAO.findAll(new GreetingsPO());
	}

	@Override
	public GreetingsPO insert(GreetingsPO greetingsPO) {
		 greettingsDAO.insert(greetingsPO);
		 return greetingsPO;
	}

	@Override
	public GreetingsPO update(GreetingsPO greetingsPO) {
		greettingsDAO.update(greetingsPO);
		return greetingsPO;
	}
	
	

}

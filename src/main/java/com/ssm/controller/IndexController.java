package com.ssm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ssm.common.BaseSpringController;
import com.ssm.po.greet.GreetingsPO;
import com.ssm.service.greet.GreetingsService;

@Controller
public class IndexController extends BaseSpringController {
	
	@Autowired
	private GreetingsService greetingsService;
	
	@RequestMapping("/index")
	public String index(Model model){
		List<GreetingsPO> greetings = greetingsService.findList();
		model.addAttribute("greetings", greetings);
		return "index";
	}
	

}

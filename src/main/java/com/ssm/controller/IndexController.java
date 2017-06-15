package com.ssm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ssm.common.BaseSpringController;

/**
 * @Description: index入口类 
 * @author harry.zhang
 * @CreateDate:	2017年6月15日
 * @version 1.0
 */
@Controller
public class IndexController extends BaseSpringController {
	
	//@Autowired
	//private GreetingsService greetingsService;
	
	@RequestMapping("/index")
	public String index(Model model){
		//List<GreetingsPO> greetings = greetingsService.findList();
		//model.addAttribute("greetings", greetings);
		return "index";
	}
	

}

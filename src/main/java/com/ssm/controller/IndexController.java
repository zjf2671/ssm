package com.ssm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ssm.common.BaseSpringController;

@Controller
public class IndexController extends BaseSpringController {
	@RequestMapping("/index")
	public String index(Model model){
		return "index";
	}
	

}

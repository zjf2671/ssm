package com.ssm.controller.greet;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssm.common.BaseSpringController;
import com.ssm.common.JsonResult;
import com.ssm.po.greet.GreetingsPO;
import com.ssm.service.greet.GreetingsService;

@Controller
@RequestMapping("/greet")
public class GreetController extends BaseSpringController {
	
	@Autowired
	private GreetingsService greetingsService;
	
	@RequestMapping("/greetList")
	@ResponseBody
	public JsonResult<List<GreetingsPO>> findGreetList(){
		JsonResult<List<GreetingsPO>> result = new JsonResult<List<GreetingsPO>>();
		result.setData(greetingsService.findList());
		return result;
	}
	
	@RequestMapping("/save")
	@ResponseBody
	public JsonResult<GreetingsPO> save(GreetingsPO greetingsPO){
		JsonResult<GreetingsPO> result = new JsonResult<GreetingsPO>();
		greetingsService.insert(greetingsPO);
		result.setData(greetingsPO);
		return result;
	}
	
	@RequestMapping("/update")
	@ResponseBody
	public JsonResult<GreetingsPO> update(GreetingsPO greetingsPO){
		JsonResult<GreetingsPO> result = new JsonResult<GreetingsPO>();
		greetingsService.update(greetingsPO);
		result.setData(greetingsPO);
		return result;
	}

}

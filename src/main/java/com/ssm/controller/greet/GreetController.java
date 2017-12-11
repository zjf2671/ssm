package com.ssm.controller.greet;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssm.common.BaseSpringController;
import com.ssm.common.JsonResult;
import com.ssm.common.log.SystemControllerLog;
import com.ssm.po.greet.GreetingsPO;
import com.ssm.service.greet.GreetingsService;

/**
 * @Description: 祝福语处理类 
 * @author harry.zhang
 * @CreateDate:	2017年6月15日
 * @version 1.0
 */
@Controller
@RequestMapping("/greet")
public class GreetController extends BaseSpringController {
	
	@Autowired
	private GreetingsService greetingsService;
	
	@RequestMapping("/greetList")
	@SystemControllerLog
	public String findGreetList(Model model,GreetingsPO po){
		List<GreetingsPO> greetings = greetingsService.findList(po);
		model.addAttribute("greetings", greetings);
		return "greet/greets";
	}
	
	@RequestMapping("/greetAllList")
	@ResponseBody
	@SystemControllerLog
	public JsonResult<List<GreetingsPO>> findGreetList(GreetingsPO po){
		JsonResult<List<GreetingsPO>> result = new JsonResult<List<GreetingsPO>>();
		result.setData(greetingsService.findList(po));
		return result;
	}
	
	
	@RequestMapping("/save")
	@ResponseBody
	@SystemControllerLog
	public JsonResult<GreetingsPO> save(GreetingsPO greetingsPO){
		JsonResult<GreetingsPO> result = new JsonResult<GreetingsPO>();
		greetingsService.insert(greetingsPO);
		result.setData(greetingsPO);
		return result;
	}
	
	@RequestMapping("/update")
	@ResponseBody
	@SystemControllerLog
	public JsonResult<GreetingsPO> update(GreetingsPO greetingsPO){
		JsonResult<GreetingsPO> result = new JsonResult<GreetingsPO>();
		greetingsService.update(greetingsPO);
		result.setData(greetingsPO);
		return result;
	}

}

package com.ssm.controller.recipe;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssm.common.JsonResult;
import com.ssm.po.recipe.RecipeCountPO;
import com.ssm.service.recipe.RecipeCountService;

/**
 * @Description: 菜谱类
 * @author harry.zhang
 * @CreateDate:	2017年6月15日
 * @version 1.0
 */
@Controller
@RequestMapping("/recipe")
public class RecipeController {
	
	@Autowired
	private RecipeCountService recipeCountService;
	
	@RequestMapping("/index")
	public String index(Model model) {
		model.addAttribute("test", "hello word");
		return "recipe/list";
	}
	
	@RequestMapping("/recipeList")
	@ResponseBody
	public JsonResult<List<RecipeCountPO>> findList(){
		JsonResult<List<RecipeCountPO>> result = new JsonResult<List<RecipeCountPO>>();
		result.setData(recipeCountService.findList());
		
		return result;
	}
	
}

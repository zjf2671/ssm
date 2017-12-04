package com.ssm.recipe.test;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.ssm.SpringBastTest;
import com.ssm.service.recipe.RecipeCountService;

public class RecipeTest extends SpringBastTest{
	
	@Autowired
	private RecipeCountService recipeCountService;
	
	@Test
	public void testfindList() {
		
		System.out.println(recipeCountService.findList().get(0).getName());
		
	}
	

}

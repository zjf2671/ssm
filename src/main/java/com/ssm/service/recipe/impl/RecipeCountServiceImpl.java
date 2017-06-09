package com.ssm.service.recipe.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssm.dao.recipe.RecipeCountDAO;
import com.ssm.po.recipe.RecipeCountPO;
import com.ssm.service.recipe.RecipeCountService;

@Service
public class RecipeCountServiceImpl implements RecipeCountService{
	@Autowired
	private RecipeCountDAO recipeCountDAO;

	@Override
	public List<RecipeCountPO> findList() {
		
		return recipeCountDAO.findAll(new RecipeCountPO());
		
	}
	
}

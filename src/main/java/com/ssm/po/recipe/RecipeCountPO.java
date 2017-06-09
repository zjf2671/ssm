package com.ssm.po.recipe;

import java.io.Serializable;

/**
 * 
 * @author harry.zhang
 * @date 2017-06-08 15:35:48
 */
public class RecipeCountPO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;

	/**
	 * 
	 */
	private String name;

	/**
	 * 
	 */
	private Integer recipecount;

	/**
	 * 
	 */
	private Integer titlecount;

	public Integer getId() {
		return id;
	}

	/**
	 * 
	 * @param id 
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * 
	 * @return 
	 */
	public String getName() {
		return name;
	}

	/**
	 * 
	 * @param name 
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 
	 * @return 
	 */
	public Integer getRecipecount() {
		return recipecount;
	}

	/**
	 * 
	 * @param recipecount 
	 */
	public void setRecipecount(Integer recipecount) {
		this.recipecount = recipecount;
	}

	/**
	 * 
	 * @return 
	 */
	public Integer getTitlecount() {
		return titlecount;
	}

	/**
	 * 
	 * @param titlecount 
	 */
	public void setTitlecount(Integer titlecount) {
		this.titlecount = titlecount;
	}
}
	
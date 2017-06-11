package com.ssm.po.greet;

import java.io.Serializable;

/**
 * 
 * @author harry.zhang
 * @date 2017-06-11 12:03:35
 */
public class GreetingsPO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;

	/**
	 * 
	 */
	private String classes;

	/**
	 * 
	 */
	private String style;

	/**
	 * 
	 */
	private String text;

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
	public String getClasses() {
		return classes;
	}

	/**
	 * 
	 * @param classes 
	 */
	public void setClasses(String classes) {
		this.classes = classes;
	}

	/**
	 * 
	 * @return 
	 */
	public String getStyle() {
		return style;
	}

	/**
	 * 
	 * @param style 
	 */
	public void setStyle(String style) {
		this.style = style;
	}

	/**
	 * 
	 * @return 
	 */
	public String getText() {
		return text;
	}

	/**
	 * 
	 * @param text 
	 */
	public void setText(String text) {
		this.text = text;
	}
}
	
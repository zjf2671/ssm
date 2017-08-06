package com.ssm.po.greet;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @author harry.zhang
 * @date 2017-06-14 19:08:01
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

	/**
	 * 
	 */
	private Date createTime;
	
	/**
	 * 
	 */
	private Date updateTime;
	
	/**
	 * 
	 */
	private String name;
	
	
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

	/**
	 * 
	 * @return 
	 */
	public Date getCreateTime() {
		return createTime;
	}

	/**
	 * 
	 * @param createTime 
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
	
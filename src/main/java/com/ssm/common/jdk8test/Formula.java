package com.ssm.common.jdk8test;

/**
 * @Description: Java 8允许我们给接口添加一个非抽象的方法实现，
 * 只需要使用 default关键字即可，这个特征又叫做扩展方法
 * @author harry.zhang
 * @CreateDate:	2017年7月4日
 * @version 1.0
 */
interface Formula {
	double calculate(int a);

	default double sqrt(int a) {
		return Math.sqrt(a);
	}
}
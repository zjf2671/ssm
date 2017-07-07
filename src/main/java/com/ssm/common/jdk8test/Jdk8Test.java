package com.ssm.common.jdk8test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Description: jdk8特性展示 
 * @author harry.zhang
 * @CreateDate:	2017年7月4日
 * @version 1.0
 */
public class Jdk8Test {

	public static void main(String[] args) {
		// test f = new test();
		// System.out.println(f.sqrt(1));

		List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");
		/*
		 * Collections.sort(names, new Comparator<String>() {
		 * 
		 * @Override public int compare(String a, String b) { return
		 * b.compareTo(a); } });
		 */
		
		//Lambda 表达式
		Collections.sort(names, (a,b) -> 
			 b.compareTo(a)
		);

		for (String name : names) {
			System.out.println(name);
		}
		
		
		Converter<String, Integer> converter = (from) -> Integer.valueOf(from);
		Integer converted = converter.convert("123");
		System.out.println(converted);    // 123

	}

}

class test implements Formula {

	@Override
	public double calculate(int a) {
		// TODO Auto-generated method stub
		return 0;
	}

}

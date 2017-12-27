package com.ssm.common.jdk8test;

/**
 * @Description: 函数式接口
 * @author harry.zhang
 * @CreateDate:	2017年7月4日
 * @version 1.0
 * @param <F>
 * @param <T>
 */
interface Converter<F, T> {
    T convert(F from);
    default void say(){
        System.out.println("default say");


    }
    default void say2(){
        System.out.println("default say2");


    }
}
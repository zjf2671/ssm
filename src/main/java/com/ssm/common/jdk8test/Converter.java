package com.ssm.common.jdk8test;

/**
 * @Description: 函数式接口
 * @author harry.zhang
 * @CreateDate:	2017年7月4日
 * @version 1.0
 * @param <F>
 * @param <T>
 */
@FunctionalInterface
interface Converter<F, T> {
    T convert(F from);
}
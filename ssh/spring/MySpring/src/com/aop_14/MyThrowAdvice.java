package com.aop_14;

import java.lang.reflect.Method;

import org.springframework.aop.ThrowsAdvice;

public class MyThrowAdvice implements ThrowsAdvice {
	public void afterThrowing(Method m,Object[] os,Object target,Exception e){
		System.out.println("异常抛出通知："+e.getMessage());
	}
}

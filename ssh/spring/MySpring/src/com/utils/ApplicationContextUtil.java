package com.utils;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

final public class ApplicationContextUtil {
	private static ApplicationContext ac=null;
	private ApplicationContextUtil(){
		// TODO Auto-generated constructor stub
	}
	static{
		ac=new ClassPathXmlApplicationContext("applicationContext.xml");
	}
	public static ApplicationContext getApplicationContext(){
		return ac; 
	}
}

package com.aop_14;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class APP1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ac=new ClassPathXmlApplicationContext("com/aop_14/beans.xml");
		TestServiceInter testService1=(TestServiceInter)ac.getBean("proxyFactoryBean");
		System.out.println("testService1的类型是L："+testService1.getClass());
		testService1.sayhello();  
		//int a=10/0;
		((TestServiceInter2)testService1).sayBey();//testService1可以转化为TestServiceInter接口类型的，因为testService1引用的对象同时实现了他们两个接口
		
	}

}

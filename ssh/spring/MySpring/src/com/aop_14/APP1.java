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
		System.out.println("testService1��������L��"+testService1.getClass());
		testService1.sayhello();  
		//int a=10/0;
		((TestServiceInter2)testService1).sayBey();//testService1����ת��ΪTestServiceInter�ӿ����͵ģ���ΪtestService1���õĶ���ͬʱʵ�������������ӿ�
		
	}

}

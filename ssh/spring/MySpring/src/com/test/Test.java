package com.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.service.BybService;
import com.service.UserService;
import com.utils.ApplicationContextUtil;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*�������ô�ͳ�ķ���������UserService��sayHello����*/
		/*UserService us=new UserService();
		us.setName("xiaoli");
		us.sayHello();*/
		
		/*��spring���������*/
		/*1.�õ�spring��applicationContext������������*/
		//��ApplicationContext����̬��
		ApplicationContext ac=ApplicationContextUtil.getApplicationContext();
		UserService us=(UserService)ac.getBean("userService");
		
		us.sayHello();
		
		BybService bye=(BybService)ac.getBean("bybService");
		bye.SayBye();
		/*2.*/
	}

}

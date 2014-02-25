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
		/*我们先用传统的方法来调用UserService的sayHello方法*/
		/*UserService us=new UserService();
		us.setName("xiaoli");
		us.sayHello();*/
		
		/*用spring来完成上述*/
		/*1.得到spring的applicationContext对象（容器对象）*/
		//将ApplicationContext做单态的
		ApplicationContext ac=ApplicationContextUtil.getApplicationContext();
		UserService us=(UserService)ac.getBean("userService");
		
		us.sayHello();
		
		BybService bye=(BybService)ac.getBean("bybService");
		bye.SayBye();
		/*2.*/
	}

}

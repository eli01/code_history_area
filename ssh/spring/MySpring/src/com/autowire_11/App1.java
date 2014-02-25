package com.autowire_11;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ac=new ClassPathXmlApplicationContext("com/autowire_11/beans.xml");
		/*toingguo rongqi huode zhuren */
		Master master=(Master)ac.getBean("master");
		System.out.println(master.getDog().getName());
	}

}

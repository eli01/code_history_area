package com.constructor_11;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class APP1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ac=new ClassPathXmlApplicationContext("com/constructor_11/beans.xml");
		Employee employee=(Employee)ac.getBean("employee");
		System.out.println(employee.getName());
	}

}

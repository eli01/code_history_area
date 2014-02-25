package com.dispatch_12;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class APP1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ac=new ClassPathXmlApplicationContext("com/dispatch_12/beans.xml");
		DBUtil db=(DBUtil)ac.getBean("dbutil");
		System.out.println(db.getName());
	}

}

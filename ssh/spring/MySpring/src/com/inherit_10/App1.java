package com.inherit_10;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ac=new ClassPathXmlApplicationContext("com/inherit_10/beans.xml");
		Gradate gradate=(Gradate)ac.getBean("gradate");
		System.out.println(gradate.getAge()+" "+gradate.getName()+" "+gradate.getDegree());
	}

}

package com.beanlife;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

public class App2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BeanFactory factory=new XmlBeanFactory(new ClassPathResource("com/beanlife/beans.xml"));
		PersonService ps=(PersonService)factory.getBean("personService");
		ps.sayHi();
	}

}

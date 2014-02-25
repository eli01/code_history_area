package com.ioc;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

public class App1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/***
		 * 测试ApplicationContext和BeanFactory的区别
		 */
		/*从上下文
		System.out.println("ApplicationContext方式：");
		当读取bean.xml，创建容器实例的同时，bean.xml配置的bean被实例化
		ApplicationContext ac=new ClassPathXmlApplicationContext("com/ioc/beans.xml");
		从beans中取出Student
		System.out.println("BeanFactory方式：");
		创建容器的同时，bean.xml配置的bean没有同时被实例化
		BeanFactory factory=new XmlBeanFactory(
				new ClassPathResource("com/ioc/beans.xml"));
		System.out.println("factory.getBean(\"student\");");
		此时实例化配置的student这个bean
		factory.getBean("student");*/
		
		/**
		 * scope属性测试
		 */
		/*第一次：配置scope="singleton"*/
		/*第二次：配置scope="prototype"*/
		ApplicationContext ac=new ClassPathXmlApplicationContext("com/ioc/beans.xml");
		Student stu1=(Student)ac.getBean("student");
		Student stu2=(Student)ac.getBean("student");
		System.out.println(stu1+" "+stu2);//地址相同
		
		/**
		 * 
		 */
		/*通过文件路径创建*/
		ApplicationContext ac2=new FileSystemXmlApplicationContext("F:\\Workstation\\workspace for spring\\MySpring\\src\\com\\ioc\\beans.xml");		
		

	}

}

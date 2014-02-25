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
		 * ����ApplicationContext��BeanFactory������
		 */
		/*��������
		System.out.println("ApplicationContext��ʽ��");
		����ȡbean.xml����������ʵ����ͬʱ��bean.xml���õ�bean��ʵ����
		ApplicationContext ac=new ClassPathXmlApplicationContext("com/ioc/beans.xml");
		��beans��ȡ��Student
		System.out.println("BeanFactory��ʽ��");
		����������ͬʱ��bean.xml���õ�beanû��ͬʱ��ʵ����
		BeanFactory factory=new XmlBeanFactory(
				new ClassPathResource("com/ioc/beans.xml"));
		System.out.println("factory.getBean(\"student\");");
		��ʱʵ�������õ�student���bean
		factory.getBean("student");*/
		
		/**
		 * scope���Բ���
		 */
		/*��һ�Σ�����scope="singleton"*/
		/*�ڶ��Σ�����scope="prototype"*/
		ApplicationContext ac=new ClassPathXmlApplicationContext("com/ioc/beans.xml");
		Student stu1=(Student)ac.getBean("student");
		Student stu2=(Student)ac.getBean("student");
		System.out.println(stu1+" "+stu2);//��ַ��ͬ
		
		/**
		 * 
		 */
		/*ͨ���ļ�·������*/
		ApplicationContext ac2=new FileSystemXmlApplicationContext("F:\\Workstation\\workspace for spring\\MySpring\\src\\com\\ioc\\beans.xml");		
		

	}

}

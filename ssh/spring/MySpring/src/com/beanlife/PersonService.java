package com.beanlife;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class PersonService implements DisposableBean, InitializingBean,BeanNameAware,BeanFactoryAware,ApplicationContextAware{
	private String name;
	private Integer age;
	
	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public void sayHi(){
		System.out.println("Hi!"+name);
	}
	public PersonService(){
		System.out.println("PersonService():����һ���µ�PersionService");
	}

	/*�Լ�����Ļ��ڴ�����ʵ��ʱ�Զ������õķ���*/
	/*Ҳ������ע��ķ�ʽ�������Ǹ���ʼ���ķ���init-method*/
	//@PostConstruct
	public void init(){
		System.out.println("�Զ���ķ����ڸ�bean������ʱ����");
	} 
	@Override
	public void setBeanName(String arg0) {
		// TODO Auto-generated method stub
		/*arg0��ʾ��ǰbean��id*/
		System.out.println("setBeanName:"+arg0);
	}

	@Override
	public void setBeanFactory(BeanFactory arg0) throws BeansException {
		// TODO Auto-generated method stub
		System.out.println("setBeanFactory:���Bean����"+arg0.getBean("personService"));
	}

	@Override
	public void setApplicationContext(ApplicationContext arg0)
			throws BeansException {
		// TODO Auto-generated method stub
		System.out.println("setApplicationContext"+arg0);
		
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("afterPropertiesSet()������");
	}

	@Override
	public void destroy() throws Exception {
		// TODO Auto-generated method stub
		/*��������Թر��������ӣ�socket�ļ������ͷŸ�bean����Դ����*/
		/*������ʹ�ã����̫��*/
	}
	/*����destroy()*/
	//@PreDestroy
	public void mydestroy(){
		/*�÷�������Ϊ��spring�����رպ���ã���˲��󿴿��ǵ��ù���*/
		System.out.println("�������ٷ����������ã�");
	}
}

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
		System.out.println("PersonService():创建一个新的PersionService");
	}

	/*自己定义的会在创建该实例时自动被调用的方法*/
	/*也可以用注解的方式来配置那个初始化的方法init-method*/
	//@PostConstruct
	public void init(){
		System.out.println("自定义的方法在该bean被创建时调用");
	} 
	@Override
	public void setBeanName(String arg0) {
		// TODO Auto-generated method stub
		/*arg0表示当前bean的id*/
		System.out.println("setBeanName:"+arg0);
	}

	@Override
	public void setBeanFactory(BeanFactory arg0) throws BeansException {
		// TODO Auto-generated method stub
		System.out.println("setBeanFactory:获得Bean工厂"+arg0.getBean("personService"));
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
		System.out.println("afterPropertiesSet()被调用");
	}

	@Override
	public void destroy() throws Exception {
		// TODO Auto-generated method stub
		/*在这里可以关闭数据连接，socket文件流，释放该bean的资源……*/
		/*不建议使用，耦合太高*/
	}
	/*定制destroy()*/
	//@PreDestroy
	public void mydestroy(){
		/*该方法配置为在spring容器关闭后调用，因此不贵看看那调用过程*/
		System.out.println("定制销毁方法！被调用！");
	}
}

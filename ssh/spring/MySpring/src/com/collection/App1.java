package com.collection;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ac=new ClassPathXmlApplicationContext("com/collection/beans.xml");
		Department depart=(Department)ac.getBean("department");
		System.out.println(depart.getEmpName()[0]);
		System.out.println("*******通过list集合取出数据*******");
		List<Employee> list=depart.getEmpList();
		for(Employee e:list){
			System.out.println(e.getName());
		}
		System.out.println("**********通过set集合取出数据**************");
		Set<Employee> set=depart.getEmpSet();
		for(Employee e:set){
			System.out.println(e.getName());
		}
		System.out.println("**********通过map集合取出数据**************");
		
		Map<String,Employee> map=depart.getEmpMap();
		/*1.迭代器*/
		System.out.println("迭代器法：");
		Iterator it=map.entrySet().iterator();
		while(it.hasNext()){
			Entry<String, Employee> entry=(Entry<String, Employee>)it.next();
			System.out.println(entry.getKey()+" "+entry.getValue().getName());
		}
		/*2.简洁方法*/
		System.out.println("简洁方法：");
		for(Entry<String, Employee> entry: map.entrySet()){
			System.out.println(entry.getKey()+" "+entry.getValue().getName());
		}
		System.out.println("**********通过properties取出数据***********");
		Properties pp=depart.getPp();
		System.out.println("通过entrySet方式：");
		System.out.println(pp.getProperty("pp1"));
		System.out.println(pp.get("pp2"));
		/*entrySet()的方式*/
		for(Entry<Object,Object> entry:pp.entrySet()){
			System.out.println(entry.getKey().toString()+" "+entry.getValue().toString());
		}
		/*通过枚举来取出*/
		System.out.println("通过枚举方式：");
		Enumeration element=pp.elements();
		Enumeration keys=pp.keys();
		/*element:只有值没有key*/
		System.out.println("element:只有值没有key");
		while(element.hasMoreElements()){
			/*Entry<Object,Object> entry=(Entry<Object,Object>)enumeration.nextElement();
			System.out.println(entry.getKey().toString()+" "+entry.getValue().toString());*/
			System.out.println(element.nextElement().toString());
		}
		/*keys:只有key没有值*/
		System.out.println("keys:只有key没有值");
		while(keys.hasMoreElements()){
			String key=keys.nextElement().toString();
			System.out.println(key+" "+pp.get(key));
		}
	}

}

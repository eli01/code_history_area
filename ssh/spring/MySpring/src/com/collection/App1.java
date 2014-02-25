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
		System.out.println("*******ͨ��list����ȡ������*******");
		List<Employee> list=depart.getEmpList();
		for(Employee e:list){
			System.out.println(e.getName());
		}
		System.out.println("**********ͨ��set����ȡ������**************");
		Set<Employee> set=depart.getEmpSet();
		for(Employee e:set){
			System.out.println(e.getName());
		}
		System.out.println("**********ͨ��map����ȡ������**************");
		
		Map<String,Employee> map=depart.getEmpMap();
		/*1.������*/
		System.out.println("����������");
		Iterator it=map.entrySet().iterator();
		while(it.hasNext()){
			Entry<String, Employee> entry=(Entry<String, Employee>)it.next();
			System.out.println(entry.getKey()+" "+entry.getValue().getName());
		}
		/*2.��෽��*/
		System.out.println("��෽����");
		for(Entry<String, Employee> entry: map.entrySet()){
			System.out.println(entry.getKey()+" "+entry.getValue().getName());
		}
		System.out.println("**********ͨ��propertiesȡ������***********");
		Properties pp=depart.getPp();
		System.out.println("ͨ��entrySet��ʽ��");
		System.out.println(pp.getProperty("pp1"));
		System.out.println(pp.get("pp2"));
		/*entrySet()�ķ�ʽ*/
		for(Entry<Object,Object> entry:pp.entrySet()){
			System.out.println(entry.getKey().toString()+" "+entry.getValue().toString());
		}
		/*ͨ��ö����ȡ��*/
		System.out.println("ͨ��ö�ٷ�ʽ��");
		Enumeration element=pp.elements();
		Enumeration keys=pp.keys();
		/*element:ֻ��ֵû��key*/
		System.out.println("element:ֻ��ֵû��key");
		while(element.hasMoreElements()){
			/*Entry<Object,Object> entry=(Entry<Object,Object>)enumeration.nextElement();
			System.out.println(entry.getKey().toString()+" "+entry.getValue().toString());*/
			System.out.println(element.nextElement().toString());
		}
		/*keys:ֻ��keyû��ֵ*/
		System.out.println("keys:ֻ��keyû��ֵ");
		while(keys.hasMoreElements()){
			String key=keys.nextElement().toString();
			System.out.println(key+" "+pp.get(key));
		}
	}

}

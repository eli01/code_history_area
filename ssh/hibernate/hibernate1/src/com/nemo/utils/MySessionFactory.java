package com.nemo.utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
/*原则：一个数据库对应一个sessionfactory,节约资源*/
public class MySessionFactory {
	private static SessionFactory sf=null;
	/*将构造函数做成私有的，保证不能被实例化,保证单态*/
	private MySessionFactory(){
		
	}
	static{
		sf=new Configuration().configure().buildSessionFactory();
	}
	public static SessionFactory getSessionFactory(){
		return sf;
	}
}

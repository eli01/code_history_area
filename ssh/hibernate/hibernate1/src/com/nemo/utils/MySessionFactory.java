package com.nemo.utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
/*ԭ��һ�����ݿ��Ӧһ��sessionfactory,��Լ��Դ*/
public class MySessionFactory {
	private static SessionFactory sf=null;
	/*�����캯������˽�еģ���֤���ܱ�ʵ����,��֤��̬*/
	private MySessionFactory(){
		
	}
	static{
		sf=new Configuration().configure().buildSessionFactory();
	}
	public static SessionFactory getSessionFactory(){
		return sf;
	}
}

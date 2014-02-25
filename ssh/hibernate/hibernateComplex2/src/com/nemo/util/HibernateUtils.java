package com.nemo.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

final public class HibernateUtils {
	private static SessionFactory sessionfactory=null; 
	/*ʹ���ֲ߳̾�ģʽ*/
	private static ThreadLocal<Session> threadLocal=new ThreadLocal<Session>();
	private HibernateUtils(){};
	
	static{
		sessionfactory=new Configuration().configure().buildSessionFactory();
	}
	
	/*�ײ����֣����ȫ�µ�session�ķ���*/
	public static Session openSession(){
		return sessionfactory.openSession();
	}
	/*�ײ����֣���ȡ���̹߳�����session*/
	public static Session getCurrentSession(){
		Session session=threadLocal.get();
		/*�ж��Ƿ�õ�*/
		if(session==null){
			session=sessionfactory.openSession();
			/*��session�������õ�ThreadLocal,�൱��session�Ѿ����̰߳*/
			threadLocal.set(session);
		}
		return session;
	}
}

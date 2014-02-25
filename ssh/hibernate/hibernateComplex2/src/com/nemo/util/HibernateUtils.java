package com.nemo.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

final public class HibernateUtils {
	private static SessionFactory sessionfactory=null; 
	/*使用线程局部模式*/
	private static ThreadLocal<Session> threadLocal=new ThreadLocal<Session>();
	private HibernateUtils(){};
	
	static{
		sessionfactory=new Configuration().configure().buildSessionFactory();
	}
	
	/*底层再现：获得全新的session的方法*/
	public static Session openSession(){
		return sessionfactory.openSession();
	}
	/*底层再现：获取和线程关联的session*/
	public static Session getCurrentSession(){
		Session session=threadLocal.get();
		/*判断是否得到*/
		if(session==null){
			session=sessionfactory.openSession();
			/*把session对象设置到ThreadLocal,相当于session已经和线程邦定*/
			threadLocal.set(session);
		}
		return session;
	}
}

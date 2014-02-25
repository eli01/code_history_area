package com.nemo.utils;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
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
	
	/*�ṩһ��ͳһ�Ĳ�ѯ����*/
	public static List executeQuery(String hql,String[] params){
		Session s=null;
		List list=null;
		Transaction t=null;
		try {
			s=getCurrentSession();
			t=s.beginTransaction();
			Query query=s.createQuery(hql);
			if(params!=null&&params.length>0){
				for(int i=0;i<params.length;i++){
					query.setString(i, params[i]);
				}
			}
			
			list=query.list();
			
		} catch (Exception e) {
			if(t!=null){
				t.rollback();
			}
			throw new RuntimeException(e.getMessage());
		}finally{
			if(s!=null&&s.isOpen()){
				s.close();
			}
		}
		return list;
		
	}
	/*�ṩͳһ�ķ�������ҳ  */
	public static List executeQueryByPage(String hql,String[] params,int pageSize,int pageNow){
		Session s=null;
		List list=null;
		Transaction t=null;
		try {
			s=getCurrentSession();
			t=s.beginTransaction();
			Query query=s.createQuery(hql);
			if(params!=null&&params.length>0){
				for(int i=0;i<params.length;i++){
					query.setString(i, params[i]);
				}
			}
			query.setFirstResult((pageNow-1)*pageSize).setMaxResults(pageSize);
			list=query.list();
			t.commit();
			
		} catch (Exception e) {
			if(t!=null){
				t.rollback();
			}
			throw new RuntimeException(e.getMessage());
		}finally{
			if(s!=null&&s.isOpen()){
				s.close();
			}
		}
		return list;
		
	}
	/*ͳһ����ӵķ���*/
	public static void save(Object obj){
		Session session=null;
		Transaction t=null;
		try {
			session=openSession();
			t=session.beginTransaction();
			session.save(obj);
			t.commit();
		} catch (Exception e) {
			if(t!=null) t.rollback();
			throw new RuntimeException(e.getMessage());
		}finally{
			if(session!=null&&session.isOpen()){
				session.close();
			}
		}
	}
	/*ͬ����޸ĺ�ɾ��������hql��*/
	public static void executeUpdate(String hql,String[] params){
		Session s=null;
		Transaction t=null;
		try {
			s=getCurrentSession();
			t=s.beginTransaction();
			Query query=s.createQuery(hql);
			if(params!=null&&params.length>0){
				for(int i=0;i<params.length;i++){
					query.setString(i, params[i]);
				}
			}
			query.executeUpdate();//�������һ��int
			t.commit();
		} catch (Exception e) {
			if(t!=null){
				t.rollback();
			}
			throw new RuntimeException(e.getMessage());
		}finally{
			if(s!=null&&s.isOpen()){
				s.close();
			}
		}
	}
}

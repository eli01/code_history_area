package com.xiaoli.utils;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

import com.xiaoli.domain.Message;
import com.xiaoli.domain.Users;

final public class HibernateHelper {
	private static SessionFactory sessionfactory=null; 
	/*ʹ���ֲ߳̾�ģʽ*/
	private static ThreadLocal<Session> threadLocal=new ThreadLocal<Session>();
	private HibernateHelper(){};
	
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
	

/*	public static void main(String[] args){
		String hql="from Message where getter.user_id=? or getter.user_id=4";
		String[] params={"2"};
		List<Message> list=HibernateUtils.executeQuery(hql, params);
		System.out.println(list.size());
	}*/
	/*�ṩһ��ͳһ�Ĳ�ѯ����*/
	public static List executeQuery(String hql,String[] params){
		Session s=null;
		s=getCurrentSession();
		Query query=s.createQuery(hql);
		if(params!=null&&params.length>0){
			for(int i=0;i<params.length;i++){
				query.setString(i, params[i]);
			}
		}	
		return query.list();	
	}
	/*ֻ����һ������Ĳ�ѯ����*/
	public static Object uniqueQuery(String hql,String[] params){
		Session s=null;
		s=getCurrentSession();
		Query query=s.createQuery(hql);
		if(params!=null&&params.length>0){
			for(int i=0;i<params.length;i++){
				query.setString(i, params[i]);
			}
		}	
		return query.uniqueResult();	
	}
	
	
	/*дһ���رյ�ǰsession�ķ���*/
	public static void closeCurrentSession(){
		Session s=getCurrentSession();
		if(s!=null&&s.isOpen()){
			s.close();
			threadLocal.set(null);
		}
	}
	/*�ṩͳһ�ķ�������ҳ  */
	public static List executeQueryByPage(String hql,String[] params,int pageSize,int pageNow){
		Session s=getCurrentSession();
		Query query=s.createQuery(hql);
		if(params!=null&&params.length>0){
			for(int i=0;i<params.length;i++){
				query.setString(i, params[i]);
			}
		}
		query.setFirstResult((pageNow-1)*pageSize).setMaxResults(pageSize);
		return query.list();	
	}
	/*ͳһ����ӵķ���*/
	public static void save(Object obj){
		getCurrentSession().save(obj);
	}
	/*ͬ����޸ĺ�ɾ��������hql��*/
	public static void executeUpdate(String hql,String[] params){
		Session s=getCurrentSession();
		Query query=s.createQuery(hql);
		if(params!=null&&params.length>0){
			for(int i=0;i<params.length;i++){
				query.setString(i, params[i]);
			}
		}
		query.executeUpdate();//�������һ��int
	}
	/*ͨ��id��ö���*/
	public static Object findById(Class clazz,java.io.Serializable id){
		Session s=getCurrentSession();
		Transaction t=null;
		return s.load(clazz, id);
	}
}

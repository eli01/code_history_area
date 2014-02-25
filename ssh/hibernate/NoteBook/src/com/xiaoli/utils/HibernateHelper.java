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
	/*使用线程局部模式*/
	private static ThreadLocal<Session> threadLocal=new ThreadLocal<Session>();
	private HibernateHelper(){};
	
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
	

/*	public static void main(String[] args){
		String hql="from Message where getter.user_id=? or getter.user_id=4";
		String[] params={"2"};
		List<Message> list=HibernateUtils.executeQuery(hql, params);
		System.out.println(list.size());
	}*/
	/*提供一个统一的查询方法*/
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
	/*只返回一个对象的查询方法*/
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
	
	
	/*写一个关闭当前session的方法*/
	public static void closeCurrentSession(){
		Session s=getCurrentSession();
		if(s!=null&&s.isOpen()){
			s.close();
			threadLocal.set(null);
		}
	}
	/*提供统一的方法带分页  */
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
	/*统一的添加的方法*/
	public static void save(Object obj){
		getCurrentSession().save(obj);
	}
	/*同意的修改和删除（批量hql）*/
	public static void executeUpdate(String hql,String[] params){
		Session s=getCurrentSession();
		Query query=s.createQuery(hql);
		if(params!=null&&params.length>0){
			for(int i=0;i<params.length;i++){
				query.setString(i, params[i]);
			}
		}
		query.executeUpdate();//结果返回一个int
	}
	/*通过id获得对象*/
	public static Object findById(Class clazz,java.io.Serializable id){
		Session s=getCurrentSession();
		Transaction t=null;
		return s.load(clazz, id);
	}
}

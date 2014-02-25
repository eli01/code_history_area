package com.nemo.service;

import java.util.List;

import javax.servlet.jsp.tagext.TryCatchFinally;

import org.hibernate.Transaction;
import org.hibernate.classic.Session;

import com.nemo.domain.Users;
import com.nemo.util.HibernateUtils;

public class UserService {
	/*验证用户*/
	public Users checkUser(Users user){
		String hql="from Users where name='"+user.getName()+"' and passwd='"+user.getPasswd()+"'";
		List<Users> list=this.executeQuery(hql);
		if(list.size()==1){
			user=list.get(0);
		}else{
			user=null;
		}
		return user;
		
		/*		Session session=null;
		Transaction ts=null;
		try {
			session=HibernateUtils.getCurrentSession();
			ts=session.beginTransaction();
			List<Users> list=session.createQuery("from Users where name='"+user.getName()+"' and passwd='"+user.getPasswd()+"'").list();
			if(list.size()==1){
				user=list.get(0);
			}else{
				user=null;
			}
			ts.commit();
		} catch (Exception e) {
			if(ts!=null){
				ts.rollback();
			}
			throw new RuntimeException(e.getMessage());
		}finally{
			if(session!=null&&session.isOpen()){
				session.close();
			}
		}
		return user;*/
	}
	/*提供一个统一的查询方法*/
	public static List executeQuery(String hql){
		
		Session session=null;
		Transaction ts=null;
		List list=null;
		try {
			session=HibernateUtils.getCurrentSession();
			ts=session.beginTransaction();
			list=session.createQuery(hql).list();
		
			ts.commit();
		} catch (Exception e) {
			if(ts!=null){
				ts.rollback();
			}
			throw new RuntimeException(e.getMessage());
		}finally{
			if(session!=null&&session.isOpen()){
				session.close();
			}
		}
		return list;
	}
	
}

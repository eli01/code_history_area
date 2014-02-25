package com.xiaoli.test;

import org.hibernate.Transaction;
import org.hibernate.classic.Session;

import com.xiaoli.utils.HibernateUtils;

public class BuildDB {
	public static void main(String[] args){
		Session session=null;
		Transaction t=null;
		try {
			session=HibernateUtils.openSession();
			t=session.beginTransaction();
			t.commit();
		} catch (Exception e) {
			if(t!=null) t.rollback();
		}finally{
			if(session!=null&&session.isOpen()){
				session.close();
			}
		}
	}
}

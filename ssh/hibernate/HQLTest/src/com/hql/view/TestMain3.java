package com.hql.view;

import java.math.BigDecimal;

import org.hibernate.Transaction;
import org.hibernate.classic.Session;

import com.nemo.domain.Course;
import com.nemo.utils.HibernateUtils;

public class TestMain3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*1.对象被创建*/
		Course course=new Course();//瞬时态
		course.setCid(new BigDecimal("211"));
		course.setCname("php");
		course.setCcredit(new Short("34"));
		
		Session session=null;
		Transaction t=null;
		try {
			session=HibernateUtils.getCurrentSession();
			t=session.beginTransaction();
			/*2.持久化*/
			session.save(course);//持久态
			/*3.脱管状态*/
			t.commit();//提交事务后
		} catch (Exception e) {
			if(t!=null) t.rollback();
		}finally{
			if(session!=null&&session.isOpen()){
				session.close();
			}
		}
	}

}

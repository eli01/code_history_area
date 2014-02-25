package com.nemo.views;

import java.util.Date;

import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

import com.nemo.domin.Employee;
import com.nemo.utils.HibernateUtils;

public class TestMain {
	public static void main(String[] args){
		/*添加一条记录*/
		Session session=HibernateUtils.getCurrentSession();
		Transaction ta=session.beginTransaction();	
		try {
			//添加一个雇员
			Employee emp=new Employee();
			
			emp.setName("小");
			emp.setEmail("899067613@qq.com");
			
			emp.setHiredate(new Date());
			
			session.save(emp);//insert into........[被hibernate包装]
			ta.commit();//如果在提交事务前发生异常回滚	
			System.out.println("111");
		} catch (Exception e) {
			if(ta!=null) ta.rollback();
			throw new RuntimeException(e.getMessage());
		}finally{
			if(session!=null&&session.isOpen()){
				session.close();
			}
		}
	}
	
}

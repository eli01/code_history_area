package com.nemo.views;

import java.util.Date;

import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

import com.nemo.domin.Employee;
import com.nemo.utils.HibernateUtils;

public class TestMain {
	public static void main(String[] args){
		/*���һ����¼*/
		Session session=HibernateUtils.getCurrentSession();
		Transaction ta=session.beginTransaction();	
		try {
			//���һ����Ա
			Employee emp=new Employee();
			
			emp.setName("С");
			emp.setEmail("899067613@qq.com");
			
			emp.setHiredate(new Date());
			
			session.save(emp);//insert into........[��hibernate��װ]
			ta.commit();//������ύ����ǰ�����쳣�ع�	
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

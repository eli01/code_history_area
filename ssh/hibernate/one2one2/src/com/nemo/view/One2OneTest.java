package com.nemo.view;

import java.util.Date;

import org.hibernate.Transaction;
import org.hibernate.classic.Session;

import com.nemo.domain.IDCard;
import com.nemo.domain.Person;
import com.nemo.utils.HibernateUtils;

public class One2OneTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Session s=null;
		Transaction t=null;
		try {
			s=HibernateUtils.getCurrentSession();
			t=s.beginTransaction();
			
			/*创建一个Person对象*/
			Person person=new Person();
			person.setId(1236);
			person.setName("深水鱼");
			
			/*创建一个IDCard对象*/
			
			IDCard idcard=new IDCard();
			idcard.setId(19001200);
			idcard.setValidDate(new Date());
			
			/*一对一绑定*/
		/*	person.setIdCard(idcard);
			
			s.save(idcard);
			s.save(person);*/
			
			idcard.setPerson(person);
			s.save(person);
			s.save(idcard);
			t.commit();
		} catch (Exception e) {
			if(t!=null) t.rollback();
			throw new RuntimeException(e.getMessage());
		}finally{
			if(s!=null&&s.isOpen()){
				s.close();
			}
		}
	}

}

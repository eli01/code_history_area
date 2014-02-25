package com.nemo.view;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Order;

import com.nemo.domain.Employee;
import com.nemo.utils.HibernateUtils;
import com.nemo.utils.MySessionFactory;

public class HibernateTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
	
		/*Session s1=HibernateUtils.getCurrentSession();
		Session s2=HibernateUtils.getCurrentSession();
		System.out.println(s1.hashCode()+" "+s2.hashCode());*/
		
		/*����openSession()��getCurrentSession()������*/
		/*
		Session s1=MySessionFactory.getSessionFactory().openSession();
		Session s2=MySessionFactory.getSessionFactory().openSession();
		System.out.println(s1.hashCode()+"||"+s2.hashCode());
		Session s3=MySessionFactory.getSessionFactory().getCurrentSession();
		Session s4=MySessionFactory.getSessionFactory().getCurrentSession();
		System.out.println(s3.hashCode()+"&&"+s4.hashCode());*/
		//��ѯ
		/*Session session=MySessionFactory.getSessionFactory().getCurrentSession();
		Transaction t=session.beginTransaction();
		Employee e=(Employee) session.load(Employee.class, 1);
		System.out.println(e.getName());
		t.commit();
		if(session!=null&&session.isOpen()){
			session.close();
		}*/
		criteriaEmp();
		
	}
	public static void criteriaEmp(){
		Session session=HibernateUtils.getCurrentSession();
		Transaction ta=null;
		try {
			ta=session.beginTransaction();	
			Criteria c=session.createCriteria(Employee.class).setMaxResults(2).addOrder(Order.asc("id"));
			List<Employee> list=c.list();
			
			for(Employee emp:list){
				System.out.println(emp.getName()+""+emp.getEmail());
			}
			ta.commit();
			
		} catch (Exception e) {
			if(ta!=null) ta.rollback();
			throw new RuntimeException(e.getMessage());
		}finally{
			if(session!=null&&session.isOpen()){
				session.close();
			}
		}
	
	}
	public static void queryEmp(){
	
		Session session=HibernateUtils.getCurrentSession();
		Transaction ta=null;
		try {
			ta=session.beginTransaction();	
			//��ȡquery���á�����Employee���Ǳ�����domain������
			//Employee e=(Employee) session.load(Employee.class, 1);
			Query query=session.createQuery("from Employee where id=1");
			/*ͨ��list��������ȡ��������������Զ������װ�ɶ�Ӧ��domin����
			 * ��������ԭ�����η�װ�Ĺ�����û����*/
			List<Employee> list=query.list();
			for(Employee emp:list){
				System.out.println(emp.getName()+""+emp.getEmail());
			}
			ta.commit();
			
		} catch (Exception e) {
			if(ta!=null) ta.rollback();
			throw new RuntimeException(e.getMessage());
		}finally{
			if(session!=null&&session.isOpen()){
				session.close();
			}
		}
	}

	public static void deleteEmp() {
		/*ɾ��*/
		Session session=MySessionFactory.getSessionFactory().openSession();
		Transaction ta=session.beginTransaction();
		Employee emp=(Employee)session.load(Employee.class, 1);
		session.delete(emp);
		ta.commit();
	}

	public static void updateEmp() {
		/*�޸��û�*/
		/*1.��ȡһ���Ự*/
		Session session=MySessionFactory.getSessionFactory().openSession();
		Transaction ta=session.beginTransaction();	
		try {
			/*2.��ȡҪ�޸ĵ��û�*/
			Employee emp=(Employee)session.load(Employee.class, 1);//ͨ�������Ի�ȡ����ʵ����--->��ļ�¼��Ӧselect...... 
			emp.setEmail("929020238@out.com");//�޸�������¼ update......
			session.save(emp);
			ta.commit();//������ύ����ǰ�����쳣�ع�	
		} catch (Exception e) {
			if(ta!=null) ta.rollback();
			throw new RuntimeException(e.getMessage());
		}finally{
			if(session!=null&&session.isOpen()){
				session.close();
			}
		}
	}

	public static void addEmployee() {
/*		ʹ��hibernate���crud������ֻ�����󲻼���
		1.����configration,�ö������ڶ�ȡhibernate.cfg.xml����ɳ�ʼ��
		Configuration cfg=new Configuration().configure(); 
		2.���� SessionFactory(����һ���滭��������һ������������ )
		SessionFactory sf=cfg.buildSessionFactory();
		3.����session �൱��jdbc Connection[servlet HttpSession,Ҳ����jsp session]
		Session session=sf.openSession();
		4.��hibernate��˵����ɾ��Ҫ���������ύ
		Transaction transaction=session.beginTransaction();//��ʼ����
		���һ����Ա
		Employee emp=new Employee();
		emp.setName("С��");
		emp.setEmail("599067613@qq.com");
		emp.setHiredate(new Date());
		�־û�
		session.save(emp);//insert into........[��hibernate��װ]
		transaction.commit();//�ύ����
		session.close();
		*/
		/*�޸��û�*/
		/*1.��ȡһ���Ự*/
		Session session=MySessionFactory.getSessionFactory().openSession();
		Transaction ta=session.beginTransaction();	
		try {
			//���һ����Ա
			Employee emp=new Employee();
			emp.setId(100);
			emp.setName("С��");
			emp.setEmail("599067613@qq.com");
			emp.setHiredate(new Date());
			session.save(emp);//insert into........[��hibernate��װ]
			ta.commit();//������ύ����ǰ�����쳣�ع�	
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

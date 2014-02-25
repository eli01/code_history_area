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
		
		/*测试openSession()和getCurrentSession()的区别*/
		/*
		Session s1=MySessionFactory.getSessionFactory().openSession();
		Session s2=MySessionFactory.getSessionFactory().openSession();
		System.out.println(s1.hashCode()+"||"+s2.hashCode());
		Session s3=MySessionFactory.getSessionFactory().getCurrentSession();
		Session s4=MySessionFactory.getSessionFactory().getCurrentSession();
		System.out.println(s3.hashCode()+"&&"+s4.hashCode());*/
		//查询
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
			//获取query引用【这里Employee不是表，而是domain类名】
			//Employee e=(Employee) session.load(Employee.class, 1);
			Query query=session.createQuery("from Employee where id=1");
			/*通过list方法，获取结果，这个结果会自动将其封装成对应的domin对象
			 * 所以我们原来二次封装的工作就没有了*/
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
		/*删除*/
		Session session=MySessionFactory.getSessionFactory().openSession();
		Transaction ta=session.beginTransaction();
		Employee emp=(Employee)session.load(Employee.class, 1);
		session.delete(emp);
		ta.commit();
	}

	public static void updateEmp() {
		/*修改用户*/
		/*1.获取一个会话*/
		Session session=MySessionFactory.getSessionFactory().openSession();
		Transaction ta=session.beginTransaction();	
		try {
			/*2.获取要修改的用户*/
			Employee emp=(Employee)session.load(Employee.class, 1);//通过逐渐属性获取对象实例〈--->表的记录对应select...... 
			emp.setEmail("929020238@out.com");//修改这条记录 update......
			session.save(emp);
			ta.commit();//如果在提交事务前发生异常回滚	
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
/*		使用hibernate完成crud操作（只见对象不见表）
		1.创建configration,该对象用于读取hibernate.cfg.xml并完成初始化
		Configuration cfg=new Configuration().configure(); 
		2.创建 SessionFactory(这是一个绘画工厂，是一个重量级的类 )
		SessionFactory sf=cfg.buildSessionFactory();
		3.创建session 相当于jdbc Connection[servlet HttpSession,也不是jsp session]
		Session session=sf.openSession();
		4.对hibernate来说，增删改要求用事务提交
		Transaction transaction=session.beginTransaction();//开始事务
		添加一个雇员
		Employee emp=new Employee();
		emp.setName("小丽");
		emp.setEmail("599067613@qq.com");
		emp.setHiredate(new Date());
		持久化
		session.save(emp);//insert into........[被hibernate包装]
		transaction.commit();//提交事务
		session.close();
		*/
		/*修改用户*/
		/*1.获取一个会话*/
		Session session=MySessionFactory.getSessionFactory().openSession();
		Transaction ta=session.beginTransaction();	
		try {
			//添加一个雇员
			Employee emp=new Employee();
			emp.setId(100);
			emp.setName("小丽");
			emp.setEmail("599067613@qq.com");
			emp.setHiredate(new Date());
			session.save(emp);//insert into........[被hibernate包装]
			ta.commit();//如果在提交事务前发生异常回滚	
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

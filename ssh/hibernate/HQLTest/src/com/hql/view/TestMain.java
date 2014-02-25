package com.hql.view;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;

import com.nemo.domain.Studcourse;
import com.nemo.domain.Student;
import com.nemo.utils.HibernateUtils;

public class TestMain {

	public static void main(String[] args) {
		//这我们举例说明hql使用
				Session session=null;
				Transaction tx=null;
				try {
					session=HibernateUtils.getCurrentSession();
					tx=session.beginTransaction();
					//比如，显示所有学生的性别和年龄.
					Query query=session.createQuery("from Student where sdept=? and sage>?");
					
					query.setString(0, "计算机系");
					query.setString(1, "2");
					List <Student> list=query.list();
					for(int i=0;i<list.size();i++){
						Student s= list.get(i);
						System.out.println(s.getSname()+" "+s.getSage());
					}
					
					//计算年龄在20~22之间的学生
					
				/*	List list=session.createQuery("select distinct sage,ssex,sname from Student where sage between 20 and 22").list();
					for(int i=0;i<list.size();i++){
						Object []  objs=(Object[]) list.get(i);
						System.out.println(objs[0].toString()+" "+objs[1].toString()+objs[2].toString());
					}*/
					
					//查询计算机系和外语系的学生信息
					
					/*List<Student> list=session.createQuery("from Student where sdept not in ('计算机系','外语系')").list();
					//取出1. for 增强
					for(Student s:list){
						System.out.println(s.getSname()+" "+s.getSaddress()+" "+s.getSdept());
					}
					*/
					//显示各个系的学生的平均年龄
				/*	List<Object[]> list=session.createQuery("select avg(sage),sdept from  Student group by sdept").list();
					//取出1. for 增强
					for(Object[] obj:list){
						System.out.println(obj[0].toString()+" "+obj[1].toString());
					}*/
					
					//having的使用
					//1.对分组查询后的结果，进行筛选:比如请显示人数大于3的系名称
					//a. 查询各个系分别有多少学生.
					
			/*		List<Object[]> list=session.createQuery("select count(*) as c1,sdept from  Student group by sdept having count(*)>3").list();
					//取出1. for 增强
					for(Object[] obj:list){
						System.out.println(obj[0].toString()+" "+obj[1].toString());
					}*/
					
					//2查询女生少于200人的系
					//a.查询各个系的女生有多个个
				/*	List<Object[]> list=session.
					createQuery("select count(*) as c1,sdept from  Student where ssex='F' group by sdept").list();
					//取出1. for 增强
					for(Object[] obj:list){
						System.out.println(obj[0].toString()+" "+obj[1].toString());
					}*/
					
					//		1.查询计算机系共多少人?->如果我们返回的是一列数据
					//这时我们的取法是直接取出list->object 而不是 list->Object[]
			/*		List<Object[]> list=session.
					createQuery("select sage from  Student where sdept='计算机系'").list();
					//取出1. for 增强
					for(Object obj:list){
						System.out.println(obj.toString());
					}*/
//							2.查询总学分是多少?
		/*			List<Object[]> list=session.
					createQuery("select sum(grade) from Studcourse").list();
					//取出1. for 增强
					for(Object obj:list){
						System.out.println(obj.toString());
					}*/
//							3.查询选修11号课程的最高分和最低分.
		/*			List<Object[]> list=session.
					createQuery("select 11,max(grade),min(grade) from Studcourse where course.cid=11").list();
					//取出1. for 增强
					for(Object[] obj:list){
						System.out.println(obj[0].toString()+" max="+obj[1].toString()+" min="+obj[2].toString());
					}*/
					//4.显示各科考试不及格学生的名字(Student-student)，科目(Course-course)和分数(Studcourse-studcourse)
					
				/*	List<Object[]> list=session.
					createQuery("select student.sname,course.cname,grade from Studcourse where grade>=60").list();
					//取出1. for 增强
					for(Object[] obj:list){
						System.out.println(obj[0].toString()+" "+obj[1].toString()+" "+obj[2].toString());
					}*/
					
					//计算各个科目不及格的学生数量.(学生练习!)
					
					/*List<Object[]> list=session.
					createQuery("select count(*),student.sdept from Studcourse where grade<60 group by student.sdept").list();
					//取出1. for 增强
					for(Object[] obj:list){
						System.out.println(obj[0].toString()+" "+obj[1].toString());
					}*/
					
					//请按照学生的年龄从小->大，取出第3到第5个学生
				/*	List<Student> list=session.createQuery
					("from Student  order by sage").setFirstResult(2)
					.setMaxResults(3).list();
					for(Student s: list){
						System.out.println(s.getSname()+" "+s.getSage());
					}*/
					
					
					
					tx.commit();
					
					
				} catch (Exception e) {
					e.printStackTrace();
					if(tx!=null){
						tx.rollback();
					}
					throw new RuntimeException(e.getMessage());
					// TODO: handle exception
				}finally{
					if(session!=null&&session.isOpen()){
						session.close();
					}
					
				}
	}
	
	
	public static void queryAll() {
		/*检索全部属性*/
		//queryAll();
		/*部分属性检索*/
		Session session=null;
		Transaction t=null;
		try {
			session=HibernateUtils.getCurrentSession();
			t=session.beginTransaction();
			/*1.检索所有学生信息*/
			/*多条记录*/
			List<Student> list=session.createQuery("from Student").list();
			/*一条记录*/
			Student s1=(Student)session.createQuery("from Student where sid='20050003'").uniqueResult();
			System.out.println("单独查询一条："+s1.getSname());
			/*取出
			 * 方法一：for循环增强*/
			for(Student s:list){
				/*
				System.out.println("选择的课程数："+s.getStudcourses().size());
				System.out.println(s.getSname()+"||"+s.getSaddress());*/
				if(s.getStudcourses().size()==0){
					System.out.println(s.getSname()+":没有选择课");
				}else{
					Set<Studcourse> set=s.getStudcourses();
					for(Studcourse sc:set){
						System.out.println(s.getSname()+"选了"+sc.getCourse().getCname());
					}
					
				}
			}
			 /* 方法二：迭代器iterator*/
			Iterator<Student> iterator=list.iterator();
			while(iterator.hasNext()){
				Student s=iterator.next();
				System.out.println(s.getSaddress()+" "+s.getSname());
			}
			t.commit();
		} catch (Exception e) {
			if(t!=null){
				t.rollback();
				throw new RuntimeException(e.getMessage());
			}
		}finally{
			if(session!=null&&session.isOpen()){
				session.close();
			}
		}
	}

	public static void queryPart() {
		/*这里我们举例说明hql的使用*/
		Session session=null;
		Transaction t=null;
		try {
			session=HibernateUtils.getCurrentSession();
			t=session.beginTransaction();
			/*检索学生姓名和所在系
			 * 1.原则：要查询什么字段就查询什么字段，不要select * from......
			 * 但是在hibernate,我们其实可以不遵循这个原则，建议把对象的所有属性都查出来 
			 * 这里我们还是讲一讲如何取出部分属性*/
			List list=session.createQuery("select sname,sdept from student").list();
			/*方法1：普通for循环*/
			for(int i=0;i<list.size();i++){
				Object[] obj=(Object[])list.get(i);
				System.out.println(obj[0].toString()+" "+obj[1].toString());
			}
			/*方法2.Iterator*/
			Iterator iterator=list.iterator();
			while(iterator.hasNext()){
				Object[] objs=(Object[])iterator.next();
				System.out.println(objs[0].toString()+"&&"+objs[1].toString());
			}
			t.commit();
		} catch (Exception e) {
			if(t!=null){
				t.rollback();
				throw new RuntimeException(e.getMessage());
			}
		}finally{
			if(session!=null&&session.isOpen()){
				session.close();
			}
		}
	}

}

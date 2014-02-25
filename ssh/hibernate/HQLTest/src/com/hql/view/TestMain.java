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
		//�����Ǿ���˵��hqlʹ��
				Session session=null;
				Transaction tx=null;
				try {
					session=HibernateUtils.getCurrentSession();
					tx=session.beginTransaction();
					//���磬��ʾ����ѧ�����Ա������.
					Query query=session.createQuery("from Student where sdept=? and sage>?");
					
					query.setString(0, "�����ϵ");
					query.setString(1, "2");
					List <Student> list=query.list();
					for(int i=0;i<list.size();i++){
						Student s= list.get(i);
						System.out.println(s.getSname()+" "+s.getSage());
					}
					
					//����������20~22֮���ѧ��
					
				/*	List list=session.createQuery("select distinct sage,ssex,sname from Student where sage between 20 and 22").list();
					for(int i=0;i<list.size();i++){
						Object []  objs=(Object[]) list.get(i);
						System.out.println(objs[0].toString()+" "+objs[1].toString()+objs[2].toString());
					}*/
					
					//��ѯ�����ϵ������ϵ��ѧ����Ϣ
					
					/*List<Student> list=session.createQuery("from Student where sdept not in ('�����ϵ','����ϵ')").list();
					//ȡ��1. for ��ǿ
					for(Student s:list){
						System.out.println(s.getSname()+" "+s.getSaddress()+" "+s.getSdept());
					}
					*/
					//��ʾ����ϵ��ѧ����ƽ������
				/*	List<Object[]> list=session.createQuery("select avg(sage),sdept from  Student group by sdept").list();
					//ȡ��1. for ��ǿ
					for(Object[] obj:list){
						System.out.println(obj[0].toString()+" "+obj[1].toString());
					}*/
					
					//having��ʹ��
					//1.�Է����ѯ��Ľ��������ɸѡ:��������ʾ��������3��ϵ����
					//a. ��ѯ����ϵ�ֱ��ж���ѧ��.
					
			/*		List<Object[]> list=session.createQuery("select count(*) as c1,sdept from  Student group by sdept having count(*)>3").list();
					//ȡ��1. for ��ǿ
					for(Object[] obj:list){
						System.out.println(obj[0].toString()+" "+obj[1].toString());
					}*/
					
					//2��ѯŮ������200�˵�ϵ
					//a.��ѯ����ϵ��Ů���ж����
				/*	List<Object[]> list=session.
					createQuery("select count(*) as c1,sdept from  Student where ssex='F' group by sdept").list();
					//ȡ��1. for ��ǿ
					for(Object[] obj:list){
						System.out.println(obj[0].toString()+" "+obj[1].toString());
					}*/
					
					//		1.��ѯ�����ϵ��������?->������Ƿ��ص���һ������
					//��ʱ���ǵ�ȡ����ֱ��ȡ��list->object ������ list->Object[]
			/*		List<Object[]> list=session.
					createQuery("select sage from  Student where sdept='�����ϵ'").list();
					//ȡ��1. for ��ǿ
					for(Object obj:list){
						System.out.println(obj.toString());
					}*/
//							2.��ѯ��ѧ���Ƕ���?
		/*			List<Object[]> list=session.
					createQuery("select sum(grade) from Studcourse").list();
					//ȡ��1. for ��ǿ
					for(Object obj:list){
						System.out.println(obj.toString());
					}*/
//							3.��ѯѡ��11�ſγ̵���߷ֺ���ͷ�.
		/*			List<Object[]> list=session.
					createQuery("select 11,max(grade),min(grade) from Studcourse where course.cid=11").list();
					//ȡ��1. for ��ǿ
					for(Object[] obj:list){
						System.out.println(obj[0].toString()+" max="+obj[1].toString()+" min="+obj[2].toString());
					}*/
					//4.��ʾ���ƿ��Բ�����ѧ��������(Student-student)����Ŀ(Course-course)�ͷ���(Studcourse-studcourse)
					
				/*	List<Object[]> list=session.
					createQuery("select student.sname,course.cname,grade from Studcourse where grade>=60").list();
					//ȡ��1. for ��ǿ
					for(Object[] obj:list){
						System.out.println(obj[0].toString()+" "+obj[1].toString()+" "+obj[2].toString());
					}*/
					
					//���������Ŀ�������ѧ������.(ѧ����ϰ!)
					
					/*List<Object[]> list=session.
					createQuery("select count(*),student.sdept from Studcourse where grade<60 group by student.sdept").list();
					//ȡ��1. for ��ǿ
					for(Object[] obj:list){
						System.out.println(obj[0].toString()+" "+obj[1].toString());
					}*/
					
					//�밴��ѧ���������С->��ȡ����3����5��ѧ��
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
		/*����ȫ������*/
		//queryAll();
		/*�������Լ���*/
		Session session=null;
		Transaction t=null;
		try {
			session=HibernateUtils.getCurrentSession();
			t=session.beginTransaction();
			/*1.��������ѧ����Ϣ*/
			/*������¼*/
			List<Student> list=session.createQuery("from Student").list();
			/*һ����¼*/
			Student s1=(Student)session.createQuery("from Student where sid='20050003'").uniqueResult();
			System.out.println("������ѯһ����"+s1.getSname());
			/*ȡ��
			 * ����һ��forѭ����ǿ*/
			for(Student s:list){
				/*
				System.out.println("ѡ��Ŀγ�����"+s.getStudcourses().size());
				System.out.println(s.getSname()+"||"+s.getSaddress());*/
				if(s.getStudcourses().size()==0){
					System.out.println(s.getSname()+":û��ѡ���");
				}else{
					Set<Studcourse> set=s.getStudcourses();
					for(Studcourse sc:set){
						System.out.println(s.getSname()+"ѡ��"+sc.getCourse().getCname());
					}
					
				}
			}
			 /* ��������������iterator*/
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
		/*�������Ǿ���˵��hql��ʹ��*/
		Session session=null;
		Transaction t=null;
		try {
			session=HibernateUtils.getCurrentSession();
			t=session.beginTransaction();
			/*����ѧ������������ϵ
			 * 1.ԭ��Ҫ��ѯʲô�ֶξͲ�ѯʲô�ֶΣ���Ҫselect * from......
			 * ������hibernate,������ʵ���Բ���ѭ���ԭ�򣬽���Ѷ�����������Զ������ 
			 * �������ǻ��ǽ�һ�����ȡ����������*/
			List list=session.createQuery("select sname,sdept from student").list();
			/*����1����ͨforѭ��*/
			for(int i=0;i<list.size();i++){
				Object[] obj=(Object[])list.get(i);
				System.out.println(obj[0].toString()+" "+obj[1].toString());
			}
			/*����2.Iterator*/
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

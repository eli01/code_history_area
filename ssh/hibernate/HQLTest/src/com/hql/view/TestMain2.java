package com.hql.view;

import java.math.BigDecimal;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Restrictions;

import com.nemo.domain.Course;
import com.nemo.domain.Studcourse;
import com.nemo.domain.Student;
import com.nemo.utils.HibernateUtils;

public class TestMain2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*����ʹ����ǿ��HibernateUtils*/
		/*String hql="from Student where sdept=? and sage>?";
		String[] params={"�����ϵ","10"};
		List<Student> list=HibernateUtils.executeQuery(hql, null);
		for(Student s:list){
			System.out.println(s.getSname());
		}*/
		
		/*ʹ�ù��߷�ҳ*/
		/*String hql="select sname,saddress from Student order by sage";
		String[] params=null;
		List<Object[]> list=HibernateUtils.executeQueryByPage(hql, params, 3, 2);
		for(Object[] s:list){
			System.out.println(s[0]);
		}*/
		
		/*���*/
		/*Course c=new Course();
		c.setCid(new BigDecimal("100"));
		c.setCname("velocity");
		HibernateUtils.save(c);*/
		
		/*�����޸�/ɾ��*/
	/*	String hql="update Student set sage=sage+1 where sdept=?";
		String parameters[]={"�����ϵ"};
		try {
			HibernateUtil.executeUpdate(hql, parameters);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			// TODO: handle exception
		}*/
		
		/*����ʵ����ѡ��21�ſγ̵�ѧ����Ϣ*/
		/*����һ*/
	/*	String hql="select student.sname,student.sdept from Studcourse where course.cid=?";
		String[] params={"21"};
		List<Object[]> list=HibernateUtils.executeQuery(hql, params);
		for(Object[] s:list){
			System.out.println(s[0]+" "+s[1]);
		}*/
		
		/*������ �漰�������� ��Ҫ��ӳ���ļ��н���������*/
		/*String hql2="from Studcourse where course.cid=21";
		List<Studcourse> list2=HibernateUtils.executeQuery(hql2, null);
		for(Studcourse sc:list2){
			System.out.println(sc.getStudent().getSname());
		}*/
	
		/*ʹ��Criteria��ѯ�������ʮ���ѧ����Ϣ*/
	/*	Session s=HibernateUtils.getCurrentSession();
		Transaction t=s.beginTransaction();
		Criteria c=s.createCriteria(Student.class);
		//��Ӽ�������
		c.add(Restrictions.gt("sage", new Short("1")));
		List<Student> list=c.list();
		for(Student stu:list){
			System.out.println(stu.getSname());
		}
		
		t.commit();*/
		HibernateUtils.openSession();//��仰���������ļ����ļ���
	}

}

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
		/*我们使用增强的HibernateUtils*/
		/*String hql="from Student where sdept=? and sage>?";
		String[] params={"计算机系","10"};
		List<Student> list=HibernateUtils.executeQuery(hql, null);
		for(Student s:list){
			System.out.println(s.getSname());
		}*/
		
		/*使用工具分页*/
		/*String hql="select sname,saddress from Student order by sage";
		String[] params=null;
		List<Object[]> list=HibernateUtils.executeQueryByPage(hql, params, 3, 2);
		for(Object[] s:list){
			System.out.println(s[0]);
		}*/
		
		/*添加*/
		/*Course c=new Course();
		c.setCid(new BigDecimal("100"));
		c.setCname("velocity");
		HibernateUtils.save(c);*/
		
		/*调用修改/删除*/
	/*	String hql="update Student set sage=sage+1 where sdept=?";
		String parameters[]={"计算机系"};
		try {
			HibernateUtil.executeUpdate(hql, parameters);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			// TODO: handle exception
		}*/
		
		/*清现实所有选择21号课程的学生信息*/
		/*方法一*/
	/*	String hql="select student.sname,student.sdept from Studcourse where course.cid=?";
		String[] params={"21"};
		List<Object[]> list=HibernateUtils.executeQuery(hql, params);
		for(Object[] s:list){
			System.out.println(s[0]+" "+s[1]);
		}*/
		
		/*方法二 涉及到懒加载 需要在映射文件中禁用懒加载*/
		/*String hql2="from Studcourse where course.cid=21";
		List<Studcourse> list2=HibernateUtils.executeQuery(hql2, null);
		for(Studcourse sc:list2){
			System.out.println(sc.getStudent().getSname());
		}*/
	
		/*使用Criteria查询年龄大于十岁的学生信息*/
	/*	Session s=HibernateUtils.getCurrentSession();
		Transaction t=s.beginTransaction();
		Criteria c=s.createCriteria(Student.class);
		//添加检索条件
		c.add(Restrictions.gt("sage", new Short("1")));
		List<Student> list=c.list();
		for(Student stu:list){
			System.out.println(stu.getSname());
		}
		
		t.commit();*/
		HibernateUtils.openSession();//这句话导致配置文件爱的加载
	}

}

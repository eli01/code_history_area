package com.nemo.view;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Hibernate;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;

import com.nemo.domain.Department;
import com.nemo.domain.Employee2;
import com.nemo.utils.HibernateUtils;

public class OneToManyTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/*演示级联添加*/
		//save_updateCascade();
		
		/*演示级联删除*/
		Session s=null;
		Transaction t=null;
		try {
			s=HibernateUtils.getCurrentSession();
			t=s.beginTransaction();
			Department dept=(Department)s.get(Department.class, 3); 
			s.delete(dept);
			t.commit();
		} catch (Exception e) {
			if(t!=null) t.rollback();
			throw new RuntimeException(e.getMessage());
			// TODO: handle exception
		}finally{
			if(s!=null&&s.isOpen()){
				s.close();
			}
		}
		
	}
	public static void save_updateCascade() {
		// TODO Auto-generated method stub
		/*通过或的一个session,加在配置信心，完成表的创建*/
		/*HibernateUtils.openSession();*/
		//manyToOneAdd();
		/*通过初始化代理对象解决懒加载*/
	/*	Employee2 emp2=getEmp2();
		Department d=emp2.getDept();//此时session已经关闭！
		System.out.println(d.getName());*/
		
		/*查询所有1号部门的学生
		 * 方法1：from Employee2 where dept.id=1
		 * 方法2：利用one-to-many映射关系（见项目onetomany）*/
		Session s=null;
		Transaction t=null;
		try {
			s=HibernateUtils.getCurrentSession();
			t=s.beginTransaction();
			
			/*方法一*/
		/*	Employee2 e=new Employee2();
			String hql="from Employee2 where dept.id=1";
			List<Employee2> list=s.createQuery(hql).list();
			for(Employee2 emp2:list){
				System.out.println(emp2.getName());
			}*/
			
			/*方法二*/
			/*Department d=(Department)s.get(Department.class, 1);
			取出该部门的雇员
			Set<Employee2> emps=d.getEmps();
			for(Employee2 emp:emps){
				System.out.println(emp.getName());
			} */
			
			
			/*添加雇员*/
			Department d=new Department();
			d.setName("怪兽部");
			
			Employee2 emp1=new Employee2();
			emp1.setName("大眼仔");
			
			Employee2 emp2=new Employee2();
			emp2.setName("长毛怪");
			
			Employee2 emp3=new Employee2();
			emp3.setName("眼镜蛇");
			
			Set<Employee2> set=new HashSet<Employee2>();
			set.add(emp1);
			set.add(emp2);
			set.add(emp3);
			
			d.setEmps(set);
			/*保存学生
			 *在映射文件中设置级联后就不需要保存学生了，保存部门是发现雇员没保存会自动保存雇员（级联）*/
		/*	s.save(emp1);
			s.save(emp2);
			s.save(emp3);*/
			/*保存部门*/
			s.save(d);

			t.commit();
		} catch (Exception e) {
			if(t!=null) t.rollback();
			throw new RuntimeException(e.getMessage());
			// TODO: handle exception
		}finally{
			if(s!=null&&s.isOpen()){
				s.close();
			}
		}
	}
	/*解决懒加载session关闭的问题
	 * 方法一：显示初始化代理对象
	 * 方法二：在Employee2.hbm.xml中设置class lazy="false"*/
	public static Employee2 getEmp2() {
		Session s=null;
		Transaction t=null;
		Employee2 e2=null;
		try {
			s=HibernateUtils.getCurrentSession();
			t=s.beginTransaction();
			//取出小美所在部门名称
			e2=(Employee2)s.get(Employee2.class,1);/*查询一号雇员*/
			/*方法一：显示初始化代理对象*/
			Hibernate.initialize(e2.getDept());
			t.commit();
		} catch (Exception e) {
			if(t!=null) t.rollback();
			throw new RuntimeException(e.getMessage());
			// TODO: handle exception
		}finally{
			if(s!=null&&s.isOpen()){
				s.close();
			}
		}
		return e2;
	}
	/*多对一添加*/
	public static void manyToOneAdd() {
		Session s=null;
		Transaction t=null;
		try {
			s=HibernateUtils.getCurrentSession();
			t=s.beginTransaction();
			Employee2 e=new Employee2();
			e.setName("小帅");
			
			Department d=new Department();
			d.setName("IT部");
			e.setDept(d);
			
			s.save(d);
			s.save(e);
			t.commit();
		} catch (Exception e) {
			if(t!=null) t.rollback();
			throw new RuntimeException(e.getMessage());
			// TODO: handle exception
		}finally{
			if(s!=null&&s.isOpen()){
				s.close();
			}
		}
	}

}

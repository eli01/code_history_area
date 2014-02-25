package com.nemo.test;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nemo.domain.Department;
import com.nemo.domain.Employee;
import com.nemo.service.imp.EmployeeService;
import com.nemo.service.interfaces.DepartmentServiceInterface;
import com.nemo.service.interfaces.EmployeeServiceInterface;

public class TestMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*配置完spring后*/
	/*	ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
		SessionFactory sf=(SessionFactory)ac.getBean("sessionFactory");
		Session session=sf.openSession();
		Employee emp=new Employee("aa","aa","truman",10,new java.util.Date(),56f);
		Transaction t=session.beginTransaction();
		session.save(emp);
		t.commit();*/
		/*配置完hibernate后*/
		ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
	/*	Employee emp1=new Employee("john","aa@aa","truman",1,new java.util.Date(),5600f);
		Employee emp2=new Employee("大黄","aa@aa","truman",1,new java.util.Date(),5600f);*/
		Department department=new Department("财务部");
	/*	Set<Employee> set=new HashSet<Employee>();
		set.add(emp1);
		set.add(emp2);
		department.setEmps(set);*/
		// EmployeeServiceInterface es=(EmployeeServiceInterface)ac.getBean("employeeService");
		DepartmentServiceInterface dsi=(DepartmentServiceInterface)ac.getBean("departmentService");
		/*es.addEmployee(emp1);
		es.addEmployee(emp2);*/
		dsi.addDepartment(department);
		 
		/*配置完二级缓存*/
		/*ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
		SessionFactory sf=(SessionFactory)ac.getBean("sessionFactory");
		Session session=sf.openSession();
		//EmployeeServiceInterface es=(EmployeeServiceInterface)ac.getBean("employeeService");
		//es.showEmployee();
		Employee emp2=(Employee)session.load(Employee.class, 23);
		System.out.println(emp2.getName());
		emp2=(Employee)session.load(Employee.class, 23);
		System.out.println(emp2.getName());*/
/*		ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
		EmployeeServiceInterface es=(EmployeeServiceInterface)ac.getBean("employeeService");
		es.getEmployee(23);*/
		
		
		
	}

}

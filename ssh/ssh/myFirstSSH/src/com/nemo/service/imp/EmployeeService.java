package com.nemo.service.imp;

import java.io.Serializable;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.transaction.annotation.Transactional;

import com.nemo.basic.BasicService;
import com.nemo.domain.Department;
import com.nemo.domain.Employee;
import com.nemo.service.interfaces.EmployeeServiceInterface;
/*加上事务注解事务管理器便接管该service
 * 如果该注解只加在其中一个方法上，那么只有这个方法会受事务管理器的管理*/
@Transactional
public class EmployeeService extends BasicService implements EmployeeServiceInterface {
	    //显示所有雇员
		public List showEmployList(int pageSize,int pageNow){
			String hql="from Employee order by id";
			return this.executeQueryByPage(hql, null, pageNow, pageSize);
		}
		
		public int getPageCount(int pageSize){
			
			String hql="select count(*) from Employee";
			
			return this.queryPageCount(hql, null, pageSize);
		}
		
		//验证用户
		public Employee checkEmployee(Employee e) {
			// TODO Auto-generated method stub
			System.out.println("checkEmploye");
			String hql="from Employee where id=? and pwd=?";
			Object []parameters ={e.getId(),e.getPwd()};
			
			List list=this.executeQuery(hql, parameters);
			if(list.size()==0){
				System.out.println("用户不合法");
				return null;
			}else{
				System.out.println("用户合法");
				return (Employee) list.get(0);
			}
		}
	

}

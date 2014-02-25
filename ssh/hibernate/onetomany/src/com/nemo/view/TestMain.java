package com.nemo.view;

import java.util.List;


import org.hibernate.Query;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;
import org.hibernate.stat.Statistics;

import com.nemo.domain.Department;
import com.nemo.domain.Employee2;
import com.nemo.utils.HibernateUtils;

public class TestMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Session s=null;
		List list=null;
		Transaction t=null;
		
		try {
			
			s=HibernateUtils.getCurrentSession();
			t=s.beginTransaction();
			
		/*	Department dep1=new Department();
			dep1.setName("环卫");
			Employee2 emp1=new Employee2();
			emp1.setName("wall-e");
			emp1.setDept(dep1);
			s.save(dep1);
			s.save(emp1);*/
			/*测试缓存*/
			/*Employee2 emp1=new Employee2();
			emp1.setName("King kang");
			emp1.setDept((Department)s.get(Department.class, 21));
			//放入一级缓存
			s.save(emp1)*/;
			//从一级缓存中拿出来（不需要到数据库）
			//Employee2 emp1=(Employee2)s.get(Employee2.class,31);
			/*System.out.println("第一次发送get请求后："+emp1.getName());
			Employee2 emp3=(Employee2)s.get(Employee2.class, emp1.getId());//第二次同样的操作不会在到数据库执行
			System.out.println("第二次发送get请求后："+emp3.getName());
			//提交的时候才发生insert
			//t.commit();
			//清除emp1的缓存
			s.evict(emp1);
			System.out.println("清除emp1的session缓存");
			Employee2 emp4=(Employee2)s.get(Employee2.class, 31);//第二次同样的操作不会在到数据库执行
			System.out.println("第三次发送get请求后："+emp4.getName());
			//清除所有session缓存
			s.clear();
			System.out.println("清除所有session缓存");
			Employee2 emp5=(Employee2)s.get(Employee2.class, 31);//第二次同样的操作不会在到数据库执行
			System.out.println("第四次次发送get请求后："+emp5.getName());
			s.clear();*/
			/**/
			//Employee2 emp1=(Employee2)s.get(Employee2.class,31);
			//s.close();
			/*到二级缓存中找*/
			Employee2 emp2=(Employee2)s.get(Employee2.class,31);
			/*统计二级缓存命中率，统计的信息在当前sessionFactory*/
			Statistics stat=HibernateUtils.getSessionFactory().getStatistics();
			System.out.println(stat);
			System.out.println("放入"+stat.getSecondLevelCachePutCount());
			System.out.println("命中"+stat.getSecondLevelCacheHitCount());
			System.out.println("丢失"+stat.getSecondLevelCacheMissCount());
			t.commit();
			
		} catch (Exception e) {
			if(t!=null){
				t.rollback();
			}
			throw new RuntimeException(e.getMessage());
		}finally{
			if(s!=null&&s.isOpen()){
				s.close();
			}
		}
		
	try {
			s=HibernateUtils.openSession();
			t=s.beginTransaction();
			Employee2 emp3=(Employee2)s.get(Employee2.class,31);
			Statistics stat=HibernateUtils.getSessionFactory().getStatistics();
			System.out.println("放入"+stat.getSecondLevelCachePutCount());
			System.out.println("命中"+stat.getSecondLevelCacheHitCount());
			System.out.println("丢失"+stat.getSecondLevelCacheMissCount());
			
		} catch (Exception e) {
			if(t!=null){
				t.rollback();
			}
			throw new RuntimeException(e.getMessage());
		}finally{
			if(s!=null&&s.isOpen()){
				s.close();
			}
		}
		
	}

}

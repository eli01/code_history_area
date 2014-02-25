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
			dep1.setName("����");
			Employee2 emp1=new Employee2();
			emp1.setName("wall-e");
			emp1.setDept(dep1);
			s.save(dep1);
			s.save(emp1);*/
			/*���Ի���*/
			/*Employee2 emp1=new Employee2();
			emp1.setName("King kang");
			emp1.setDept((Department)s.get(Department.class, 21));
			//����һ������
			s.save(emp1)*/;
			//��һ���������ó���������Ҫ�����ݿ⣩
			//Employee2 emp1=(Employee2)s.get(Employee2.class,31);
			/*System.out.println("��һ�η���get�����"+emp1.getName());
			Employee2 emp3=(Employee2)s.get(Employee2.class, emp1.getId());//�ڶ���ͬ���Ĳ��������ڵ����ݿ�ִ��
			System.out.println("�ڶ��η���get�����"+emp3.getName());
			//�ύ��ʱ��ŷ���insert
			//t.commit();
			//���emp1�Ļ���
			s.evict(emp1);
			System.out.println("���emp1��session����");
			Employee2 emp4=(Employee2)s.get(Employee2.class, 31);//�ڶ���ͬ���Ĳ��������ڵ����ݿ�ִ��
			System.out.println("�����η���get�����"+emp4.getName());
			//�������session����
			s.clear();
			System.out.println("�������session����");
			Employee2 emp5=(Employee2)s.get(Employee2.class, 31);//�ڶ���ͬ���Ĳ��������ڵ����ݿ�ִ��
			System.out.println("���Ĵδη���get�����"+emp5.getName());
			s.clear();*/
			/**/
			//Employee2 emp1=(Employee2)s.get(Employee2.class,31);
			//s.close();
			/*��������������*/
			Employee2 emp2=(Employee2)s.get(Employee2.class,31);
			/*ͳ�ƶ������������ʣ�ͳ�Ƶ���Ϣ�ڵ�ǰsessionFactory*/
			Statistics stat=HibernateUtils.getSessionFactory().getStatistics();
			System.out.println(stat);
			System.out.println("����"+stat.getSecondLevelCachePutCount());
			System.out.println("����"+stat.getSecondLevelCacheHitCount());
			System.out.println("��ʧ"+stat.getSecondLevelCacheMissCount());
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
			System.out.println("����"+stat.getSecondLevelCachePutCount());
			System.out.println("����"+stat.getSecondLevelCacheHitCount());
			System.out.println("��ʧ"+stat.getSecondLevelCacheMissCount());
			
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

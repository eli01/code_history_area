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
		/*��ʾ�������*/
		//save_updateCascade();
		
		/*��ʾ����ɾ��*/
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
		/*ͨ�����һ��session,�����������ģ���ɱ�Ĵ���*/
		/*HibernateUtils.openSession();*/
		//manyToOneAdd();
		/*ͨ����ʼ�����������������*/
	/*	Employee2 emp2=getEmp2();
		Department d=emp2.getDept();//��ʱsession�Ѿ��رգ�
		System.out.println(d.getName());*/
		
		/*��ѯ����1�Ų��ŵ�ѧ��
		 * ����1��from Employee2 where dept.id=1
		 * ����2������one-to-manyӳ���ϵ������Ŀonetomany��*/
		Session s=null;
		Transaction t=null;
		try {
			s=HibernateUtils.getCurrentSession();
			t=s.beginTransaction();
			
			/*����һ*/
		/*	Employee2 e=new Employee2();
			String hql="from Employee2 where dept.id=1";
			List<Employee2> list=s.createQuery(hql).list();
			for(Employee2 emp2:list){
				System.out.println(emp2.getName());
			}*/
			
			/*������*/
			/*Department d=(Department)s.get(Department.class, 1);
			ȡ���ò��ŵĹ�Ա
			Set<Employee2> emps=d.getEmps();
			for(Employee2 emp:emps){
				System.out.println(emp.getName());
			} */
			
			
			/*��ӹ�Ա*/
			Department d=new Department();
			d.setName("���޲�");
			
			Employee2 emp1=new Employee2();
			emp1.setName("������");
			
			Employee2 emp2=new Employee2();
			emp2.setName("��ë��");
			
			Employee2 emp3=new Employee2();
			emp3.setName("�۾���");
			
			Set<Employee2> set=new HashSet<Employee2>();
			set.add(emp1);
			set.add(emp2);
			set.add(emp3);
			
			d.setEmps(set);
			/*����ѧ��
			 *��ӳ���ļ������ü�����Ͳ���Ҫ����ѧ���ˣ����沿���Ƿ��ֹ�Աû������Զ������Ա��������*/
		/*	s.save(emp1);
			s.save(emp2);
			s.save(emp3);*/
			/*���沿��*/
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
	/*���������session�رյ�����
	 * ����һ����ʾ��ʼ���������
	 * ����������Employee2.hbm.xml������class lazy="false"*/
	public static Employee2 getEmp2() {
		Session s=null;
		Transaction t=null;
		Employee2 e2=null;
		try {
			s=HibernateUtils.getCurrentSession();
			t=s.beginTransaction();
			//ȡ��С�����ڲ�������
			e2=(Employee2)s.get(Employee2.class,1);/*��ѯһ�Ź�Ա*/
			/*����һ����ʾ��ʼ���������*/
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
	/*���һ���*/
	public static void manyToOneAdd() {
		Session s=null;
		Transaction t=null;
		try {
			s=HibernateUtils.getCurrentSession();
			t=s.beginTransaction();
			Employee2 e=new Employee2();
			e.setName("С˧");
			
			Department d=new Department();
			d.setName("IT��");
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

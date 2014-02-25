package com.nemo.view;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;

import com.nemo.domain.StuCourse;
import com.nemo.domain.Student;
import com.nemo.domain.Course;
import com.nemo.utils.HibernateUtils;

public class One2OneTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Session s=null;
		Transaction t=null;
		try {
			s=HibernateUtils.getCurrentSession();
			t=s.beginTransaction();
			/*添加一个学生，一门课程，选课*/
			Student stu1=new Student();
			stu1.setName("小明");
			
			Course course=new Course();
			course.setName("java");
			
			StuCourse sc=new StuCourse();
			sc.setCourse(course);
			sc.setStudent(stu1);
			/*顺序保存*/
			s.save(stu1);
			s.save(course);
			s.save(sc);
			t.commit();
		} catch (Exception e) {
			if(t!=null) t.rollback();
			throw new RuntimeException(e.getMessage());
		}finally{
			if(s!=null&&s.isOpen()){
				s.close();
			}
		}
	}

}

package com.nemo.view;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyCache {

	/**
	 * @param args
	 */
	/*ʹ��map ģ�⻺��*/
	static Map<Integer,Student> map=new HashMap<Integer,Student>();
	public static void main(String[] args) {
		/*ģ�⻺�����*/
		System.out.println(getStudent(1).getName());
		System.out.println(getStudent(1).getName());
		
		
	}
	public static Student getStudent(Integer id){
		/*�ȵ�������ȥȡ*/
		Student student=null;
		if(map.containsKey(id)){
			System.out.println("�ӻ�����ȡ����");
			student=map.get(id);
		}else{
			/*�����ݿ�ȥȡ*/
			System.out.println("�����ݿ�ȥȡ!");
			student=MyDB.getStudentFromDB(id);
			/*���뻺��*/
			map.put(id, student);
		}
		return student;
		
	}
	
	
}
/*ģ��һ�����ݿ�*/
class MyDB{
	static List<Student> al=new ArrayList<Student>();
	/*��ʼ�����ݿ�*/
	static{			
		Student stu1=new Student();
		stu1.setId(1);
		stu1.setName("a");
		
		Student stu2=new Student();
		stu2.setId(2);
		stu2.setName("b");
		
		Student stu3=new Student();
		stu3.setId(3);
		stu3.setName("c");
		
		al.add(stu1);
		al.add(stu2);
		al.add(stu3);
	}
	public static Student getStudentFromDB(Integer id){
		Student student=null;
		for(Student stu:al){
			if(stu.getId().equals(id)){
				student=stu;
				break;
			}
		}
		return student;
	}
}
/*ģ��һ��domain*/
class Student{
	private Integer id;
	private String name;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}


package com.nemo.view;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyCache {

	/**
	 * @param args
	 */
	/*使用map 模拟缓存*/
	static Map<Integer,Student> map=new HashMap<Integer,Student>();
	public static void main(String[] args) {
		/*模拟缓存机制*/
		System.out.println(getStudent(1).getName());
		System.out.println(getStudent(1).getName());
		
		
	}
	public static Student getStudent(Integer id){
		/*先到缓存中去取*/
		Student student=null;
		if(map.containsKey(id)){
			System.out.println("从缓存中取出！");
			student=map.get(id);
		}else{
			/*到数据库去取*/
			System.out.println("到数据库去取!");
			student=MyDB.getStudentFromDB(id);
			/*放入缓存*/
			map.put(id, student);
		}
		return student;
		
	}
	
	
}
/*模拟一个数据库*/
class MyDB{
	static List<Student> al=new ArrayList<Student>();
	/*初始化数据库*/
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
/*模拟一个domain*/
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


package com.constructor_11;

public class Employee {
	private String name;
	private int age;
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public Employee(){
		
	}
	public Employee(String name,int age){
		System.out.println("自定义初始化构造函数被调用");
		this.age=age;
		this.name=name;
	}
}

package com.nemo.domain;

public class Employee2 implements java.io.Serializable{

	private static final long serialVersionUID = 1L;
	private Integer id;
	private String name;
	private Department dept;
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
	public Department getDept() {
		return dept;
	}
	public void setDept(Department dept) {
		this.dept = dept;
	}
}

package com.nemo.domain;

import java.util.Set;

public class Department implements java.io.Serializable{

	private static final long serialVersionUID = 1L;
	private Integer id;
	private String name;
	/*这里设置一个集合，对应多个学生 one-to-many*/
	private Set<Employee2> emps;
	public Set<Employee2> getEmps() {
		return emps;
	}
	public void setEmps(Set<Employee2> emps) {
		this.emps = emps;
	}
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

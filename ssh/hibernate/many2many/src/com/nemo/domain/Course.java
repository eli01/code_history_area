package com.nemo.domain;

import java.util.Set;

public class Course implements java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String name;
	private Set<StuCourse> stuCourse;
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
	public Set<StuCourse> getStuCourse() {
		return stuCourse;
	}
	public void setStuCourse(Set<StuCourse> stuCourse) {
		this.stuCourse = stuCourse;
	}
}
	

package com.nemo.domain;

public class StuCourse implements java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Student student;
	private Course course;
	private Integer grade;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	public Integer getGrade() {
		return grade;
	}
	public void setGrade(Integer grade) {
		this.grade = grade;
	}
}

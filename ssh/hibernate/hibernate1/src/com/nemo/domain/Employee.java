package com.nemo.domain;
/*建议我们的domain对象的名称就是对应表的名称 首字母大写
 * domain对象/javabean/pojo[ploain ordinary java project] 简单的java对象
 * 该pojo按照规范应该序列化，目的是唯一的表示该对象,提哦那个是可以在网络文件传输*/

public class Employee implements java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String name;
	private String email;
	private java.util.Date hiredate;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public java.util.Date getHiredate() {
		return hiredate;
	}
	public void setHiredate(java.util.Date hiredate) {
		this.hiredate = hiredate;
	}
}

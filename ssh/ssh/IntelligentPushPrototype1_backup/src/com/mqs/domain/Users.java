package com.mqs.domain;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

/**
 * Users entity. @author MyEclipse Persistence Tools
 */

public class Users implements java.io.Serializable {

	// Fields

	private Integer usersId;
	private Short age;
	private String name;
	private String sex;
	private String job;
	private String hobby;
	private String pwd;
	private BigDecimal mobile;
	private Set readingrecords = new HashSet(0);

	// Constructors

	/** default constructor */
	public Users() {
	}

	/** minimal constructor */
	public Users(Short age, String name, String pwd) {
		this.age = age;
		this.name = name;
		this.pwd = pwd;
	}

	/** full constructor */
	public Users(Short age, String name, String sex, String job, String hobby,
			String pwd, BigDecimal mobile, Set readingrecords) {
		this.age = age;
		this.name = name;
		this.sex = sex;
		this.job = job;
		this.hobby = hobby;
		this.pwd = pwd;
		this.mobile = mobile;
		this.readingrecords = readingrecords;
	}

	// Property accessors

	public Integer getUsersId() {
		return this.usersId;
	}

	public void setUsersId(Integer usersId) {
		this.usersId = usersId;
	}

	public Short getAge() {
		return this.age;
	}

	public void setAge(Short age) {
		this.age = age;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getJob() {
		return this.job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String getHobby() {
		return this.hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

	public String getPwd() {
		return this.pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public BigDecimal getMobile() {
		return this.mobile;
	}

	public void setMobile(BigDecimal mobile) {
		this.mobile = mobile;
	}

	public Set getReadingrecords() {
		return this.readingrecords;
	}

	public void setReadingrecords(Set readingrecords) {
		this.readingrecords = readingrecords;
	}

}
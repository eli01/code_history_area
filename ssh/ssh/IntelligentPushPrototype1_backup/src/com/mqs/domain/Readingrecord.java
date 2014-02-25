package com.mqs.domain;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Readingrecord entity. @author MyEclipse Persistence Tools
 */

public class Readingrecord implements java.io.Serializable {

	// Fields

	private Integer id;
	private News news;
	private Users users;
	private Date begintime;
	private Date endtime;
	private String copycontent;

	// Constructors

	/** default constructor */
	public Readingrecord() {
	}

	/** full constructor */
	public Readingrecord(News news, Users users, Date begintime, Date endtime,
			String copycontent) {
		this.news = news;
		this.users = users;
		this.begintime = begintime;
		this.endtime = endtime;
		this.copycontent = copycontent;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public News getNews() {
		return this.news;
	}

	public void setNews(News news) {
		this.news = news;
	}

	public Users getUsers() {
		return this.users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public Date getBegintime() {
		return this.begintime;
	}

	public void setBegintime(Date begintime) {
		this.begintime = begintime;
	}

	public Date getEndtime() {
		return this.endtime;
	}

	public void setEndtime(Date endtime) {
		this.endtime = endtime;
	}

	public String getCopycontent() {
		return this.copycontent;
	}

	public void setCopycontent(String copycontent) {
		this.copycontent = copycontent;
	}

}
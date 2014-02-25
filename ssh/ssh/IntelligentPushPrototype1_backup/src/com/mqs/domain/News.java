package com.mqs.domain;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * News entity. @author MyEclipse Persistence Tools
 */

public class News implements java.io.Serializable {

	// Fields

	private Integer newsId;
	private String title;
	private String text;
	private Date publishtime;
	private BigDecimal readingcount;
	private Set readingrecords = new HashSet(0);

	// Constructors

	/** default constructor */
	public News() {
	}

	/** minimal constructor */
	public News(String title, String text) {
		this.title = title;
		this.text = text;
	}

	/** full constructor */
	public News(String title, String text, Date publishtime,
			BigDecimal readingcount, Set readingrecords) {
		this.title = title;
		this.text = text;
		this.publishtime = publishtime;
		this.readingcount = readingcount;
		this.readingrecords = readingrecords;
	}

	// Property accessors

	public Integer getNewsId() {
		return this.newsId;
	}

	public void setNewsId(Integer newsId) {
		this.newsId = newsId;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getText() {
		return this.text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Date getPublishtime() {
		return this.publishtime;
	}

	public void setPublishtime(Date publishtime) {
		this.publishtime = publishtime;
	}

	public BigDecimal getReadingcount() {
		return this.readingcount;
	}

	public void setReadingcount(BigDecimal readingcount) {
		this.readingcount = readingcount;
	}

	public Set getReadingrecords() {
		return this.readingrecords;
	}

	public void setReadingrecords(Set readingrecords) {
		this.readingrecords = readingrecords;
	}

}
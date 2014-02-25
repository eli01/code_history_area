package com.nemo.domain;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Messages entity. @author MyEclipse Persistence Tools
 */

public class Messages implements java.io.Serializable {

	// Fields

	private BigDecimal id;
	private String sender;
	private String getter;
	private String content;
	private Date sendtime;
	private String attachment;

	// Constructors

	/** default constructor */
	public Messages() {
	}

	/** minimal constructor */
	public Messages(String sender, String getter, String content) {
		this.sender = sender;
		this.getter = getter;
		this.content = content;
	}

	/** full constructor */
	public Messages(String sender, String getter, String content,
			Date sendtime, String attachment) {
		this.sender = sender;
		this.getter = getter;
		this.content = content;
		this.sendtime = sendtime;
		this.attachment = attachment;
	}

	// Property accessors

	public BigDecimal getId() {
		return this.id;
	}

	public void setId(BigDecimal id) {
		this.id = id;
	}

	public String getSender() {
		return this.sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public String getGetter() {
		return this.getter;
	}

	public void setGetter(String getter) {
		this.getter = getter;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getSendtime() {
		return this.sendtime;
	}

	public void setSendtime(Date sendtime) {
		this.sendtime = sendtime;
	}

	public String getAttachment() {
		return this.attachment;
	}

	public void setAttachment(String attachment) {
		this.attachment = attachment;
	}

}
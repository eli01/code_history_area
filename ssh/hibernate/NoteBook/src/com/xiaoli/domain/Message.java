package com.xiaoli.domain;

public class Message implements java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer mesId;
	private java.util.Date mesTime;
	private String content;
	/*发送对象*/
	private Users sender;
	/*接受对象*/
	private Users getter;
	public Integer getMesId() {
		return mesId;
	}
	public void setMesId(Integer mesId) {
		this.mesId = mesId;
	}
	public java.util.Date getMesTime() {
		return mesTime;
	}
	public void setMesTime(java.util.Date mesTime) {
		this.mesTime = mesTime;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Users getSender() {
		return sender;
	}
	public void setSender(Users sender) {
		this.sender = sender;
	}
	public Users getGetter() {
		return getter;
	}
	public void setGetter(Users getter) {
		this.getter = getter;
	}
	
}

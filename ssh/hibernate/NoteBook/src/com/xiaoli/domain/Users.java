package com.xiaoli.domain;

import java.util.Set;

public class Users implements java.io.Serializable{

	private static final long serialVersionUID = 1L;
	private Integer user_id;
	private String user_passwd;
	private String user_name;
	/*一个用户对应多个发送的信息记录*/
	private Set<Message> sendedMessages;
	/*一个用户对应多条接受的消息记录*/
	private Set<Message> gotMessages;
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	public String getUser_passwd() {
		return user_passwd;
	}
	public void setUser_passwd(String user_passwd) {
		this.user_passwd = user_passwd;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public Set<Message> getSendedMessages() {
		return sendedMessages;
	}
	public void setSendedMessages(Set<Message> sendedMessages) {
		this.sendedMessages =  sendedMessages;
	}
	public Set<Message> getGotMessages() {
		return gotMessages;
	}
	public void setGotMessages(Set<Message> gotMessages) {
		this.gotMessages = gotMessages;
	}
	
	
}

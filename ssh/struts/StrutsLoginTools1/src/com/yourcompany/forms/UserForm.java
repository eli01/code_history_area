package com.yourcompany.forms;

import org.apache.struts.action.ActionForm;

public class UserForm extends ActionForm {
	 private String username=null;
	 private String passwd=null;
	 public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	
	 
}

/*
 * Generated by MyEclipse Struts
 * Template path: templates/java/JavaClass.vtl
 */
package com.xiaoli.struts.form;

import org.apache.struts.action.ActionForm;

/** 
 * MyEclipse Struts
 * Creation date: 07-24-2013
 * 
 * XDoclet definition:
 * @struts.form name="userForm"
 */
public class UserForm extends ActionForm {
	/*
	 * Generated fields
	 */

	/** user_id property */
	private String user_id;

	/** user_passwd property */
	private String user_passwd;

	/*
	 * Generated Methods
	 */

	/** 
	 * Returns the user_id.
	 * @return String
	 */
	public String getUser_id() {
		return user_id;
	}

	/** 
	 * Set the user_id.
	 * @param user_id The user_id to set
	 */
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	/** 
	 * Returns the user_passwd.
	 * @return String
	 */
	public String getUser_passwd() {
		return user_passwd;
	}

	/** 
	 * Set the user_passwd.
	 * @param user_passwd The user_passwd to set
	 */
	public void setUser_passwd(String user_passwd) {
		this.user_passwd = user_passwd;
	}
}
//这是一个javabean，对应映射表，代表数据
package com.sp.model;

public class UserBean {
	private int userId;
	private String username;
	private String passwd;
	private String email;
	private int grade;
	private String myPic;
	
	public void setUserId(int userId) {
		this.userId = userId; 
	}

	public void setUsername(String username) {
		this.username = username; 
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd; 
	}

	public void setEmail(String email) {
		this.email = email; 
	}

	public void setGrade(int grade) {
		this.grade = grade; 
	}

	public int getUserId() {
		return (this.userId); 
	}

	public String getUsername() {
		return (this.username); 
	}

	public String getPasswd() {
		return (this.passwd); 
	}

	public String getEmail() {
		return (this.email); 
	}

	public int getGrade() {
		return (this.grade); 
	}

	
	public void setMyPic(String myPic) {
		this.myPic = myPic; 
	}

	public String getMyPic() {
		return (this.myPic); 
	}
	
}

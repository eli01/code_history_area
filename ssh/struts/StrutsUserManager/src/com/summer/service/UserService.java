package com.summer.service;

import java.util.ArrayList;

import com.summer.domin.Users;
import com.summer.utils.SqlHelper;

public class UserService {
	/*验证用户的方法
	 * 返回一个User对象*/
	public Users checkUser(Users user){
		String sql = "select user_name,user_email,user_tel,user_grade from users where user_id=? and  user_pwd=?"; 
		String[] parameterss={String.valueOf(user.getUser_id()) , user.getUser_pwd()};
		SqlHelper sh=new SqlHelper();
		ArrayList al=sh.executeQuery(sql, parameterss);
		if(al.size()==1){
			/*用户存在，用al将Users进行二次封装*/
			Object[] ob=(Object[])al.get(0);
			user.setUser_name(ob[0].toString());
			user.setUser_email(ob[1].toString());
			user.setUser_tel(ob[2].toString());
			user.setUser_grade(Integer.parseInt(ob[3].toString()));
			return user;
		}else{
			return null;
		}
	}
	/*分页的方法*/
	public ArrayList getUserByFenye(int pageSize , int pageNow){
		String sql = "select * from users limit "+(pageNow-1)*pageSize+","+pageSize;
		//System.out.println(sql);
		ArrayList al=new SqlHelper().executeQuery(sql, null);
		/*对al进行二次封装:将al中的object[]封装成Users对象*/
		ArrayList<Users> alUsers = new ArrayList<Users>();
		for(int i=0;i<al.size();i++){
			Users user=new Users();
			Object[] ob=(Object[])al.get(i);
			user.setUser_id(Integer.parseInt(ob[0].toString()));
			user.setUser_name(ob[1].toString());
			user.setUser_name(ob[2].toString());
			user.setUser_email(ob[3].toString());
			user.setUser_tel(ob[4].toString());
			user.setUser_grade(Integer.parseInt(ob[5].toString()));		
			alUsers.add(user);
		}
		return alUsers;
	}
	/*获得总共多少页*/
	public int getPageCount(int pageSize){
		String sql="select count(*) from users";
		ArrayList al=new SqlHelper().executeQuery(sql, null);
		Object[] ob=(Object[])al.get(0);
		return (Integer.parseInt(ob[0].toString())-1)/pageSize+1;
	}
}

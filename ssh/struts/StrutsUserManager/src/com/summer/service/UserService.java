package com.summer.service;

import java.util.ArrayList;

import com.summer.domin.Users;
import com.summer.utils.SqlHelper;

public class UserService {
	/*��֤�û��ķ���
	 * ����һ��User����*/
	public Users checkUser(Users user){
		String sql = "select user_name,user_email,user_tel,user_grade from users where user_id=? and  user_pwd=?"; 
		String[] parameterss={String.valueOf(user.getUser_id()) , user.getUser_pwd()};
		SqlHelper sh=new SqlHelper();
		ArrayList al=sh.executeQuery(sql, parameterss);
		if(al.size()==1){
			/*�û����ڣ���al��Users���ж��η�װ*/
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
	/*��ҳ�ķ���*/
	public ArrayList getUserByFenye(int pageSize , int pageNow){
		String sql = "select * from users limit "+(pageNow-1)*pageSize+","+pageSize;
		//System.out.println(sql);
		ArrayList al=new SqlHelper().executeQuery(sql, null);
		/*��al���ж��η�װ:��al�е�object[]��װ��Users����*/
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
	/*����ܹ�����ҳ*/
	public int getPageCount(int pageSize){
		String sql="select count(*) from users";
		ArrayList al=new SqlHelper().executeQuery(sql, null);
		Object[] ob=(Object[])al.get(0);
		return (Integer.parseInt(ob[0].toString())-1)/pageSize+1;
	}
}

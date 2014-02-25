package com.xiaoli.test;

import java.util.List;

import com.xiaoli.domain.Users;
import com.xiaoli.service.imp.UserServiceImp;
import com.xiaoli.utils.HibernateUtils;
import com.xiaoli.utils.MyTools;

public class TestMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*≤‚ ‘∂‘123456º”√‹*/
	/*	String str=MyTools.MD5("123456");
		System.out.println(str);*/
		
		/*≤‚ ‘HibernateUtils.executeQuery()*/
		String[] params=new String[]{"1",MyTools.MD5("123456")};
		List<Users> list= HibernateUtils.executeQuery("from Users where user_id=? and user_passwd=?", params);
	
		/*	UserService us=new UserService();
		us.checkUsers(user)*/
		System.out.println(list.size());
		System.out.println(params[1]);
	}

}

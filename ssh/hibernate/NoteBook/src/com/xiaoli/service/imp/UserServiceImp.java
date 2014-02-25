package com.xiaoli.service.imp;

import java.util.List;

import com.xiaoli.domain.Users;
import com.xiaoli.service.inter.UserServiceInter;
import com.xiaoli.utils.HibernateHelper;
import com.xiaoli.utils.MyTools;

/*ҵ�����࣬��ɶ�Users domain�ĸ��ֲ���*/
public class UserServiceImp extends BaseServiceImp implements UserServiceInter {
	/**
	 * @author neo
	 * @function ��֤�û��Ƿ�Ϸ�
	 * @param 
	 * @return �����֤�Ϸ��ͷ���һ��������Users���󣬷��򷵻�null
	 * */

	public Users checkUsers(Users user){
		String hql="from Users where user_id=? and user_passwd=?";
		String[] params={user.getUser_id()+"",MyTools.MD5(user.getUser_passwd())};
		/*�Զ���ɶ��η�װ������hibernate��³����*/
		System.out.println(params[0]+" "+params[1]);
		List<Users> list=HibernateHelper.executeQuery(hql, params);
		System.out.println(list.size());
		if(list.size()==0){
			return null;
		}else{
			return list.get(0);
		}
	}

	@Override
	public Users getUsersByName(String name) {
		Users user=null;
		String hql="from Users where user_name=?";
		String[] params={name};
		try {
			user= (Users)HibernateHelper.uniqueQuery(hql, params);
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
		return user;
	}
}

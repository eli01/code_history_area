package com.xiaoli.service.inter;

import com.xiaoli.domain.Users;

public interface UserServiceInter extends BaseInterface{
	/*������֤�û��ķ���*/
	public Users checkUsers(Users user);
	/*����ͨ���û����õ�Users����ķ���*/
	public Users getUsersByName(String name);
}

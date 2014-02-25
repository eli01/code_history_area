package com.xiaoli.service.inter;

import com.xiaoli.domain.Users;

public interface UserServiceInter extends BaseInterface{
	/*声明验证用户的方法*/
	public Users checkUsers(Users user);
	/*声明通过用户名得到Users对象的方法*/
	public Users getUsersByName(String name);
}

package com.xiaoli.service.inter;

import java.util.List;

import com.xiaoli.domain.Message;
import com.xiaoli.domain.Users;

public interface MessageServiceInter extends BaseInterface{
	/*��ʾ�û����ܵ�������message*/
	public List<Message> showMessage(Users user);
}

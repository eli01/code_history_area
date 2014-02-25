package com.xiaoli.service.inter;

import java.util.List;

import com.xiaoli.domain.Message;
import com.xiaoli.domain.Users;

public interface MessageServiceInter extends BaseInterface{
	/*显示用户接受到的所有message*/
	public List<Message> showMessage(Users user);
}

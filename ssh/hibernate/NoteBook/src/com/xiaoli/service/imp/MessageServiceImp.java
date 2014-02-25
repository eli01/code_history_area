package com.xiaoli.service.imp;

import java.util.List;

import com.xiaoli.domain.Message;
import com.xiaoli.domain.Users;
import com.xiaoli.service.inter.MessageServiceInter;
import com.xiaoli.utils.HibernateHelper;

public class MessageServiceImp extends BaseServiceImp implements MessageServiceInter{
	/*显示用户收到的所有message*/
	public List<Message> showMessage(Users user){
		String hql="from Message where getter.user_id=? or getter.user_id=4";
		String[] params={user.getUser_id().toString()};
		List<Message> list=HibernateHelper.executeQuery(hql, params);
		return list;
	}


}

package com.hsp.actions;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.hsp.domain.User;
import com.hsp.forms.UserForm;
import com.hsp.service.UsersService;
public class LoginAction extends Action {
	//There is  a method that we have to override.This method will be called automatically.
	private int num=0;
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		request.setCharacterEncoding("utf-8");
		num++;
		// Strongly turn form to be a Userform
		UserForm userform=(UserForm)form;
		System.out.println("username:"+userform.getUsername());
		//return super.execute(mapping, form, request, response);
	/*	if(userform.getPasswd().equals("truman")){
			request.setAttribute("num",num+"");
			//if the password is "123",we will take this action legal,then move to next step
			//把名字放到request对象
			//request.setAttribute("username", userform.getUsername());
			return mapping.findForward("ok");//这里是转发而不是重定向
		}else{
			return mapping.findForward("err");
		}*/
		//使r用service到数据库中验证
		UsersService us=new UsersService();
		User user=new User();
		user.setUse_name(userform.getUsername());
		user.setUser_pwd(userform.getPasswd());
		if(us.checkUser(user)){
			return mapping.findForward("ok");
		}else{
			return mapping.findForward("err");
		}
	}
	
	
	
}

package com.yourcompany.actions;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.yourcompany.forms.UserForm;

public class LoginAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// TODO Auto-generated method stub
		//取出表单数据
		UserForm userform=(UserForm)form;
		if(userform.getPasswd().equals("123")){
			System.out.println("gfdsgfdshfs");
			return mapping.findForward("ok");
		}else{
			return mapping.findForward("err");
		}
	}
}

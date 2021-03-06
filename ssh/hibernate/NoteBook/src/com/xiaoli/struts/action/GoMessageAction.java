/*
 * Generated by MyEclipse Struts
 * Template path: templates/java/JavaClass.vtl
 */
package com.xiaoli.struts.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.xiaoli.domain.Message;
import com.xiaoli.domain.Users;
import com.xiaoli.service.imp.MessageServiceImp;
import com.xiaoli.service.inter.MessageServiceInter;

/** 
 * MyEclipse Struts
 * Creation date: 07-24-2013
 * 
 * XDoclet definition:
 * @struts.action parameter="flag"
 */
public class GoMessageAction extends DispatchAction {
	/*
	 * Generated Methods
	 */

	/** 
	 * Method execute
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return ActionForward
	 */
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		/*获取留言信息*/
		//取出该用户收到的信息
		Users loginUser=(Users)request.getSession().getAttribute("userinfo");
		MessageServiceInter msi=new MessageServiceImp();
		List<Message> list=msi.showMessage(loginUser);
		/*现在应该把list集合放在 session request，application?
		 * request*/
		request.setAttribute("messages", list);
		return mapping.findForward("goMessageUi");
	}
}
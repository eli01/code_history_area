//����һ������������Ҫ��ɶ��û���ݵ���֤
//�����������ǲ���ȥ���ҵ���߼�������Ҫ����ģ���������
package com.sp.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.jms.Session;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sp.model.Tools;
import com.sp.model.UserBean;
import com.sp.model.UserBeanCl;

public class LoginClServlet extends HttpServlet {

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//�õ��û���������
		String u=request.getParameter("username");
		u=Tools.getNewString(u);
		String p=request.getParameter("passwd");		
		//ʹ��ģ����ɶ��û�����֤
		UserBeanCl ubc=new UserBeanCl();
		if(ubc.checkUser(u, p)){
			//����ת��wel.jspҳ��ʱ�Ͱ�Ҫ��ʾ�����ݸ�wel.jsp
			//ArrayList<UserBean> al=ubc.getResultByPage(1, 3);
			//int pageCount=ubc.getPageCount();
			//��al,pageCount����request��
			//request.setAttribute("al", al);
			//request.setAttribute("pageCount", pageCount+"");
			//request.setAttribute("pageNow", "1");
			HttpSession hs=request.getSession();
			//���û�������session�Ա�����
			//hs.setMaxInactiveInterval(10);
			hs.setAttribute("username", u);
			hs.setAttribute("sessioncheck", "true");
			//request.setAttribute("username", u);
			//ת��Ч�ʲ��ߣ�
			//response.sendRedirect("wel.jsp?user="+u);
			//��ΪsendRedirect����Ч�ʲ��ߣ����������˾����ʹ��ת���ķ�����Ч�ʸ�)��ͬʱrequest�Ķ��󻹿�������һҳʹ��
			request.getRequestDispatcher("main.jsp").forward(request, response);
		}else{
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	} 

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

}

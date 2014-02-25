//这是一个控制器，主要完成对用户身份的验证
//控制器本身是不会去完成业务逻辑的它主要调用模型完成任务
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
		//得到用户名和密码
		String u=request.getParameter("username");
		u=Tools.getNewString(u);
		String p=request.getParameter("passwd");		
		//使用模型完成对用户的验证
		UserBeanCl ubc=new UserBeanCl();
		if(ubc.checkUser(u, p)){
			//在跳转到wel.jsp页面时就把要显示的数据给wel.jsp
			//ArrayList<UserBean> al=ubc.getResultByPage(1, 3);
			//int pageCount=ubc.getPageCount();
			//将al,pageCount放入request中
			//request.setAttribute("al", al);
			//request.setAttribute("pageCount", pageCount+"");
			//request.setAttribute("pageNow", "1");
			HttpSession hs=request.getSession();
			//将用户名放入session以备后用
			//hs.setMaxInactiveInterval(10);
			hs.setAttribute("username", u);
			hs.setAttribute("sessioncheck", "true");
			//request.setAttribute("username", u);
			//转向（效率不高）
			//response.sendRedirect("wel.jsp?user="+u);
			//因为sendRedirect方法效率不高，所以软件公司常常使用转发的方法（效率高)，同时request的对象还可以在下一页使用
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

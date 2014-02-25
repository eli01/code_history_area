//这个控制器将处理用户的翻页删除添加
package com.sp.control;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sp.model.UserBean;
import com.sp.model.UserBeanCl;

/**
 * Servlet implementation class UserClServlet
 */
@WebServlet("/UserClServlet")
public class UserClServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//得到用户希望显示的pageNow
		try{
			
			//获得标志位
			String flag=request.getParameter("flag");
			//如果要分页显示用户信息
			if(flag.equals("fenye")){
				int pageNow=Integer.parseInt(request.getParameter("pageNow"));	
				//调用UserBeanCl
				UserBeanCl ubc=new UserBeanCl();
				ArrayList<UserBean> al=ubc.getResultByPage(pageNow, 3);
				int pageCount=ubc.getPageCount();
				//将al,pageCount放入request中
				request.setAttribute("al", al);
				request.setAttribute("pageCount", pageCount+"");
				request.setAttribute("pageNow", pageNow+"");//其实这行代码不必要，因为调回wel.jsp时request的内容都跟了过去
				//request.setAttribute("username", request.getAttribute("username"));

				//重新跳转回wel.jsp
				request.getRequestDispatcher("wel.jsp").forward(request, response);
			}else if(flag.equals("delete")){
				//1.得到要删除的用户的id号
				String id=request.getParameter("id");
				UserBeanCl ubc=new UserBeanCl();
				//2.删除用户
				if(ubc.delUser(id)){
					request.getRequestDispatcher("ok.jsp").forward(request, response);
				}else{
					request.getRequestDispatcher("err.jsp").forward(request, response);
				}
			}else if(flag.equals("addUser")){
				//完成添加用户的功能
				//得到用户的信息
				String name=request.getParameter("newName");
				String passwd=request.getParameter("newPasswd");
				String email=request.getParameter("newEmail");
				String grade=request.getParameter("newGrade");
				
				//创建UserBeanCl
				UserBeanCl ubc=new UserBeanCl();
				if(ubc.addUser(name, passwd,email, grade)){
					request.getRequestDispatcher("ok.jsp").forward(request, response);
				}else{
					request.getRequestDispatcher("err.jsp").forward(request, response);
				}
			}else if(flag.equals("edit")){
				UserBeanCl ubc=new UserBeanCl();
				//String sql=ubc.getSql(request.getParameter("newId"),request.getParameter("newEmail"),request.getParameter("newPasswd"),request.getParameter("newGrade"));
				if(ubc.updateUser(request.getParameter("newId"),request.getParameter("newPasswd"),request.getParameter("newEmail"),request.getParameter("newGrade"))){
					request.getRequestDispatcher("ok.jsp").forward(request, response);
				}else{
					request.getRequestDispatcher("err.jsp").forward(request, response);
				}
			}
		
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(request, response);
	}

}

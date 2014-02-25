//����������������û��ķ�ҳɾ�����
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
		//�õ��û�ϣ����ʾ��pageNow
		try{
			
			//��ñ�־λ
			String flag=request.getParameter("flag");
			//���Ҫ��ҳ��ʾ�û���Ϣ
			if(flag.equals("fenye")){
				int pageNow=Integer.parseInt(request.getParameter("pageNow"));	
				//����UserBeanCl
				UserBeanCl ubc=new UserBeanCl();
				ArrayList<UserBean> al=ubc.getResultByPage(pageNow, 3);
				int pageCount=ubc.getPageCount();
				//��al,pageCount����request��
				request.setAttribute("al", al);
				request.setAttribute("pageCount", pageCount+"");
				request.setAttribute("pageNow", pageNow+"");//��ʵ���д��벻��Ҫ����Ϊ����wel.jspʱrequest�����ݶ����˹�ȥ
				//request.setAttribute("username", request.getAttribute("username"));

				//������ת��wel.jsp
				request.getRequestDispatcher("wel.jsp").forward(request, response);
			}else if(flag.equals("delete")){
				//1.�õ�Ҫɾ�����û���id��
				String id=request.getParameter("id");
				UserBeanCl ubc=new UserBeanCl();
				//2.ɾ���û�
				if(ubc.delUser(id)){
					request.getRequestDispatcher("ok.jsp").forward(request, response);
				}else{
					request.getRequestDispatcher("err.jsp").forward(request, response);
				}
			}else if(flag.equals("addUser")){
				//�������û��Ĺ���
				//�õ��û�����Ϣ
				String name=request.getParameter("newName");
				String passwd=request.getParameter("newPasswd");
				String email=request.getParameter("newEmail");
				String grade=request.getParameter("newGrade");
				
				//����UserBeanCl
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

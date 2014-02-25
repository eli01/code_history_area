package com.yourcompany.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SecurityFilter extends HttpServlet implements Filter {

	private String keywords="";
	String[] keys;
	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		//�������ǽ����û���
		String name=request.getParameter("username");
		System.out.println("��ȫ���ƹ��ˣ�"+name);
		if(name!=null){
			for(String temp:keys){
				if(name.equals(temp)){
					request.setAttribute("attention", "���ڶ����˰�ȫ�Ĺ���������,���ֲ���ʹ�� <font color='red'>"+name+"</font>");
					request.getRequestDispatcher("/WEB-INF/attention.jsp").forward(request, response);
					return;
				}
			}
		
		}
		
		chain.doFilter(request, response);
		
		
	}
//�ú��������ȱ�����һ��
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		keywords=filterConfig.getInitParameter("keywords");
		keys=keywords.split(";");
	}

}

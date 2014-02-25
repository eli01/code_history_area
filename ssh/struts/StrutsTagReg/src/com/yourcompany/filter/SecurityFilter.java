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
		//这里我们接受用户名
		String name=request.getParameter("username");
		System.out.println("安全机制过滤！"+name);
		if(name!=null){
			for(String temp:keys){
				if(name.equals(temp)){
					request.setAttribute("attention", "被第二过滤安全的过滤器拦截,名字不能使用 <font color='red'>"+name+"</font>");
					request.getRequestDispatcher("/WEB-INF/attention.jsp").forward(request, response);
					return;
				}
			}
		
		}
		
		chain.doFilter(request, response);
		
		
	}
//该函数会首先被调用一次
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		keywords=filterConfig.getInitParameter("keywords");
		keys=keywords.split(";");
	}

}

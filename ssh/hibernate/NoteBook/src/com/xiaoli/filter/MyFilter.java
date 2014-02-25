package com.xiaoli.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.xiaoli.utils.HibernateHelper;

public class MyFilter extends HttpServlet implements Filter {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		// TODO Auto-generated method stub
		Session s=null;
		Transaction t=null;
		try {
			s=HibernateHelper.getCurrentSession();
			t=s.beginTransaction();
			
			arg2.doFilter(arg0, arg1);//这个方法后面的内容要在整个请求动作完成后才执行
			/*请求返回到这里时提交事务*/
			t.commit();
		} catch (Exception e) {
			if(t!=null){
				t.rollback();		
			}
		}finally{
			HibernateHelper.closeCurrentSession();
		}
	}


	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}

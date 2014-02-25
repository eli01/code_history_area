package net.itcast;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserVerify extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
    	response.setContentType("text/html;charset=UTF-8");
    	PrintWriter out=response.getWriter();
    	try {
			String param=request.getParameter("userName");
			if(param==null||param.length()==0){
				out.println("用户名不能为空");
			}else{
				String userName=URLDecoder.decode(param,"UTF-8");
				if(userName.equals("nemo")){
					out.println("用户名["+userName+"]已经存在，请使用别的用户名注册");
				}else{
					out.println("可以使用用户名["+userName+"]注册");
				}
			}
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}finally{
			out.close();
		}
    }
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.processRequest(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.processRequest(request, response);
	}
	
	public String getServletInfo(){
		return "这是一段用来产生相应文本的服务器程序，产生的文本将会异步发送到网页相应位置";
	}

}

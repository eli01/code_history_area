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
				out.println("�û�������Ϊ��");
			}else{
				String userName=URLDecoder.decode(param,"UTF-8");
				if(userName.equals("nemo")){
					out.println("�û���["+userName+"]�Ѿ����ڣ���ʹ�ñ���û���ע��");
				}else{
					out.println("����ʹ���û���["+userName+"]ע��");
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
		return "����һ������������Ӧ�ı��ķ��������򣬲������ı������첽���͵���ҳ��Ӧλ��";
	}

}

<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'login.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body  bgcolor=#CFD4FF>
  
  <% 
  
  		String err=(String)request.getParameter("err");
  		if(err!=null){
  			if(err.equals("1")){
  				out.println("<font color=red size=7>�û�û��������½��</font><br>");
  			}
  		}
  		
  %>
  <img src=imgs/welcome.gif  width="200px" height="50px"/><hr>
    <center>
    <h1>�û���¼</h1> <br>
    
    <form action="LoginClServlet" mathod="post">
    	�û�����<input type="text" name="username"><br>
    	��&nbsp;&nbsp;�룺<input type="password" name="passwd"><br>
    	<input type="submit" value="��½">
		<input type="reset" value="����">
    </form>
   </center>
    <hr><img src=imgs/wel.gif  width="200px" height="50px"/>
  </body>
  
</html>

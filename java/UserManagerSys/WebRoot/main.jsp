<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'Main.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body bgcolor=#CFD4FF>
      <img src=imgs/welcome.gif  width="200px" height="50px"/><hr>
    <center>
    <h1>主界面</h1> <br>
    <a href="UserClServlet?pageNow=1&flag=fenye">管理用户</a><br>
    <a href="addUser.jsp">添加用户</a><br>
    <a href="UserClServlet?flag=search">查找用户</a><br>
    <a href="UserClServlet?flag=exit">安全退出</a><br>
   </center>
    <hr><img src=imgs/wel.gif  width="200px" height="50px"/><br>
  </body>
</html>

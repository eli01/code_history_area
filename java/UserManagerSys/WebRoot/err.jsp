<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'err.jsp' starting page</title>
    
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
    <img src=imgs/hello1.jpg><hr> <center><br>
    <h1>������Ŷ��</h1><br>
    <a href=main.jsp>����������</a>&nbsp;&nbsp;&nbsp;<a href=UserClServlet?flag=fenye&pageNow=1>��������</a>
    </center><hr><img src=imgs/apple.jpg>
  </body>
</html>

<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'updateUser.jsp' starting page</title>
    
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
  <img src=imgs/hello1.jpg><hr> <center>
  <h1>修改用户界面</h1>
  <form action="UserClServlet?flag=edit" method="post">
  <table border=1>
  		<%
  		request.setCharacterEncoding("gb2312");
  		%>
		<tr><td>用户ID</td><td><input readonly type=text  name=newId value=<%=request.getParameter("userid")%>></td></tr>
		<tr><td>用户姓名</td><td><input readonly type=text name=newName value=<%=request.getParameter("username")%>></td></tr>
		<tr><td>用户密码</td><td><input  type=text name=newPasswd value=<%=request.getParameter("passwd")%>></td></tr>
		<tr><td>用户邮箱</td><td><input type=text name=newEmail value=<%=request.getParameter("email")%>></td></tr>
		<tr><td>用户级别</td><td><input type=text name=newGrade value=<%=request.getParameter("grade")%>></td></tr>
		<tr><td colspan=2><input type=submit value=修改用户></td></tr>
		</table>
		</form>
		</center><hr><img src=imgs/apple.jpg>  
 </body>
</html>

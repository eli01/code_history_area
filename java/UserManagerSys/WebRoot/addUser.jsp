<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'addUser.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript">
	<!--
	function check(){
		return window.confirm("确定添加该用户吗？");
	}
	-->
	</script>
  </head>
  
  <body  bgcolor=#CFD4FF>
  <img src=imgs/hello1.jpg /><hr> 
  <center>
  <h1>修改用户界面</h1>
  <form action="UserClServlet?flag=addUser" method="post">
  <table border=1>
  <tr><td>用户姓名</td><td><input  type=text name=newName></td></tr>
  <tr><td>登陆密码</td><td><input  type=text name=newPasswd></td></tr>
  <tr><td>电子邮件</td><td><input type=text name=newEmail></td></tr>
  <tr><td>用户级别</td><td><input type=text name=newGrade></td></tr>
  <tr><td colspan=2><center><input type=submit value=添加用户 onclick="check();" >&nbsp;&nbsp;&nbsp;<input type=reset value=重置></center></td></tr>
  </table>
  </form>
  </center><hr><img src=imgs/apple.jpg />
  </body>
</html>

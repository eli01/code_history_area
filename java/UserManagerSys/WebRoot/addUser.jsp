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
		return window.confirm("ȷ����Ӹ��û���");
	}
	-->
	</script>
  </head>
  
  <body  bgcolor=#CFD4FF>
  <img src=imgs/hello1.jpg /><hr> 
  <center>
  <h1>�޸��û�����</h1>
  <form action="UserClServlet?flag=addUser" method="post">
  <table border=1>
  <tr><td>�û�����</td><td><input  type=text name=newName></td></tr>
  <tr><td>��½����</td><td><input  type=text name=newPasswd></td></tr>
  <tr><td>�����ʼ�</td><td><input type=text name=newEmail></td></tr>
  <tr><td>�û�����</td><td><input type=text name=newGrade></td></tr>
  <tr><td colspan=2><center><input type=submit value=����û� onclick="check();" >&nbsp;&nbsp;&nbsp;<input type=reset value=����></center></td></tr>
  </table>
  </form>
  </center><hr><img src=imgs/apple.jpg />
  </body>
</html>

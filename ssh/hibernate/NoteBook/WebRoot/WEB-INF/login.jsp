<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
	<title>留言本登陆界面</title>
  </head>
  <body>
    <form action="/NoteBook/login.do?flag=login" method="post">
    <table border="2px">
    <tr><td colspan="2" align="center"><font color="green">留言本登陆</font></td></tr>
    <tr><td>用户编号</td><td><input type="text" name="user_id"/></td></tr>
    <tr><td>用户密码</td><td><input type="password" name="user_passwd"/></td></tr>
    <tr><td><input type="submit" value="登陆"/></td><td><input type="reset" value="重置"/></td></tr>
    </table>
    </form>
  </body>
</html>

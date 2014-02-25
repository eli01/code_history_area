<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>发布信息页面</title>
  </head>
  <body>
    <font size="6"><a href="#">查看信息</a></font><font size="6">&nbsp;&nbsp;&nbsp;<a href="#">退出系统</a></font><br/>
    <form action="${pageContext.request.contextPath}/goPublishMessageUi.do?flag=publishMessage" method="post">
   	<table>
   	<tr><td>接收人：</td><td><input type="text" name="getter"/></td></tr>
   	<tr><td>发送内容：</td><td><textarea rows="5" cols="20" name="content">请输入内容</textarea></td></tr>
   	<tr><td><input type="submit" value="发送信息"/></td><td><input type="reset" value="重写"/></td></tr>
   	</table> 
    </form>
  </body>
</html>

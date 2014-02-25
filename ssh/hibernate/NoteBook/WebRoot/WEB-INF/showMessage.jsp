<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>消息主界面</title>
  </head>
  
  <body>
 
    <font size="6"><a href="${pageContext.request.contextPath}/goPublishMessageUi.do?flag=goPublishMessageUi"><b>发布信息</b></a></font>             
    <font size="6"><a href="${pageContext.request.contextPath}/login.do?flag=logout"><b>退出系统</b></a></font><br/>
    欢迎你，${userinfo.user_name}<br/>留言信息：<br/>
    <form action="" method="post">
	  <table border="2px">
     <tr><td>发送人</td><td>发送时间</td><td>接受人</td><td>消息内容</td></tr>
     <c:forEach items="${messages }" var="message">
     <tr>
     <td>${message.sender.user_name }</td>
     <td>${message.mesTime }</td>
     <td>${message.getter.user_name }</td>
     <td>${message.content} </td>
     </tr>
     </c:forEach>
     </table>    
    </form>

  </body>
</html>

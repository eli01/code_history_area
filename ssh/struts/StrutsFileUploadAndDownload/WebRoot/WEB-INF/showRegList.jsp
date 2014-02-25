<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
 
    <title>My JSP 'showRegList.jsp' starting page</title>

  </head>
  
  <body>&nbsp; 
   <h1>用户 </h1> <br>
   <table>
     <c:forEach items="${regList}" var="user">
     <tr><td>${user.name }</td><td><img src="/StrutsFileUploadAndDownload/files/${user.photouuid }" width="100px"></td><td><a href="/StrutsFileUploadAndDownload/download.do?username=${user.name }">点击下载</a></td></tr>
     </c:forEach>
   </table>
  </body>
</html>

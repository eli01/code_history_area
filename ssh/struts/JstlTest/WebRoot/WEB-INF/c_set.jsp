<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!--引入标签库  -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  </head>
  
  <body>
  <!--  下面两种方式等价-->
<c:set  var="abc" value="时代精神" scope=”request“></c:set>
<%
request.setAttribute("abc","shidaijingshen");
 %>
 
 <c:out value="${abc} "></c:out>
 </body>
</html>

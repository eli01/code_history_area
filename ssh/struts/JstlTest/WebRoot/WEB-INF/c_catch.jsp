<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <body>
	<c:catch var="myexception">
	<h1>c:catch的用法</h1>
	<%int x=8/0;%>
	</c:catch>
	<c:out value="${myexception.message }"></c:out>
  </body>
</html>

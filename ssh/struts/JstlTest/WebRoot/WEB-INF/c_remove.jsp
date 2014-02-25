<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <body>
    <c:set var="x" value="维纳斯" scope="request"></c:set>
    删除前：<br/>
  	<c:out value="${x }"></c:out>
  	<c:remove var="x" scope="request"/>
  	删除后：<br/>
  	 <c:out value="${x }" default="没有值"></c:out>
  </body>
</html>

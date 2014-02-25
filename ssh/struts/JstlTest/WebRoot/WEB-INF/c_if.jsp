<%@ page language="java" import="java.util.*,com.nemo.domin.*" pageEncoding="UTF-8"%>
<!-- 引入jstl标签库 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <body>
  <h1>单分支判断</h1>
 
  	<c:set var="x" value="计划"></c:set>
	<c:if test="${x=='计划' }">ok!</c:if>
	<c:if test="${x!='计划' }">not ok!</c:if>
	<c:set var="age" value="10"></c:set>
	<c:if test="${age==10 }">number ok</c:if><!-- 会自动判断是否是数字    -->
	<c:if test="${age!=10 }">not ok</c:if>
	<c:if test="${age < 50 }">
	age<50 and age>1
	</c:if>

	<c:if test="${2>1?true:false }">
	ok!!
	</c:if>
	<%
	Rat r=new Rat();
	r.setAge(10);
	r.setName("Jerry");
	request.setAttribute("rat1", r);
	 %>	
	 <h1>判断 的属性</h1>
	 <c:if test="${rat1.age>3 }">
	 rat1.age>3
	 </c:if>
	 
  </body>
</html>

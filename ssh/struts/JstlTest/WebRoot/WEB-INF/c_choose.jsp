<%@ page language="java" import="java.util.*,com.nemo.domin.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html> 
  <body>
    	<%
	Rat r=new Rat();
	r.setAge(10);
	r.setName("Jerry");
	request.setAttribute("rat1", r);
	 %>	
	 <c:choose>
		 
		 <c:when test="${rat1.age<2} }">
		 <font color="red">太小！</font>
		 </c:when >
		
		 <c:when test="${rat1.age==10}">
		 <font color="blue">刚刚好！</font>
		 </c:when>
		
		  <c:when test="${ rat1.age>10}">
			<font color="yellow" >太老！</font>
		  </c:when>
		   
		   <c:otherwise>
		   impossible!
		   </c:otherwise>
		   
	 </c:choose>
	
  </body>
</html>

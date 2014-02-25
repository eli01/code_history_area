<%@ page language="java" import="java.util.*,com.nemo.domin.*" pageEncoding="UTF-8"%>
<!-- 引入jstl标签库 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>jstl基础</title>
    
  </head>
  
  <body>
  <!-- 输出 -->
  1.c:out
  输出字符串：<br>
   <c:out value="hello,world!"></c:out>
   <%
 /*  理论上难过应该放在控制器中，这里方便演示 
 	如果域对象中有多个相同名称变量值，c:out的优先级是：pageConntext > request  > session > application
  */
   request.setAttribute("name", "<a href='http://www.souhu.com'> souhu</a>");   	
   session.setAttribute("name", "rose");
   application.setAttribute("name", "jack");
   pageContext.setAttribute("name", "smith");
  
  User u=new User();
  u.setName("xiaoli");
  u.setAge("30");
  request.setAttribute("user1", u);
    %>
    <h1>如何输出request/session/application/pageContent的数据</h1>  
    输出变量：<br>
    <!-- 如果 对象 -->
    <!-- 
    value:输出的内容""或变量"${ a}"
    default:如果一个该名称的该名称的变量也没有默认输出
    escapeXml：指定输出模式是以文本的方式（true）还是html的方式（false），默认为true
     -->
   <c:out value="${name}" default="没有值"  escapeXml="false"></c:out> <!-- 等价于 request.getAttribute("abc").toString(); -->
   
   <h1>如何输出对象的值</h1>
  <!-- 以下三种方式等价 -->
   <c:out value="${user1.name} "></c:out>|| <c:out value="${user1.age} "></c:out><br/>
   ${user1.name } @@ ${user1.age*20} 
   <%= ( (User)request.getAttribute("user1")).getName()%>@@<%=((User)request.getAttribute("user1")).getAge()%>
 
  </body>
</html>

<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="logic" uri="http://struts.apache.org/tags-logic" %>
<%@taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'manageUser.jsp' starting page</title>

  </head>
  
  <body>
   <h1>管理用户</h1> <br/>
   <table>
   <tr><td>id</td><td>passwd</td><td>name</td><td>email</td><td>tel</td><td>grade</td></tr>
   <logic:iterate id="user" name="userspage">
   <tr><td> ${user.user_id } </td><td> ${user.user_pwd} </td><td> ${user.user_name } </td><td>  ${user.user_email }  </td><td>${user.user_tel } </td><td> ${user.user_grade } </td></tr>
   </logic:iterate> 
   </table>
      <c:forEach begin="1" end="${pageCount }" var="i">
   <a href="/StrutsUserManager/gotoManager.do?pageNow=${i}"> ${ i } </a>
   </c:forEach>
  </body>
</html>

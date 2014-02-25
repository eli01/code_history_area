<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <body>
   <html:form action="/reg.do"  method="post">
   userid<html:text property="userid">用户编号</html:text><br/>
   username<html:text property="username">用户名</html:text><br/>
   email<html:text property="email">用户邮箱</html:text><br/>
   <html:submit value="注册"></html:submit>
   <html:cancel value="重新填写"></html:cancel>
   </html:form>
  </body>
</html>

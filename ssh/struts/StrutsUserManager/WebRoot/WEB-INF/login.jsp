<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="html"  uri="http://struts.apache.org/tags-html"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <body>
    <html:form action="/login.do" method="post">
   用户编号： <html:text property="user_id" /><br/>
   用户密码： <html:password property="user_pwd" /><br/>
    <html:submit value="登录"></html:submit>
    <html:cancel value="取消"></html:cancel>
    </html:form>
  </body>
</html>

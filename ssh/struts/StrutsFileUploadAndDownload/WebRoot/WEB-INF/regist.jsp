<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <body>
  <!-- 如果我们的表单中有 控件，则需要重新指定表单的编码方式 -->
    <form enctype="multipart/form-data"    action="/StrutsFileUploadAndDownload/register.do" method="post">
    用户名：<input type="text" name="name"/><br/>
    头像：<input type="file" name="myphoto"/><br/>
    <input type="submit" value="注册"/>
    </form>
    </body>
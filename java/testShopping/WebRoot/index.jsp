<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!-- 这里引用文件 -->
	<link rel="stylesheet" type="text/css" href="css/word1.css">
	

  </head>
  
  <body>
	<table width="80%" border="1" align="center">
  <tr>
    <td height="76" colspan="2" align="center">
    <!-- 引入head.jsp -->
    <jsp:include flush="true" page="head.jsp"></jsp:include>
    </td>
  </tr>
  <tr>
    <td width="22%" height="204" align="center">left.jsp</td>
    <td width="78%" align="center">right.jsp</td>
  </tr>
  <tr>
    <td height="70" colspan="2" align="center">
    <jsp:include flush="true" page="tail.jsp"></jsp:include>
    </td>
  </tr>
</table>
    
  </body>
</html>

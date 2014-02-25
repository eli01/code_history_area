<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib  uri="http://struts.apache.org/tags-html"  prefix="html" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <body> 
  property:button 的名字<br/>
<!--  按钮 -->
   <html:button property="buttonname" value="提交"></html:button>
<!-- image是按钮 img是普通图片 -->
 <html:img src="images/IMG_20130707_211836.jpg"/>
   <html:image  src="images/IMG_20130707_211836.jpg"/> 
  <html:link href="www.baidu.com">百度</html:link>
<!--   html:form 
struts的HTML标签如果设计到信息的输入，struts框架要求你的
1.和一个表单对应，而且应当放在一个<html：form>中
2.
-->
<html:form action="/login.do" method="post">
	<html:text property="name"></html:text>
	<html:checkbox property="age"></html:checkbox>
</html:form>

  </body>
</html>

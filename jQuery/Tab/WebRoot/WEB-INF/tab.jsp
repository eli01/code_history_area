<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'tab.jsp' starting page</title>  
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link type="text/css" rel="stylesheet" href="css/tab.css" />
	<script type="text/javascript" src="js/jquery.js"></script>
	<script type="text/javascript" src="js/tab.js"></script>
  </head>
  <body>
    <ul id="tabfirst">
    	<li class="tabin">标签一</li>
    	<li>标签二</li>
    	<li>标签三</li>
    </ul>
    <div class="contentfirst contentin">内容一</div>
    <div class="contentfirst">内容二</div>
    <div class="contentfirst">内容三</div>
    <br/>
    <br/>
    <br/>
    <h1> 和服务器动态交互的标签页 </h1>
    <ul id="tabsecond">
    	<li class="tabin">标签1</li>
    	<li>标签2</li>
    	<li>标签3</li>
    </ul>
    <div id="contentsecond">
    <img alt="装载中" src="images/img-loading.gif"/>
    <div id="realcontent"></div>
    </div>
  </body>
</html>

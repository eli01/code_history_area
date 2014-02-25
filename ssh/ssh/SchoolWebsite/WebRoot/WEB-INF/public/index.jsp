<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  <title>My JSP 'index.jsp' starting page</title> 
  <link rel="stylesheet" href="/SchoolWebsite/css/index.css" type="text/css"/>
  <link rel="stylesheet" href="/SchoolWebsite/css/common.css" type="text/css"/>
  </head>
  <body>
  <!-- 引入头页面 -->
  <jsp:include page="head.jsp"/>
    <div class="main">
    <div class="reg_log">
    <div class="logForm">
    	用户登录
    </div>
    <div class="reg">
    	注册
    </div>
    <div class="mobile">
    	手机登录
    </div>
    </div>
    <div class="banner1"> 
	<img alt="" src="/SchoolWebsite/images/front/ay-0812-658-280.jpg"/>    
    </div>
    <div  class="intro">
    <span class="font2">校内是一个真实社交网络，加入她你可以：</span> 
	
	<li>联络朋友，了解他们的最新动态</li> 
	<li>用照片和日志记录生活，展示自我</li> 
	<li>找到老同学结识新朋友</li> 
  	<li>和朋友分享相片、音乐和电影</li> 
	<li>自由、安全地控制个人隐私</li> 
	 	
    </div>
    <!-- 注册第二个入口-->
    <div class="reg2">
    <span class="font2">因为真实 所以精彩</span>
    <p>
             校内存知己<br/>
    <input type="image" onclick="" src="/SchoolWebsite/images/front/register.jpg"/>
    </p>
 	   
    </div>
    <!-- 寻找你的朋友 -->
    <div>
    
    <span>寻找你的朋友</span><input type="text" name="sea_friends">
    </div>
    </div>
    <jsp:include page="foot.jsp"/>
    
  </body>
</html>

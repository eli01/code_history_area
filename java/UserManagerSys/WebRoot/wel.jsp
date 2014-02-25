<%@ page language="java" import="java.util.*,java.sql.*,com.sp.model.*" pageEncoding="gb2312"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'wel.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript">
	<!--
	function check(){
		return window.confirm("确定删除该用户吗？");
	}
	-->
	</script>
  </head>
  
  <body  bgcolor=#CFD4FF>
  <% 
    //阻止缓存  
	 response.setHeader("Pragma","No-cache");  
	 response.setHeader("Cache-Control","no-cache");  
	 response.setDateHeader("Expires", 0); 

  	//防止用户的非法登陆
  	String u=(String)session.getAttribute("username");
  	//如果用户没有登录
  	if(u==null){
  	//返回登陆界面
  	response.sendRedirect("login.jsp?err=1");
  	return;
  	}
  %>
   <img src=imgs/welcome.gif  width="200px" height="50px"/><hr>
  	<h1> 登陆成功！恭喜你！<%=u%> </h1><br>
  	<a href="login.jsp">返回重新登录</a>
  	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  	<a href="main.jsp">返回主界面</a>
  	
  	<hr>
  	<center>
  	<h1>用户信息列表</h1>
  	<%
  	//定义四个分也会用到的变量
  	int pageSize=3;
	//int pageNow=1;//默认显示第一夜页
    int pageNow=Integer.parseInt((String)request.getAttribute("pageNow"));
  	//int rowCount=0;//该值从数据库查询
  	int pageCount=0;//该值是通过pageSize和rowCount得到的
  	int lianjieSize=5;
 
  	//接收用户希望显示的页
  	/*
  	String strPageNow=request.getParameter("pageNow");
  	if(strPageNow!=null){
  		pageNow=Integer.parseInt(strPageNow);
  	}
  	
  	*/
  	//查询得到rowCount

  	 ArrayList al=(ArrayList)request.getAttribute("al");
  	 String strPage=(String)request.getAttribute("pageCount");
  	 pageCount=Integer.parseInt(strPage);//得到一共的页数
  	 //显示  	 
  	 %>
  	 <table border="1">
  	 <tr bgcolor="green"><td>用户ID</td><td>用户名字</td><td>密码</td><td>电邮</td><td>级别</td><td>修改用户</td><td>删除用户</td></tr>
  	 <%

  	 //定义一个颜色数组
	 String[] myColor={"silver","pink"};
  	 for(int i=0;i<al.size();i++)
	 {
		UserBean ub=(UserBean)al.get(i);
		/*
		out.println("<tr bgcolor="+myColor[i%2]+">");
		out.println("<td>"+ub.getUserId()+"</td>");
		out.println("<td>"+ub.getUsername()+"</td>");
		out.println("<td>"+ub.getPasswd()+"</td>");
		out.println("<td>"+ub.getEmail()+"</td>");
		out.println("<td>"+ub.getGrade()+"</td>");
		out.println("<td><a href=update?userid="+ub.getUserId()+"&username="+ub.getUsername()+"&passwd="+ub.getPasswd()+"&email="+ub.getEmail()+"&grade="+ub.getGrade()+" onclick=\"return window.confirm('确认修改')\">修改用户</a></td>");
		out.println("<td><a href=delusercl?userid="+ub.getUserId()+" onclick=\"return window.confirm('确认删除')\">删除用户</a></td>");					
		out.println("</tr>");
		*/
		%>
  	 	 <tr bgcolor="<%=myColor[i%2] %>"><td><%=ub.getUserId()%></td><td><%= ub.getUsername()%></td><td><%=ub.getPasswd() %></td><td><%=ub.getEmail()%></td><td><%=ub.getGrade()%></td>
  	 	 <td><a href="updateUser.jsp?flag=edit&userid=<%=ub.getUserId() %>&username=<%=ub.getUsername()%>&passwd=<%=ub.getPasswd() %>&email=<%=ub.getEmail()%>&grade=<%=ub.getGrade() %>">修改用户</a></td>
  	 	 <td><a onclick="check();" href="UserClServlet?flag=delete&id=<%=ub.getUserId() %>">删除用户</a></td></tr>
  	 	<% 
	 }
  	 %>
  	 </table>
  	 	
  	 <% 
  	 //上一页
  	 if(pageNow!=1){
  	 out.println("<a href=UserClServlet?flag=fenye&pageNow="+(pageNow!=1?pageNow-1:pageNow)+">上一页</a>");
  	 }
  	 //显示超链接
  	 /*
  	 for(int i=1;i<=pageCount;i++){
  	 	out.println("<a href=wel.jsp?pageNow="+i+">["+i+"]</a>");
  	 }*/
  	 if(pageCount<lianjieSize){
  	 	lianjieSize=pageCount;
  	 }
  	 for(int i=pageNow;i<=pageNow+lianjieSize-1;i++){
  	 	out.println("<a href=UserClServlet?flag=fenye&pageNow="+i+">"+i+"</a>");
  	 }
  	 //下一页
  	 if(pageNow!=pageCount){
  	 out.println("<a href=UserClServlet?flag=fenye&pageNow="+(pageNow!=pageCount?pageNow+1:pageNow)+">下一页</a>");
  	 }
 
  	 %>
  	 </center>
  	  <hr><img src=imgs/welcome.gif  width="200px" height="50px"/>
  </body>
</html>

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
		return window.confirm("ȷ��ɾ�����û���");
	}
	-->
	</script>
  </head>
  
  <body  bgcolor=#CFD4FF>
  <% 
    //��ֹ����  
	 response.setHeader("Pragma","No-cache");  
	 response.setHeader("Cache-Control","no-cache");  
	 response.setDateHeader("Expires", 0); 

  	//��ֹ�û��ķǷ���½
  	String u=(String)session.getAttribute("username");
  	//����û�û�е�¼
  	if(u==null){
  	//���ص�½����
  	response.sendRedirect("login.jsp?err=1");
  	return;
  	}
  %>
   <img src=imgs/welcome.gif  width="200px" height="50px"/><hr>
  	<h1> ��½�ɹ�����ϲ�㣡<%=u%> </h1><br>
  	<a href="login.jsp">�������µ�¼</a>
  	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  	<a href="main.jsp">����������</a>
  	
  	<hr>
  	<center>
  	<h1>�û���Ϣ�б�</h1>
  	<%
  	//�����ĸ���Ҳ���õ��ı���
  	int pageSize=3;
	//int pageNow=1;//Ĭ����ʾ��һҹҳ
    int pageNow=Integer.parseInt((String)request.getAttribute("pageNow"));
  	//int rowCount=0;//��ֵ�����ݿ��ѯ
  	int pageCount=0;//��ֵ��ͨ��pageSize��rowCount�õ���
  	int lianjieSize=5;
 
  	//�����û�ϣ����ʾ��ҳ
  	/*
  	String strPageNow=request.getParameter("pageNow");
  	if(strPageNow!=null){
  		pageNow=Integer.parseInt(strPageNow);
  	}
  	
  	*/
  	//��ѯ�õ�rowCount

  	 ArrayList al=(ArrayList)request.getAttribute("al");
  	 String strPage=(String)request.getAttribute("pageCount");
  	 pageCount=Integer.parseInt(strPage);//�õ�һ����ҳ��
  	 //��ʾ  	 
  	 %>
  	 <table border="1">
  	 <tr bgcolor="green"><td>�û�ID</td><td>�û�����</td><td>����</td><td>����</td><td>����</td><td>�޸��û�</td><td>ɾ���û�</td></tr>
  	 <%

  	 //����һ����ɫ����
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
		out.println("<td><a href=update?userid="+ub.getUserId()+"&username="+ub.getUsername()+"&passwd="+ub.getPasswd()+"&email="+ub.getEmail()+"&grade="+ub.getGrade()+" onclick=\"return window.confirm('ȷ���޸�')\">�޸��û�</a></td>");
		out.println("<td><a href=delusercl?userid="+ub.getUserId()+" onclick=\"return window.confirm('ȷ��ɾ��')\">ɾ���û�</a></td>");					
		out.println("</tr>");
		*/
		%>
  	 	 <tr bgcolor="<%=myColor[i%2] %>"><td><%=ub.getUserId()%></td><td><%= ub.getUsername()%></td><td><%=ub.getPasswd() %></td><td><%=ub.getEmail()%></td><td><%=ub.getGrade()%></td>
  	 	 <td><a href="updateUser.jsp?flag=edit&userid=<%=ub.getUserId() %>&username=<%=ub.getUsername()%>&passwd=<%=ub.getPasswd() %>&email=<%=ub.getEmail()%>&grade=<%=ub.getGrade() %>">�޸��û�</a></td>
  	 	 <td><a onclick="check();" href="UserClServlet?flag=delete&id=<%=ub.getUserId() %>">ɾ���û�</a></td></tr>
  	 	<% 
	 }
  	 %>
  	 </table>
  	 	
  	 <% 
  	 //��һҳ
  	 if(pageNow!=1){
  	 out.println("<a href=UserClServlet?flag=fenye&pageNow="+(pageNow!=1?pageNow-1:pageNow)+">��һҳ</a>");
  	 }
  	 //��ʾ������
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
  	 //��һҳ
  	 if(pageNow!=pageCount){
  	 out.println("<a href=UserClServlet?flag=fenye&pageNow="+(pageNow!=pageCount?pageNow+1:pageNow)+">��һҳ</a>");
  	 }
 
  	 %>
  	 </center>
  	  <hr><img src=imgs/welcome.gif  width="200px" height="50px"/>
  </body>
</html>

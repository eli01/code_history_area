<%@ page language="java" import="java.util.*,com.yourcompany.domin.Cat" pageEncoding="utf-8"%>
<%@ taglib prefix="bean"  uri="http://struts.apache.org/tags-bean"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <body>
    <h1>bean标签库的使用</h1><br> 
    <%
    	request.setAttribute("abc", "hello");
    	Cat cat=new Cat();
    	cat.setAge(5);
    	cat.setName("Tom");
    	request.setAttribute("cat1", cat);
     %> 
     <h1>输出普通字符串</h1>
     <bean:write name="abc" />
     <h1>输出domin 对象的 </h1><br/>
     <bean:write name="cat1" property="name"/>
     <h1>bean:message</h1><br/>
     <bean:message key="key1" arg0="john"/>
     <bean:message key="err1" arg0="用户名为空" arg1="密码错误"/>
     <h1>使用jsp标签完成对domin对象的创建和初始化</h1><br/>
     <jsp:useBean id="cat3" class="com.yourcompany.domin.Cat"></jsp:useBean>
     <jsp:setProperty name="cat3" value="Tom" property="name"/>
     <jsp:setProperty name="cat3" value="2" property="age"/>
     相当于<br/>
    &lt;%<br/>
     Cat cat3=new  Cat();
     cat2.setName("Tom");
     cat2.setAge(2);
      <br/>%&gt;
  </body>
</html>

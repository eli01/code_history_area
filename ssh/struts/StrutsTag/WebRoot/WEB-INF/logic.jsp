<%@ page language="java" import="java.util.*,com.yourcompany.domin.*" pageEncoding="utf-8"%>
<%@ taglib  prefix="logic"  uri="http://struts.apache.org/tags-logic"%>
<%@ taglib  prefix="bean"  uri="http://struts.apache.org/tags-bean"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <body> 
    <h1>logic标签的使用</h1><br>
    <%
    	Cat cat1=new Cat();
    	cat1.setName("alice");
    	cat1.setAge(2);
    	
    	Cat cat2=new Cat();
    	cat2.setName("banana");
    	cat2.setAge(4);
    	
    	Cat cat3=new Cat();
    	cat3.setName("Cake");
    	cat3.setAge(2);
    	ArrayList<Cat> al=new ArrayList<Cat>();
    	al.add(cat1);
    	al.add(cat2);
    	al.add(cat3);
    	request.setAttribute("arrayList", al);
     %>
     <h1>logic:iterate的使用：循环</h1><br/>
     <logic:iterate id="mycat" name="arrayList"><br/>
<!--      <bean:write name="mycat" property="name" />|| -->
<!--      <bean:write name="mycat" property="age" /><br/> -->
		${mycat.name } || ${mycat.age }<br/> 
     </logic:iterate>
     <h1>logic:empty标签：判空 </h1><br/>
     <logic:empty name="unexist" >
     unexist不再域中<br/>
     </logic:empty>
        <h1>logic:notempty标签：判非空 </h1><br/>
     <logic:notEmpty name="arrayList">
     arrayList存在<br/>
     </logic:notEmpty>
     
     <h1>循环判断大小(是否大于等于)</h1><br/>
     <logic:iterate id="temcat" name="arrayList">
     <logic:greaterEqual value="4" name="temcat" property="age">
     <bean:write name="temcat"  property="age"/>年龄大于或等于4
     </logic:greaterEqual>
     </logic:iterate>
  </body>
</html>

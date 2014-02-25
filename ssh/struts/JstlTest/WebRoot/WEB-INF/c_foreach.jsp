<%@ page language="java" import="java.util.*,com.nemo.domin.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
  <body>
    <%
    	ArrayList<Rat> al=new ArrayList<Rat>();
     	Rat rat=new Rat();
    	rat.setName("young jerry");
    	rat.setAge(1);
    	
    	Rat rat1=new Rat();
    	rat1.setName("adult jerry");
    	rat1.setAge(3);
    	
    	Rat rat2=new Rat();
    	rat2.setName("old jerry");
    	rat2.setAge(5);
    	
    	Rat rat3=new Rat();
    	rat3.setName("jerry");
    	rat3.setAge(10);
    	
    	al.add(rat);
    	al.add(rat1);
    	al.add(rat2);
    	al.add(rat3);
		request.setAttribute("aal", al);
	//用传统的做法输出ArrayList
		ArrayList<Rat> al2=(ArrayList<Rat>)request.getAttribute("aal");
		for(Rat r:al2){
			out.println(r.getName()+" "+r.getAge());
		}
     %> 
     <h1>c:foireach</h1>
     
     <c:forEach items="${aal }" var="rat">
     <c:out value="${rat.name }"/>
     <c:out value="${rat.age }"/>
     </c:forEach>
     
     <br/>循环输出1-10<br/>
     <c:forEach var="i" begin="1" end="10" >
     <c:out value="${i }"/>-->
     </c:forEach>
     
      <br/>循环输出0-10的偶数<br/>
      <c:forEach var="i" begin="0" end="10" step="2">
      <c:out value="${i }"/>-->
      </c:forEach>
      
      <h1>c:forTokens</h1>
      <c:forTokens items="aa,bb,cc,dd" delims=","  var="avalue" begin="0" end="3" step="2">
      ${avalue}
      </c:forTokens>
      
      <%
      Map map=new HashMap();
/*       map.put("aa", "拖瓦兹");
      map.put("bb", "斯托曼"); */
      map.put("aa",rat1);
      map.put("bb", rat2);
      request.setAttribute("linuxGuys",map);
       %>
       <c:forEach items="${linuxGuys }" var="linuxguy">
      <br/> key=${linuxguy.key } <br/>
       value=${linuxguy.value  } <br/>
       value=${linuxguy.value.name  } <br/>
       value=${linuxguy.value.age  } <br/>
       </c:forEach>
       
       <h1>判断集合是否为空</h1><br/>
       <c:if test="${!empty linuxGuys }">
      linuxGuys不为空！<br/>
       </c:if>
       
  </body>
</html>

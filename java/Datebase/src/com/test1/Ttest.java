package com.test1;


import java.sql.*;

public class Ttest {

 public static void main(String[] args) {
  Connection con=null;
  Statement stmt=null;
  ResultSet rs=null;
  try {
   Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
   con = DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433;DatabaseName=comp1","sa","truman");
//   Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");   
//   con = DriverManager.getConnection("jdbc:odbc:JDBCSQLDemo_JSPTest");
   stmt = con.createStatement();
   rs = stmt.executeQuery("select * from emp");
	while(rs.next())
	{
		String name=rs.getString(2);
		float sal=rs.getFloat(6);
		int deptno=rs.getInt(8);
		System.out.println(name+" "+sal+" "+deptno);
	}
   if(rs!=null)
    rs.close();
   if(stmt!=null)
    stmt.close();
   if(con!=null)
    con.close();
  } catch (Exception e) {
   e.printStackTrace();
  }finally{
   System.out.println("Game Over~");
  }
 }

}

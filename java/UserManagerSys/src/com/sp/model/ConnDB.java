package com.sp.model;
import java.sql.*;
public class ConnDB {
	private Connection ct=null;
	public Connection getConn(){
		
		try{
			//1.加载驱动
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			//2.得到连接
			ct=DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433;DatabaseName=spdb","sa","truman");			
		}catch(Exception e){
			e.printStackTrace();
		}	
		return ct;
	}

}

//使用dbInfo.propertes配置文件的情形 
package com.hsp.utils; 
 
import java.io.FileInputStream; 
import java.io.FileNotFoundException; 
import java.io.IOException; 
import java.sql.Connection; 
import java.sql.DriverManager; 
import java.sql.PreparedStatement; 
import java.sql.ResultSet; 
import java.sql.SQLException; 
import java.sql.Statement; 
import java.util.ArrayList;
import java.util.Properties; 

import javax.servlet.jsp.tagext.TryCatchFinally;

import java.io.InputStream;
 
public class SqlHelper { 
//定义三个变量 
private static Connection ct=null; 
private static PreparedStatement ps=null; 
private static ResultSet rs=null; 
 
//连接数据库的用户名、驱动、实例、密码、url 
private static FileInputStream fis=null; 
private static String username; 
private static String password; 
private static String driver; 
private static String url; 
//在实际开发中，我们常常把这些变量定义在外部文件中，使用时读入这些配置信息java.util.Properties 
 
public static Connection getCt() { 
return ct; 
} 
 
public static PreparedStatement getPs() { 
return ps; 
} 
 
public static ResultSet getRs() { 
return rs; 
} 
 
//使用静态块加载驱动 
static{ 
try { 
//这里重配置文件读取数据初始化连接数据库信息 
Properties pp=new Properties(); 
//fis=new FileInputStream("/home/nemo/Workspaces/MyEclipse Bling Edition 10/StrutsLogin/src/com/hsp/utils/mysqlConn.properties"); //必须使用绝对路径
InputStream in=SqlHelper.class.getResourceAsStream("/com/hsp/utils/mysqlConn.properties");
pp.load(in); 
username=(String)pp.get("username"); 
driver=(String)pp.get("driver"); 
password=(String)pp.get("password"); 
url=(String)pp.get("url"); 
Class.forName(driver); 
//new oracle.jdbc.driver.OracleDriver();
 
} catch (ClassNotFoundException e) { 
// TODO Auto-generated catch block 
e.printStackTrace(); 
} catch (FileNotFoundException e) { 
// TODO Auto-generated catch block 
e.printStackTrace(); 
} catch (IOException e) { 
// TODO Auto-generated catch block 
e.printStackTrace(); 
}finally{ 
try { 
if(fis!=null) fis.close(); 
} catch (IOException e) { 
// TODO Auto-generated catch block 
e.printStackTrace(); 
} 
fis=null; 
} 
} 
 
//写一个方法完成查询任务 
//sql表示要执行的语句 
public static ResultSet executeQuery(String sql,String[] paras){ 
	try { 
			ct=DriverManager.getConnection(url,username,password); 
			ps=ct.prepareStatement(sql); 
			//根据实际情况我们对sql？赋值 
			if(paras!=null){ 
				for(int i=0;i<paras.length;i++){ 
					ps.setString(i+1,paras[i]); 
				} 
			} 
			rs=ps.executeQuery(); 
		} catch (SQLException e) { 
			// TODO Auto-generated catch block 
			e.printStackTrace(); 
			//抛出运行异常 
			throw new RuntimeException(e.getMessage()); 
		}finally{ 
		//close(rs,ps,ct); 
		} 
	return rs;   
} 
//调用executeQuery()返回ArrayList
public static ArrayList<ArrayList> query(String sql,String[] paras){
	ArrayList<ArrayList> aal=new ArrayList<ArrayList>();
	
	ResultSet rs=executeQuery(sql, paras);
	boolean b=true;
	try {
		while(rs.next()){
			ArrayList<String> al=new ArrayList<String>();
			int i=0;
			while(b){
				if(rs.isLast()) b=false;
				i++;
				al.add(rs.getString(i));
			}
			aal.add(al);
		}
	} catch (Exception e) {
		System.out.println("处理数据库数据异常！");
	}
	return aal;

}
//统一的crud操作 
public static void executeUpdate(String sql,String[] paras){ 
try{ 
ct=DriverManager.getConnection(url,username,password); 
ps=ct.prepareStatement(sql); 
if(paras!=null){ 
for(int i=0;i<paras.length;i++){ 
ps.setString(i+1, paras[i]); 
} 
} 
ps.executeUpdate(); 
}catch(Exception e){ 
e.printStackTrace(); 
throw new RuntimeException(e.getMessage()); 
}finally{ 
close(rs,ps,ct); 
} 
} 
 
//关闭资源的函数 
public static void close(ResultSet rs,Statement ps,Connection ct){	  
try { 
if(rs!=null) rs.close(); 
if(ps!=null) ps.close(); 
if(ct!=null) ct.close(); 
} catch (SQLException e) { 
// TODO Auto-generated catch block 
e.printStackTrace(); 
} 
} 
 
} 
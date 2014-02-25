package com.yourcompany.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;
/*
 *一： 功能简介：
 * 1.crud操作
 * 2.翻页
 *
 *二： 时间：2013/7/16
 * 
 * 三：作者：孟庆申*/
public class SqlHelper {
	/*定义操作数据的三大对象*/
	private static Connection ct=null;
	private static PreparedStatement ps=null;
	private static ResultSet rs=null;
	
	/*定义连接数据库的四个参数：用户名/密码/驱动/数据库文件的地址*/
	private static String username = "";
	private static String passwd = "";
	private static String driver = "";
	private static String url = "";
	private static InputStream fis = null;
	
	/*在静态块中完成连接数据库的初始化过程*/
	static{
		Properties pp=new Properties();
		try {
			/*用反射的方式获得properties文件的输入流*/
			fis=SqlHelper.class.getClassLoader().getResourceAsStream("/com/yourcompany/utils/mysqlConn.properties");
			//fis=new FileInputStream("/home/nemo/Workspaces/MyEclipse Bling Edition 10/StrutsLogin/src/com/hsp/utils/mysqlConn.properties"); //必须使用绝对路径
			//InputStream in=SqlHelper.class.getResourceAsStream("/com/hsp/utils/mysqlConn.properties");
			pp.load(fis);
			username = pp.getProperty("dbUserName");
			passwd = pp.getProperty("dbPassword");
			driver = pp.getProperty("dbDriver");
			url = pp.getProperty("dbUrl");
			/*1.加在驱动*/
			Class.forName(driver);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				/*关闭输入流*/
				fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	/*2.封装获得连接的方法*/
	public static Connection getConnection(){
		try {
			ct = DriverManager.getConnection(url, username, passwd);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ct;
	}
	/*3.封装关闭数据库资源的方法*/
	public static void close(ResultSet rs,PreparedStatement ps,Connection ct){
		if(rs!=null){
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			rs=null;	
		}
		
		if(ps!=null){
			try {
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			ps=null;
		}
	
		if(ct!=null){
			try {
				ct.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			ct=null;
		}
	
	}
	/*传入表名返回该表的记录数*/
	public static int getPageCount(String sql){
		int rowCount = 0;
		ct = getConnection();
		try {
			ps = ct.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				rowCount = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			close(rs,ps,ct);
		}
		return rowCount;
	}
	/*传入sql语句 返回查询结果封装成的对象（每一行表示一个对象）集合*/
	public static ArrayList executeQuery(String sql,String[] paras){
		ct = getConnection();
		ArrayList al=new ArrayList();
		try {
			ps = ct.prepareStatement(sql);
			if(paras != null){
				for(int i=0;i<paras.length;i++){
					ps.setString(i+1,paras[i]);
				}
			}
			rs=ps.executeQuery();
			/*获得结果集元数据对象*/
			ResultSetMetaData rsmd = rs.getMetaData();
			/*获得结果集列数*/
			int column = rsmd.getColumnCount();
			while(rs.next()){
				Object[] ob = new Object[column];
				for(int i=1;i<=column;i++){
					ob[i-1] = rs.getObject(i);
				}
				al.add(ob);
			}
		
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			close(rs,ps,ct);
		}
		return al;
	}
	
	/*执行增、删、改的方法*/
	public static void executeUpdate(String sql ,String[] paras){
		ct = getConnection();
		try {
			ps = ct.prepareStatement(sql);
			if(paras!=null){
				for(int i=0;i<paras.length;i++){
					ps.setString(i+1, paras[i]);
				}
				ps.execute();
			}
		} catch (Exception e) {			
			throw new RuntimeException(e.getMessage());			
		}finally{
			close(rs,ps,ct);
		}
	}
	/*得到行数*/
	public static int getRowCount(String sql,String[] paras){
		int rowCount = 0;
		ct = getConnection();
		try {
			ps = ct.prepareStatement(sql);
			if(paras!=null){
				for(int i=0;i<paras.length;i++){
					ps.setString(i+1, paras[i]);
				}
			}
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				rowCount = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			close(rs, ps, ct);
		}
		return rowCount;
	}
}

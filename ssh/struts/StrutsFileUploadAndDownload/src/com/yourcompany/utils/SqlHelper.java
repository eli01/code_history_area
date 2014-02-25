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
 *һ�� ���ܼ�飺
 * 1.crud����
 * 2.��ҳ
 *
 *���� ʱ�䣺2013/7/16
 * 
 * �������ߣ�������*/
public class SqlHelper {
	/*����������ݵ��������*/
	private static Connection ct=null;
	private static PreparedStatement ps=null;
	private static ResultSet rs=null;
	
	/*�����������ݿ���ĸ��������û���/����/����/���ݿ��ļ��ĵ�ַ*/
	private static String username = "";
	private static String passwd = "";
	private static String driver = "";
	private static String url = "";
	private static InputStream fis = null;
	
	/*�ھ�̬��������������ݿ�ĳ�ʼ������*/
	static{
		Properties pp=new Properties();
		try {
			/*�÷���ķ�ʽ���properties�ļ���������*/
			fis=SqlHelper.class.getClassLoader().getResourceAsStream("/com/yourcompany/utils/mysqlConn.properties");
			//fis=new FileInputStream("/home/nemo/Workspaces/MyEclipse Bling Edition 10/StrutsLogin/src/com/hsp/utils/mysqlConn.properties"); //����ʹ�þ���·��
			//InputStream in=SqlHelper.class.getResourceAsStream("/com/hsp/utils/mysqlConn.properties");
			pp.load(fis);
			username = pp.getProperty("dbUserName");
			passwd = pp.getProperty("dbPassword");
			driver = pp.getProperty("dbDriver");
			url = pp.getProperty("dbUrl");
			/*1.��������*/
			Class.forName(driver);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				/*�ر�������*/
				fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	/*2.��װ������ӵķ���*/
	public static Connection getConnection(){
		try {
			ct = DriverManager.getConnection(url, username, passwd);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ct;
	}
	/*3.��װ�ر����ݿ���Դ�ķ���*/
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
	/*����������ظñ�ļ�¼��*/
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
	/*����sql��� ���ز�ѯ�����װ�ɵĶ���ÿһ�б�ʾһ�����󣩼���*/
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
			/*��ý����Ԫ���ݶ���*/
			ResultSetMetaData rsmd = rs.getMetaData();
			/*��ý��������*/
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
	
	/*ִ������ɾ���ĵķ���*/
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
	/*�õ�����*/
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

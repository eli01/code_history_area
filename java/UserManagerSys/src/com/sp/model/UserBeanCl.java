package com.sp.model;
import java.sql.*;
import java.util.*;
public class UserBeanCl {
	//业务逻辑
	private Connection ct=null;
	private PreparedStatement ps=null;
	private ResultSet rs=null;
	private int pageCount=0;//共有几页（计算） 
	//返回pageCount
	//分页显示
	public ArrayList<UserBean> getResultByPage(int pageNow,int pageSize){
		ArrayList<UserBean> al=new ArrayList<UserBean>();//装UserBean的实例
		try{
			int rowCount=0;//共有几条记录
		
			//得到rowCount
			ConnDB cd=new ConnDB();
			ct=cd.getConn();
			ps=ct.prepareStatement("select count(*) from users");
			rs=ps.executeQuery();//获得一个结果集
			if(rs.next()){
	
				rowCount=rs.getInt(1);
			}
			//计算PageCount
			if(rowCount%pageSize==0){
				pageCount=rowCount/pageSize;
			}else{
				pageCount=rowCount/pageSize+1;
			}
			
			String sqlFenye="select top "+pageSize+" * from users where userId not in(select top "+pageSize*(pageNow-1)+" userId from users)";
			ps=ct.prepareStatement(sqlFenye);
	
			rs=ps.executeQuery();//获得一个结果集
			while(rs.next()){
				//将rs中的每条记录封装到UserBean ub
				UserBean ub=new UserBean();
				ub.setUserId(rs.getInt(1));
				ub.setUsername(rs.getString(2));
				ub.setPasswd(rs.getString(3));
				ub.setEmail(rs.getString(4));
				ub.setGrade(rs.getInt(5));
				//ub.getMyPic(rs.getString(6));
				//将ub放入到集合中
				al.add(ub);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			this.close();
		}
		return al;
	}
	public int getPageCount(){
		
		return this.pageCount;	
	}
	//验证用户
	public boolean checkUser(String u,String p){
		boolean b=false;
		try{
			//得到连接n
			ct=new ConnDB().getConn();
			ps=ct.prepareStatement("select top 1 passwd from users where username=?");
			ps.setString(1,u);
			rs=ps.executeQuery();
			if(rs.next()){
				String dbPasswd=rs.getString(1);
				if(dbPasswd.equals(p)){
					b=true;
				}
			}
				
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			this.close();
		}
		return b;
	}
	//写一个关闭数据库资源的函数
	public void close(){
		try{
			//数据库的连接是有限的要及时关闭注意顺序
			if(rs!=null)rs.close();
			if(ps!=null)ps.close();
			if(ct!=null)ct.close();
		}catch(Exception e){
			e.printStackTrace();
		}		
	}
	//删除用户
	public boolean delUser(String id)
	{
		boolean b=false;
		try{
			//得到连接
			ConnDB cd=new ConnDB();
			ct=cd.getConn();
			String sql="delete from users where userId='"+id+"'";
			ps=ct.prepareStatement(sql);
			int num=ps.executeUpdate();	
			if(num==1){
				b=true;
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			this.close();
		}
		return b;
	}
	//修改用户
	public boolean updateUser(String id,String passwd,String email,String grade)
	{
		boolean b=false;
		try{
			//得到连接
			ConnDB cd=new ConnDB();
			ct=cd.getConn();
			String sql="update users set passwd='"+passwd+"',email='"+email+"',grade='"+grade+"' where userId='"+id+"'";
			
			ps=ct.prepareStatement(sql);
			int num=ps.executeUpdate();	
			if(num==1){
				b=true;
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			this.close();
		}
		return b;
	}
	
	
	//添加用户
	public boolean addUser(String name,String passwd,String email,String grade)
	{
		boolean b=false;
		try{
			//得到连接
			ConnDB cd=new ConnDB();
			ct=cd.getConn();
			String sql="insert into users (username,passwd,email,grade)values('"+name+"','"+passwd+"','"+email+"','"+grade+"')";
			//System.out.println(sql);
			ps=ct.prepareStatement(sql);
		
			int num=ps.executeUpdate();	
			//System.out.println(num);
			if(num==1){
				b=true;
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			this.close();
		}
		return b;
	}

}

package com.sp.model;
import java.sql.*;
import java.util.*;
public class UserBeanCl {
	//ҵ���߼�
	private Connection ct=null;
	private PreparedStatement ps=null;
	private ResultSet rs=null;
	private int pageCount=0;//���м�ҳ�����㣩 
	//����pageCount
	//��ҳ��ʾ
	public ArrayList<UserBean> getResultByPage(int pageNow,int pageSize){
		ArrayList<UserBean> al=new ArrayList<UserBean>();//װUserBean��ʵ��
		try{
			int rowCount=0;//���м�����¼
		
			//�õ�rowCount
			ConnDB cd=new ConnDB();
			ct=cd.getConn();
			ps=ct.prepareStatement("select count(*) from users");
			rs=ps.executeQuery();//���һ�������
			if(rs.next()){
	
				rowCount=rs.getInt(1);
			}
			//����PageCount
			if(rowCount%pageSize==0){
				pageCount=rowCount/pageSize;
			}else{
				pageCount=rowCount/pageSize+1;
			}
			
			String sqlFenye="select top "+pageSize+" * from users where userId not in(select top "+pageSize*(pageNow-1)+" userId from users)";
			ps=ct.prepareStatement(sqlFenye);
	
			rs=ps.executeQuery();//���һ�������
			while(rs.next()){
				//��rs�е�ÿ����¼��װ��UserBean ub
				UserBean ub=new UserBean();
				ub.setUserId(rs.getInt(1));
				ub.setUsername(rs.getString(2));
				ub.setPasswd(rs.getString(3));
				ub.setEmail(rs.getString(4));
				ub.setGrade(rs.getInt(5));
				//ub.getMyPic(rs.getString(6));
				//��ub���뵽������
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
	//��֤�û�
	public boolean checkUser(String u,String p){
		boolean b=false;
		try{
			//�õ�����n
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
	//дһ���ر����ݿ���Դ�ĺ���
	public void close(){
		try{
			//���ݿ�����������޵�Ҫ��ʱ�ر�ע��˳��
			if(rs!=null)rs.close();
			if(ps!=null)ps.close();
			if(ct!=null)ct.close();
		}catch(Exception e){
			e.printStackTrace();
		}		
	}
	//ɾ���û�
	public boolean delUser(String id)
	{
		boolean b=false;
		try{
			//�õ�����
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
	//�޸��û�
	public boolean updateUser(String id,String passwd,String email,String grade)
	{
		boolean b=false;
		try{
			//�õ�����
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
	
	
	//����û�
	public boolean addUser(String name,String passwd,String email,String grade)
	{
		boolean b=false;
		try{
			//�õ�����
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

/**
 * preparedStatementʹ��crud
 * 1.prepared�������ִ��Ч�ʣ�Ԥ���빦�ܣ�
 * 2.���Է�ֹsqlע�룬��Ҫ���ã���ֵ�ķ�ʽ
 */
package com.test1;
import java.sql.*;
public class Test2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//������Ҫ�Ķ���
	
		PreparedStatement ps=null;
		ResultSet rs=null;
		Connection ct=null;

		try{
			//1.��������
//			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
//			//2.�õ����ӣ�ָ�����ӵ��Ǹ�����Դ���û���������
//			//���ѡ�����windows.nt��֤������Ҫ��sa��,"truman"
//			ct=DriverManager.getConnection("jdbc:odbc:mytest","sa","truman");
//			//3.����Statement����preparedStatement[����]
//			//Statement�ô���Ҫ�Ƿ���sql���
//			sm=ct.createStatement();
			//��������
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			//�õ�����
			ct=DriverManager.getConnection("jdbc:odbc:mytest","sa","truman");
			//����ps
//			sm=ct.createStatement();
//			rs=sm.executeQuery("select *from dept");
//			ps=ct.prepareStatement("select * from dept where deptno=? and loc=?");
//			//���Ը�?�Ÿ���
//			ps.setInt(1,10);
//			ps.setString(2,"new york");
//			rs=ps.executeQuery();
//			//System.out.println("���Ϊ��");
//			while(rs.next())
//			{
//				System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3));
//			}
			ps=ct.prepareStatement("insert into dept values(?,?,?)");
			ps.setInt(1,50);
			ps.setString(2, "��ȫ��");
			ps.setString(3,"����");
			int i=ps.executeUpdate();
			if(i==1)
			{
				System.out.println("���������ɣ�");
			}else{
				System.out.println("error!");
			}
			//System.out.println("��������ϣ�");
		}catch(Exception e){
			e.printStackTrace();
			}finally{
				try{ 
					//System.out.println("������йرղ�����");
					if(rs!=null)
					{
						//System.out.println("�ر�rs");
						rs.close();
					}	
					if(ps!=null)
					{
						ps.close();						
					}
					if(ct!=null)
					{
						ct.close();
					}
				}catch(Exception e){
					e.printStackTrace();
			}
	}
	}
}


package com.test1;
import java.sql.*;
public class gdsa {

	/**
	 * @param args
	 */

	//*m=n;
	public static void main(String[] args) {
		PreparedStatement ps=null;
		Connection con=null;
		ResultSet rs=null;
		try{
			  Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			  // con = DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433;DatabaseName=comp1","sa","truman");
			   con = DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433;DatabaseName=comp1","sa","truman");
			   //1.��������
			///Class.forName("com.microsoft.sqlsever.jdbc.SQLSeverDriver");
			//2.�õ�����
			
			ps=con.prepareStatement("select * from emp");
			//��������ӡ�ɾ�����޸�executeUpdate(),����ǲ�ѯexecuteQuery()
			rs=ps.executeQuery();
			//ѭ��ȡ����Ա�����֣���Ա��нˮ�����ŵı��
			while(rs.next())
			{
				String name=rs.getString(2);
				float sal=rs.getFloat(6);
				int deptno=rs.getInt(8);
				System.out.println(name+" "+sal+" "+deptno);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{ 
			System.out.println("������ɣ�");
		}
	}

}

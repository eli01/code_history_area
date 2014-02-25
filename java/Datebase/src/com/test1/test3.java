/**
 * 在java中如何使用ddl语句
 */
package com.test1;
import java.sql.*;
public class test3 {

	/**
	 * @param args
	 */
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PreparedStatement ps=null;
		Connection ct=null;
		ResultSet rs=null;
		try {
			//Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");//驱动的名称
			//ct=DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433;DatebaseName=comp1","sa","truman");
			ct=DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433;DatabaseName=comp1","sa","truman");
			  // con = DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433;DatabaseName=comp1","sa","truman");
			
		
			ps=ct.prepareStatement("");
			rs=ps.executeQuery();
			//循环取出雇员的名字，雇员的薪水，部门的编号
			while(rs.next())
			{
				String name=rs.getString(2);
				float sal=rs.getFloat(6);
				int deptno=rs.getInt(8);
				System.out.println(name+" "+sal+" "+deptno);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				if(ps!=null)
				{
					ps.close();
				}
				if(ct!=null)
				{
					ct.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}

}


//package com.test1;
//import java.sql.*;
//public class test3 {
//
//	/**
//	 * @param args
//	 */
//
//	//*m=n;
//	public static void main(String[] args) {
//		PreparedStatement ps=null;
//		Connection con=null;
//		ResultSet rs=null;
//		try{
//			  Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//			  // con = DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433;DatabaseName=comp1","sa","truman");
//			   con = DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433;DatabaseName=comp1","sa","truman");
//			   //1.加载驱动
//			///Class.forName("com.microsoft.sqlsever.jdbc.SQLSeverDriver");
//			//2.得到连接
//			
//			ps=con.prepareStatement("select * from emp");
//			//如果是增加、删除、修改executeUpdate(),如果是查询executeQuery()
//			 rs=ps.executeQuery();
//			//循环取出雇员的名字，雇员的薪水，部门的编号
//			while(rs.next())
//			{
//				String name=rs.getString(2);
//				float sal=rs.getFloat(6);
//				int deptno=rs.getInt(8);
//				System.out.println(name+" "+sal+" "+deptno);
//			}
//		}catch(Exception e){
//			e.printStackTrace();
//		}finally{ 
//			System.out.println("任务完成！");
//		}
//	}
//
//}
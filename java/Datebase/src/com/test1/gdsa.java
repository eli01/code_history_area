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
			   //1.加载驱动
			///Class.forName("com.microsoft.sqlsever.jdbc.SQLSeverDriver");
			//2.得到连接
			
			ps=con.prepareStatement("select * from emp");
			//如果是增加、删除、修改executeUpdate(),如果是查询executeQuery()
			rs=ps.executeQuery();
			//循环取出雇员的名字，雇员的薪水，部门的编号
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
			System.out.println("任务完成！");
		}
	}

}

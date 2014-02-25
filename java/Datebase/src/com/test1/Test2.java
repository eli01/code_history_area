/**
 * preparedStatement使用crud
 * 1.prepared可以提高执行效率（预编译功能）
 * 2.可以防止sql注入，但要求用？赋值的方式
 */
package com.test1;
import java.sql.*;
public class Test2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//定义需要的对象
	
		PreparedStatement ps=null;
		ResultSet rs=null;
		Connection ct=null;

		try{
			//1.加载驱动
//			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
//			//2.得到链接，指定链接到那个数据源，用户名和密码
//			//如果选择的是windows.nt验证，则不需要“sa”,"truman"
//			ct=DriverManager.getConnection("jdbc:odbc:mytest","sa","truman");
//			//3.创建Statement或者preparedStatement[区别]
//			//Statement用处主要是发送sql语句
//			sm=ct.createStatement();
			//加载驱动
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			//得到链接
			ct=DriverManager.getConnection("jdbc:odbc:mytest","sa","truman");
			//创建ps
//			sm=ct.createStatement();
//			rs=sm.executeQuery("select *from dept");
//			ps=ct.prepareStatement("select * from dept where deptno=? and loc=?");
//			//可以给?号复制
//			ps.setInt(1,10);
//			ps.setString(2,"new york");
//			rs=ps.executeQuery();
//			//System.out.println("结果为：");
//			while(rs.next())
//			{
//				System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3));
//			}
			ps=ct.prepareStatement("insert into dept values(?,?,?)");
			ps.setInt(1,50);
			ps.setString(2, "安全部");
			ps.setString(3,"北京");
			int i=ps.executeUpdate();
			if(i==1)
			{
				System.out.println("插入操作完成！");
			}else{
				System.out.println("error!");
			}
			//System.out.println("结果输出完毕！");
		}catch(Exception e){
			e.printStackTrace();
			}finally{
				try{ 
					//System.out.println("下面进行关闭操作！");
					if(rs!=null)
					{
						//System.out.println("关闭rs");
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


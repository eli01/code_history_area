/*
 * 演示jdbc-odbc桥连接方式操作数据库
 * 1.配置数据源
 * 2.在程序中连接数据源
 */
 package com.test1;

import java.sql.*;


public class Test1 {

	/**
	 * @param args
	 */
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection ct=null;
		Statement sm=null;
		try{
			//1.加载驱动
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			//2.得到链接，指定链接到那个数据源，用户名和密码
			//如果选择的是windows.nt验证，则不需要“sa”,"truman"
			ct=DriverManager.getConnection("jdbc:odbc:mytest","sa","truman");
			//3.创建Statement或者preparedStatement[区别]
			//Statement用处主要是发送sql语句
			sm=ct.createStatement();
			//4.执行（crud，创建数据库，备份数据库，删除数据）
			//int i=sm.executeUpdate("insert into dept values('50','保安部','西永')");//添加一条数据到dept表
			//int i=sm.executeUpdate("delete from dept where deptno='50'");
//			int i=sm.executeUpdate("update dept set loc='北京' where deptno=40");
//			if(i==1)
//			{
//				System.out.println("删除操作完成！");
//			}else{
//				System.out.println("删除error");
//			}
			//查询，显示所有的部门号
			//ResultSet结果集
			ResultSet rs=sm.executeQuery("select *from dept");
			//因为rs指向结果集的前一行
			//循环取出
			while(rs.next())
			{
				int deptno=rs.getInt(1);
				String dname=rs.getString(2);
				String loc=rs.getString(3);
				System.out.println(deptno+" "+dname+" "+loc);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			//关闭资源
			//谁先打开，谁后关闭
			try{
				//为了程序更健壮
				if(sm!=null)
				{
					sm.close();
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

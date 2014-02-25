/**
 * 这是一个对数据库进行操作的类
 */
package StudentsManager2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SqlHelper {
	//定义操作数据库需要的变量和函数
	PreparedStatement ps=null;
	Connection ct=null;
	ResultSet rs=null;
	String url="jdbc:sqlserver://127.0.0.1:1433;databaseName=stuman";
	String user="sa";
	String passwd="truman";
	String driver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
	
	public ResultSet queryExecute(String sql)//sql语句不带参数设计的情况
	{
		try{
			//1.加载驱动
			Class.forName(driver);
			//2.得到连接
			ct=DriverManager.getConnection(url,user,passwd);
			//3.创建ps
			ps=ct.prepareStatement(sql);
			//System.out.println("是否创建连接43");
			
			rs=ps.executeQuery();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			//关闭资源
		}
		return rs;
	}
	
	//查询数据库的操作
	public ResultSet queryExecute(String sql,String[] paras)//带有参数设计的情况
	{
		try{
			//1.加载驱动
			Class.forName(driver);
			//2.得到连接
			ct=DriverManager.getConnection(url,user,passwd);
			//3.创建ps
			ps=ct.prepareStatement(sql);
			//System.out.println("是否创建连接43");
			//给ps的问号赋值
			for(int i=0;i<paras.length;i++)//一开始写i=1，报错：未为1设置参数值，从昨天调到现在！那个郁闷！深刻检讨！
			{
				ps.setString(i+1, paras[i]);
				 //System.out.println(paras[i]);
			}
			rs=ps.executeQuery();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			//关闭资源
		}
		return rs;
	}
	
	//关闭数据库资源
	public void close()
	{
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
			// System.out.println("StuModel 72");
	
			e.printStackTrace();
		}
	}
	
	//把增删改放在一起
	public boolean updExecute(String sql,String []paras)
	{
		boolean b=true;
		try{
			//1.加载驱动
			Class.forName(driver);
			//2.得到连接
			ct=DriverManager.getConnection(url,user,passwd);
			//3.创建ps
			ps=ct.prepareStatement(sql);
			//System.out.println("是否创建连接43");
			//给ps的问号赋值
			for(int i=0;i<paras.length;i++)//一开始写i=1，报错：未为1设置参数值，从昨天调到现在！那个郁闷！深刻检讨！
			{
				ps.setString(i+1, paras[i]);
				 //System.out.println(paras[i]);
			}
			
			//4.执行操作
			//ps.executeUpdate();
			if(ps.executeUpdate()!= 1)
				{
				    //System.out.println("StuModel 50");
					b=false;
				}
		}catch(Exception e){
			 //System.out.println("StuModel 54");
			b=false;
			e.printStackTrace();
			
		}finally{
			this.close();
		}
		return b;
	}
}

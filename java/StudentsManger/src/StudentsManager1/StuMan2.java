/**
 * 从数据库中取出学生信息
 */
package StudentsManager1;
import javax.swing.*;

import java.awt.*;
import java.util.*;
import java.sql.*;
public class StuMan2 extends JFrame{

	//rowData用来存放行数据
	//columnNames存放列名
	Vector rowData,columnNames;
	JTable jt=null;
	JScrollPane jsp=null;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StuMan2 sm2=new StuMan2();
	}
	//构造函数
		public StuMan2()
		{
			columnNames=new Vector();//设置列名
			columnNames.add("学号");
			columnNames.add("名字");
			columnNames.add("性别");
			columnNames.add("年龄");
			columnNames.add("籍贯");
			columnNames.add("系别");
			
			rowData=new Vector();
			//从数据库取出数据
			PreparedStatement ps=null;
			Connection ct=null;
			ResultSet rs=null;
			try {
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				ct=DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433;databaseName=stuman","sa","truman");
				ps=ct.prepareStatement("select*from stu");
				rs=ps.executeQuery();
				
				while(rs.next())
				{
					Vector hang=new Vector();
					hang.add(rs.getString(1));
					hang.add(rs.getString(2));
					hang.add(rs.getString(3));
					hang.add(rs.getInt(4));
					hang.add(rs.getString(5));
					hang.add(rs.getString(6));
					rowData.add(hang);
				}
			
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				
					try {
						if(rs!=null)
						{
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
					
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			
//			Vector hang=new Vector();
//			hang.add("sp001");
//			hang.add("孙悟空");
//			hang.add("男");
//			hang.add("500");
//			hang.add("花果山");
//			hang.add("少林");
			
			
			jt=new JTable(rowData,columnNames);//初始化JTable
			jsp=new JScrollPane(jt);
			//将jsp放入jframe
			this.add(jsp);//默认加到面板的中间
			this.setSize(400,300);
			this.setLocation(400,400);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.setVisible(true);
		}

}

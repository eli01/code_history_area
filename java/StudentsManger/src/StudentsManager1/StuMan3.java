/**
 * model1模式
 */
package StudentsManager1;
import javax.swing.*;

import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class StuMan3 extends JFrame implements ActionListener{

	//定义一一些组件
	JPanel jp1,jp2;
	JButton jb1,jb2,jb3,jb4;
	JLabel jl;
	JTextField jtf;
	JTable jt;
	JScrollPane jsp;
	StuModel smo;
	//Vector rowData,columnNames;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StuMan3 sm3=new StuMan3();
	}
	//构造函数
	public StuMan3()
	{
		//北边
		jp1=new JPanel();
		jl=new JLabel("请输入学号");
		jtf=new JTextField(10);
		jb1=new JButton("查询");
		jb1.addActionListener(this);//注册监听
		jp1.add(jl);
		jp1.add(jtf);
		jp1.add(jb1);
		//南边
		jp2=new JPanel();
		jb2=new JButton("添加");
		jb2.addActionListener(this);
		jb3=new JButton("修改");
		jb3.addActionListener(this);
		jb4=new JButton("删除");
		jb4.addActionListener(this);//注册监听
		jp2.add(jb2);
		jp2.add(jb3);
		jp2.add(jb4);
		//中间
		//创建一个数据模型对象
		smo=new StuModel();
		jt=new JTable(smo);
		//jt=new JTable(rowData,columnNames);//初始化JTable
		jsp=new JScrollPane(jt);
		//将jsp放入jframe
		this.add(jp1,"North");
		this.add(jp2,"South");
		this.add(jsp);//默认加到面板的中间
		this.setSize(400,300);
		this.setLocation(400,400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		//判断那个按钮被点击
		PreparedStatement ps=null;
		Connection ct=null;
		if(e.getSource()==jb1)
		{
			System.out.println("执行查询命令！");
			//得到用户名
			String name=this.jtf.getText().trim();//过滤空字符串
			String sql="select*from stu where stuId='"+name+"'";//得到sql语句
			//构建新的数据模型类，并更新
			smo=new StuModel(sql);
			//更新JTable
			jt.setModel(smo);
			
		}else if(e.getSource()==jb2)
		{
			StuAddDialog sad=new StuAddDialog(this,"添加窗口",true);
			//重新获得新的数据模型
			smo=new StuModel();
			//更新JTabel
			jt.setModel(smo);
		}else if(e.getSource()==jb3)
		{
			//说明用户想修改学生信息
			int rowNum=this.jt.getSelectedRow();//获得选中的行数
			if(rowNum==-1)
			{
				JOptionPane.showMessageDialog(this, "请选择一行");
				return;
			}
			//显示修改对话框
			new StuUpdate(this,"修改学生信息",true,smo,rowNum);
			//构建新的数据模型类，并更新
			smo=new StuModel();
			//更新JTable
			jt.setModel(smo);
		}
		else if(e.getSource()==jb4)
		{
			//说明用户希望删除记录
			//1.得到学生的ID
			int rowNum=this.jt.getSelectedRow();//返回用户点中的行
			//如果用户一个都没点则返回-1
			if(rowNum==-1)
			{
				//提示
				JOptionPane.showMessageDialog(this, "请选择一行");
				return;
			}
			//得到学生编号
			String stuId=(String) smo.getValueAt(rowNum,0);
			//System.out.println("得到将要删除的学生的编号："+stuId);
			//连接数据库完成删除任务
			try{
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				ct=DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433;databaseName=stuman","sa","truman");
				//Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				//ct=DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433;databaseName=stuman","sa","truman");
				ps=ct.prepareStatement("delete from stu where stuId=?");
				ps.setString(1, stuId);
				ps.executeUpdate();
			}catch(Exception ee){
				ee.printStackTrace();
			}finally{
				try{
					if(ps!=null)//为了程序的健壮性
					{
						ps.close();
					}
					if(ct!=null)
					{
						ct.close();
					}
				}catch(Exception e3){
					e3.printStackTrace();
				}
			}
			//重新获得新的数据模型
			smo=new StuModel();
			//更新JTabel
			jt.setModel(smo);
		}
	}
}


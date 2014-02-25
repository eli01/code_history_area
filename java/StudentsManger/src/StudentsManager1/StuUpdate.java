//添加学生的对话框
package StudentsManager1;
import java.awt.*;
//import java.awt.event;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.*;
import java.sql.*;

public class StuUpdate extends JDialog implements ActionListener{
	JLabel jl1,jl2,jl3,jl4,jl5,jl6;
	JButton jb1,jb2;
	JTextField jtf1,jtf2,jtf3,jtf4,jtf5,jtf6;
	JPanel jp1,jp2,jp3;
	//Frame父窗口、String窗口名、窗口模式
	public StuUpdate (Frame owner,String title,boolean modal,StuModel sm,int rowNums)
	{
		super(owner,title,modal);//调用父类构造方法初始化窗口模态
		//初始化面板的各个组件
		jl1=new JLabel("stuId");
		jl2=new JLabel("stuName");
		jl3=new JLabel("stuSex");
		jl4=new JLabel("stuAge");
		jl5=new JLabel("stuJg");
		jl6=new JLabel("stuDept");
		
		jtf1=new JTextField();
		jtf2=new JTextField();
		jtf3=new JTextField();
		jtf4=new JTextField();
		jtf5=new JTextField();
		jtf6=new JTextField();
		//初始化文本框
		jtf1.setText((String)sm.getValueAt(rowNums,0));//将object转为String
		jtf1.setEditable(false);//主键禁止修改
		jtf2.setText((String)sm.getValueAt(rowNums,1));
		jtf3.setText((String)sm.getValueAt(rowNums,2));
		//jtf4.setText((String)sm.getValueAt(rowNums,3));
		jtf4.setText(sm.getValueAt(rowNums,3).toString());
		jtf5.setText((String)sm.getValueAt(rowNums,4));
		jtf6.setText((String)sm.getValueAt(rowNums,5));
		
		jp1=new JPanel();
		jp2=new JPanel();
		jp3=new JPanel();
		
		jb1=new JButton("修改");
		jb2=new JButton("取消");
		
		//设置布局管理器,jp3默认为流式布局
		jp1.setLayout(new GridLayout(6,1));
		jp2.setLayout(new GridLayout(6,1));
		
		
		//添加组件
		jp1.add(jl1);
		jp1.add(jl2);
		jp1.add(jl3);
		jp1.add(jl4);
		jp1.add(jl5);
		jp1.add(jl6);
		
		jp2.add(jtf1);
		jp2.add(jtf2);
		jp2.add(jtf3);
		jp2.add(jtf4);
		jp2.add(jtf5);
		jp2.add(jtf6);
		
		jp3.add(jb1);
		jp3.add(jb2);
		
		this.add(jp1,BorderLayout.WEST);
		this.add(jp2,BorderLayout.CENTER);
		this.add(jp3,BorderLayout.SOUTH);
		
		//注册监听
		jb1.addActionListener(this);
		
		//展示
		this.setSize(400,300);
		this.setLocation(400,400);
		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);									
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==jb1)
		{
			//链接数据库
			ResultSet rs=null;
			Connection ct=null;
			PreparedStatement ps=null;
			//ResultSet rs=null;
			try {
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				//Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				ct=DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433;databaseName=stuman","sa","truman");
				
//				String stuId=jtf1.getText().trim();
//				String stuName=jtf2.getText().trim();
//				String stuSex=jtf3.getText().trim();
//				//int stuAge=Integer.parseInt(jtf4.getText().trim());				
//				String stuJg=jtf5.getText().trim();
//				String stuDept=jtf6.getText().trim();
				
				
				//以下做法会产生注入漏洞
				//ps=ct.prepareStatement("insert into stu values(stuId,stuName,stuSex,stuAge,stuJg,stuDept)");
				//优化为
				//ps=ct.prepareStatement("insert into stu values(?,?,?,?,?,?)");
				String str="update stu set stuName=?,stuSex=?,stuAge=?,stuJg=?,stuDept=? where stuId=?";
				ps=ct.prepareStatement(str);
				
				ps.setString(1, jtf2.getText());
				ps.setString(2, jtf3.getText());
				ps.setString(3, jtf4.getText());//这里有自动转换功能，但要求被转换的字符具备这种条件
				//ps.setInt(4 Integer.parseInt(jtf4.getText()));
				ps.setString(4, jtf5.getText());
				ps.setString(5, jtf6.getText());
				ps.setString(6, jtf1.getText());
				
				ps.executeUpdate();//执行操作
				
				this.dispose();//关闭对话框
				//System.out.println("succeed!");
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
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
						
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				
			}
		}
	}
}


//添加学生的对话框
package StudentsManager2;
import java.awt.*;
//import java.awt.event;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.*;
import java.sql.*;

public class StuAddDialog extends JDialog implements ActionListener{
	JLabel jl1,jl2,jl3,jl4,jl5,jl6;
	JButton jb1,jb2;
	JTextField jtf1,jtf2,jtf3,jtf4,jtf5,jtf6;
	JPanel jp1,jp2,jp3;
	//Frame父窗口、String窗口名、窗口模式
	public StuAddDialog(Frame owner, String title,boolean Model)
	{
		super(owner,title,Model);//调用父类构造方法初始化窗口模态
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
		
		jp1=new JPanel();
		jp2=new JPanel();
		jp3=new JPanel();
		
		jb1=new JButton("添加");
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
		jb2.addActionListener(this);
		
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
			StuModel temp=new StuModel();
			String sql="insert into stu values(?,?,?,?,?,?)";
			String[] paras={jtf1.getText(),jtf2.getText(),jtf3.getText(),jtf4.getText(),jtf5.getText(),jtf6.getText()};
			if(!temp.updateStu(sql, paras))
			{
				JOptionPane.showMessageDialog(this,"添加失败！");
			}
			this.dispose();
		}else if(e.getSource()==jb2)
		{
			this.dispose();
		}
	}
}

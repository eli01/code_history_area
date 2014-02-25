package com.Swing1;
import java.awt.*;

import javax.swing.*;
public class QQLoading extends JFrame{

	//定义组件
	JLabel jl1,jl2,jl3,jl4,jl5;
	JPasswordField jpf;
	JTextField jtf;
	JButton jb1,jb2,jb3,jb4;
	JCheckBox jcb1,jcb2;
	JTabbedPane jtp;
	JPanel jp1,jp2,jp3,jp4;
	JTabbedPane jtb;
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		QQLoading qq=new QQLoading();
	}
	//构造函数
	public QQLoading()
	{
		//创建组件
		jl1=new JLabel("QQ号码",JLabel.CENTER);
		
		jl2=new JLabel("QQ密码",JLabel.CENTER);
	
		jl3=new JLabel("忘记密码");
		//jl3.setFont(new Font("宋体",Font.PLAIN,16));
		//jl3.setForeground(Color.BLUE);
		
		jl4=new JLabel("gbdsa");
		jl4.setBackground(Color.BLUE);
		jl4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		
			jl5 = new JLabel(new ImageIcon("images/1.jpg"));
			jpf = new JPasswordField();
			jtf = new JTextField();
			jb1 = new JButton(new ImageIcon("images/1.jpg"));
			jb2 = new JButton(new ImageIcon("images/1.jpg"));
			jb3 = new JButton(new ImageIcon("images/1.jpg"));
			jb4 = new JButton(new ImageIcon("images/1.jpg"));
			jcb1 = new JCheckBox("隐身登陆");
			jcb2 = new JCheckBox("记住密码");
			jtp = new JTabbedPane();
			jp1 = new JPanel();
			jp2 = new JPanel();
			jp3 = new JPanel();
			jp3.setBackground(Color.BLUE);
			jp4 = new JPanel();
			jp4.setBackground(Color.RED);
			//设置布局管理器
			//this.setLayout(new FlowLayout(FlowLayout.));
			//添加组件
			//jp1.setLayout();
			
			jp1.add(jl1);
			jp1.add(jtf);
			jp1.add(jb1);//, what)
			jp1.add(jl2);
			//jp.add(jl2);
			jp1.add(jpf);
			jp1.add(jl3);
			jp1.add(jcb1);
			try {jp1.add(jcb2);
			jp1.add(jl4);
			
			jp2.add(jb2);
			jp2.add(jb3);
			jp2.add(jb4);
			
			jtb.add("QQ号码", jp1);
			jtp.add("手机号码", jp3);
			jtp.add("电子邮箱", jp4);
			//添加JFrame
		//北部区域
			this.add(jl5, BorderLayout.NORTH);
			//南部
			this.add(jp2, BorderLayout.SOUTH);
			//中部
			this.add(jtb, BorderLayout.CENTER);
			//设置窗口属性
			this.setSize(300, 200);
			this.setLocation(300, 300);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			//this.setTitle("")
			//this.setIconImage(new ImageIcon("20071219162745385_1.gif").getImage());
			this.setVisible(true);
		} catch (Exception e) {
			// TODO: handle exception
			e.getMessage();
			e.printStackTrace();
			
			System.out.println("有问题呀");
			e.getMessage();
		}
	}

}

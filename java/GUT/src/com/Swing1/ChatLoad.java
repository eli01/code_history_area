package com.Swing1;
import java.awt.*;

import javax.swing.*;
public class ChatLoad extends JFrame{
   //北部地区
	JLabel jl1;
	
	//南部地区
	JButton jb1,jb2,jb3;
	JPanel jp1;
	
	//中部地区
	JTabbedPane jtp;//选项卡窗格
	JPanel jp2,jp3,jp4;
	
	JTextField jtf;
	JLabel jl2,jl3,jl4,jl5;
	JPasswordField jpf;
	JButton jb4;
	JCheckBox jcb1,jcb2;
	
	public ChatLoad()
	{
		//创建组件
		
		//北部地区
		//jl1=new JLabel();
		
		jl2=new JLabel("QQ号码",JLabel.CENTER);
		jl3=new JLabel("QQ号码",JLabel.CENTER);
		
		jl4=new JLabel("忘记密码",JLabel.CENTER);
		jl4.setFont(new Font("宋体",Font.PLAIN,16));
		jl4.setForeground(Color.BLUE);
		
		jl5=new JLabel("申请密码保护",JLabel.CENTER);
		jl5=new JLabel("<html><a href='www.qq.com'>申请密码保护</a></html>");
		jl5.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		//鼠标箭头落在上方时编程小手的形状
		//输入号码框
		jtf=new JTextField();
		//输入密码框
		jpf=new JPasswordField(10);
		
		jb4=new JButton(new ImageIcon("images/JB.jpg"));
		
		jcb1=new JCheckBox("隐身登陆");
		jcb2=new JCheckBox("记住密码");
		
		//北部区域
		jl1=new JLabel(new ImageIcon("images\\JL1.PNG"));
		
		//南部
		jp1=new JPanel();
		jb1=new JButton(new ImageIcon("images\\JB.PNG"));
		jb2=new JButton(new ImageIcon("images\\JB.PNG"));
		jb3=new JButton(new ImageIcon("images\\JB.PNG"));
		//中部
		jtp=new JTabbedPane();
		jp2=new JPanel();
		jp3=new JPanel();
		jp3.setBackground(Color.BLACK);
		jp4=new JPanel();
		jp4.setBackground(Color.BLUE);
		//将面板加到选项卡窗口上
		jtp.add("QQ号码",jp2);
		jtp.add("手机号码",jp3);
		jtp.add("电子邮箱",jp4);
		
		//添加组件
		jp1.add(jb1);
		jp1.add(jb2);
		jp1.add(jb3);
		
		jp2.setLayout(new GridLayout(3,3,10,10));
		jp2.add(jl2);
		jp2.add(jtf);
		jp2.add(jb4);
		jp2.add(jl3);
		jp2.add(jpf);
		jp2.add(jl4);
		jp2.add(jcb1);
		jp2.add(jcb2);
		jp2.add(jl5);
		
		
		this.add(jl1,BorderLayout.NORTH);
		this.add(jtp,BorderLayout.CENTER);
		this.add(jp1,BorderLayout.SOUTH);
		//设置窗口属性
		this.setSize(400,300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocation(300, 300);
		this.setIconImage(new ImageIcon("5.PNG").getImage());
		this.setResizable(false);
		this.setVisible(true);
												
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ChatLoad();
	}

}

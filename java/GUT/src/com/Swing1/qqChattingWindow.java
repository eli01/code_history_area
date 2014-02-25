package com.Swing1;
import java.awt.*;
import javax.swing.*;
public class qqChattingWindow extends JFrame{
	//定义组件
	JButton jb;
	JTextArea jta;
	JScrollPane jsp;
	JTextField jtf;
	JPanel jp;
	JComboBox jcb;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		qqChattingWindow qq=new qqChattingWindow();
	}
	//构造函数
	public qqChattingWindow()
	{
		//创建组件
		jb=new JButton("发送");
		jta=new JTextArea();
		jp=new JPanel();
		jtf=new JTextField(10);
		
		String s[]={"布什","拉登"};
		jcb=new JComboBox(s);
		jsp=new JScrollPane(jta);
		//设置布局管理器
		//添加组件
		jp.add(jcb);
		jp.add(jtf);
		jp.add(jb);
		//添加JFrame
		this.add(jsp);
		this.add(jp,BorderLayout.SOUTH);
		//设置窗口属性
		this.setIconImage(new ImageIcon("images\\VIP.PNG").getImage());
		this.setSize(400,350);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocation(300,300);
		this.setTitle("腾讯QQ");
		//显示
		this.setVisible(true);
	}
}

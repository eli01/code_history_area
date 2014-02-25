package com.Swing1;
import java.awt.*;
import javax.swing.*;
public class Test31_1 extends JFrame{
	//定义组件
	JButton jb1,jb2,jb3,jb4,jb5,jb6;
	JPanel jp1,jp2;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Test31_1 text=new Test31_1();
	}
	//构造函数
	public Test31_1()
	{
		//创建组件
		jp1=new JPanel();
		jp2=new JPanel();
		
		jb1=new JButton("苹果");
		jb2=new JButton("梨");
		jb3=new JButton("桃子");
		jb4=new JButton("荔枝");
		jb5=new JButton("香蕉");
		jb6=new JButton("西瓜");
		//设置窗口管理器
		jp1.add(jb1);
		jp1.add(jb2);
		jp2.add(jb3);
		jp2.add(jb4);
		jp2.add(jb5);
		
		this.add(jp1,BorderLayout.NORTH);
		this.add(jp2,BorderLayout.SOUTH);
		this.add(jb6,BorderLayout.CENTER);
		//设置窗口属性
		this.setSize(400, 400);
		this.setLocation(300,300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//显示
		this.setVisible(true);
	}

}

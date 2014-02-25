package com.Swing1;
import java.awt.*;
import javax.swing.*;
public class Text32_1 extends JFrame{
	//定义组件
	JList jlist;
	JLabel jl;
	JSplitPane jsp;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Text32_1 te=new Text32_1();
	}
//构造函数
	public Text32_1()
	{
		//创建组件
		String []s1={"a","about","add","astronant","afried","agle","aunt"};
		jlist=new JList(s1);
		
		jl=new JLabel(new ImageIcon("images\\金山词霸Linux.png"));
		
		jsp=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,jlist,jl);
		jsp.setOneTouchExpandable(true);
		//设置布局管理器
		
		//添加组件
		this.add(jsp);
		//设置窗口属性
		this.setSize(500,300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocation(400,400);
		this.setTitle("金山词霸2012 V30");
		//显示
		this.setVisible(true);
	}
} 

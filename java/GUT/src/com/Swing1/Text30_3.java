package com.Swing1;
import java.awt.*;
import javax.swing.*;
public class Text30_3 extends JFrame{

	//定义组件
	int size=9;
	JButton jbs[]=new JButton[size];
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Text30_3 text=new Text30_3();
	}
	//构造函数
	public Text30_3()
	{
		//创建组件
		for(int i=0;i<9;i++)
		{
			jbs[i]=new JButton(String.valueOf(i));
		}
		//设置网格布局管理器
		this.setLayout(new GridLayout(3,3,10,10));
		//添加组件
		for(int i=0;i<size;i++)
		{
			this.add(jbs[i]);
		}
		//设置窗口属性
		this.setTitle("网格布局案例");
		this.setSize(300,200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocation(200,200);
		//显示
		this.setVisible(true);
	}

}

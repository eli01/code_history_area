/**
 *功能：流式布局案例
 * 
 */
package com.Swing1;
import java.awt.*;

import javax.swing.*;
public class Text30_2 extends JFrame{
	//定义需要的组件
	JButton jb1,jb2,jb3,jb4,jb5,jb6;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Text30_2 text=new Text30_2();
	}
	//构造函数
	public Text30_2()
	{
		//创建组件
		jb1=new JButton("关羽");
		jb2=new JButton("张飞");
		jb3=new JButton("赵云");
		jb4=new JButton("马超");
		jb5=new JButton("黄忠");
		jb6=new JButton("魏延");
		//添加组件
		this.add(jb1);
		this.add(jb2);
		this.add(jb3);
		this.add(jb4);
		this.add(jb5);
		this.add(jb6);
		//设置布局管理器
		this.setLayout(new FlowLayout(FlowLayout.RIGHT));
		//this.setLayout(null);
		//设置窗体属性
		this.setTitle("边界布局案例");
		this.setSize(300,200);
		this.setLocation(200,200);
		//禁止用户改变窗口大小
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//显示窗体
		this.setVisible(true);
		
		
	}

}

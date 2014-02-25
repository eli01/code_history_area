/**
 *功能：用户注册界面
 * 
 */
package com.Swing1;
import java.awt.*;
import javax.swing.*;
 class Text31_3 extends JFrame{

	 //定义组件
	 JPanel jp1,jp2,jp3;
	 JLabel jlb1,jlb2;
	 JButton jb1,jb2;
	 JCheckBox jcb1,jcb2,jcb3;
	 JRadioButton jrb1,jrb2;
	 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Text31_3 text=new Text31_3();
	}
	//构造函数
	public Text31_3()
	{
		//创建组件
		jp1=new JPanel();
		jp2=new JPanel();
		jp3=new JPanel();
		
		jlb1=new JLabel("你最喜欢的运动");
		jlb2=new JLabel("你的性别");
		
		jb1=new JButton("注册用户");
		jb2=new JButton("取消注册");
		
		jcb1=new JCheckBox("足球");
		jcb2=new JCheckBox("篮球");
		jcb3=new JCheckBox("网球");
		
		jrb1=new JRadioButton("男");
		jrb2=new JRadioButton("女");
		//添加组件
		jp1.add(jlb1);
		jp1.add(jcb1);
		jp1.add(jcb2);
		jp1.add(jcb3);
		
		jp2.add(jlb2);
		jp2.add(jrb1);
		jp2.add(jrb2);
		
		jp3.add(jb1);
		jp3.add(jb2);
		//把jrb1和jrb2放到一个ButttonGroup中
		ButtonGroup bg=new ButtonGroup();
		bg.add(jrb1);
		bg.add(jrb2);
		//设置布局管理器
		this.setLayout(new GridLayout(3,1));
		//加入JFrame
		this.add(jp1);
		this.add(jp2);
		this.add(jp3);
		//设置窗口属性
		this.setSize(300,200);
		this.setLocation(300,300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("用户注册界面");
		//显示
		this.setVisible(true);
	}

}

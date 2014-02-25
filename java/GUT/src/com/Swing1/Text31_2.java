/**
 * 功能：会员登录系统
 */
package com.Swing1;
import java.awt.*;
import javax.swing.*;
public class Text31_2 extends JFrame {
	//定义组件
	JPanel jp1,jp2,jp3;
	JButton jb1,jb2;
	JTextField jtf;
	JPasswordField jpf;
	JLabel jlb1,jlb2;
	
	public static void main(String[] args){
		Text31_2 text=new Text31_2();
	}
	//构造函数
	public Text31_2()
	{
		//创建组件
		jp1=new JPanel();
		jp2=new JPanel();
		jp3=new JPanel();
		
		jb1=new JButton("确认");
		jb2=new JButton("取消");
		
		jtf=new JTextField(10);
		jpf=new JPasswordField(10);
		
		jlb1=new JLabel("管理员");
		jlb2=new JLabel("密    码");
		//设置布局管理器
		this.setLayout(new GridLayout(3,1));
		//加入各个组件
		jp1.add(jlb1);
		jp1.add(jtf);
		
		jp2.add(jlb2);
		jp2.add(jpf);
		
		jp3.add(jb1);
		jp3.add(jb2);
		//加入JFrame
		this.add(jp1);
		this.add(jp2);
		this.add(jp3);
		//设置窗口属性
		this.setSize(300,150);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocation(300,300);
		this.setTitle("会员管理系统");
		//显示
		this.setVisible(true);
	}

}

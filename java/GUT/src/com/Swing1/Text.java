package com.Swing1;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class Text extends JFrame implements ActionListener{
	Cat cat=null;
	MyPanel mp=null;
	JButton jb1=null;
	JButton jb2=null;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Text text=new Text();
	}
	//构造函数
	public Text()
	{
		//创建组件
		cat=new Cat();
		mp=new MyPanel();
		jb1=new JButton("红色");
	
		jb2=new JButton("蓝色");
		//注册监听
		jb1.addActionListener(this);
		jb1.addActionListener(cat);
		//指定action命令
		jb1.setActionCommand("红色");
		jb2.addActionListener(this);
		jb2.setActionCommand("蓝色");
		jb2.addActionListener(cat);
		//添加组件
		this.add(jb1,BorderLayout.NORTH);
		this.add(jb2,BorderLayout.SOUTH);
		this.add(mp,BorderLayout.CENTER);
		//设置窗口属性
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(300,200);
		this.setLocation(100,100);
		this.setVisible(true);
	}
	//对事件处理的方法
	public void actionPerformed(ActionEvent e)
	{
		//System.out.println("ok!");
		//判断那个按钮被点击
		if(e.getActionCommand().equals("红色"))
		{
			System.out.println("你点击的是红色按钮!");
			mp.setBackground(Color.red);
		}else if(e.getActionCommand().equals("蓝色"))
		{
			System.out.println("你点击的是蓝色按钮！");
			mp.setBackground(Color.blue);
		
		}else{
			System.out.println("不知道");//这个动作不会发生
		}
	}

}

class MyPanel extends JPanel
{
	public MyPanel()
	{
		this.setBackground(Color.RED);
	}
}
class Cat implements ActionListener
{
	public void actionPerformed(ActionEvent arg0){
		if(arg0.getActionCommand().equals("红色"))
		{
			System.out.println("猫也知道你按下了红色按钮！");
		}
	}
}

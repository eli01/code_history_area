/**
 * 
 */
package com.Swing1;
import java.awt.*;
import javax.swing.*;
/**
 * @author Neo
 *
 */
public class Text29 extends JFrame {
//把需要的Swing组件放在这
	JButton jb=null;//JFrame是一个顶层容器（可以添加其它swing组件的类）
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	 Text29 text=new Text29();	
	
	}
	//构造函数
	public Text29()
	{
		JButton jb1=new JButton("我是按钮");//创建一个Button按钮
		//添加JButton组件
		this.add(jb1);
		//给窗体设计一个标题
		this.setTitle("Hello!world！");
		//给窗体设置高
		this.setSize(200,200);
		//设置初始位置
		this.setLocation(100,200);
		//显示
		this.setVisible(true);	
		//当关闭窗口的时候保证JVM也退出
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}

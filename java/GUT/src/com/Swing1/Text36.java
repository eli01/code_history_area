package com.Swing1;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class Text36 extends JFrame{

	MyPanel3 mp=null;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Text36 text=new Text36();
	}
	//构造函数
	public Text36()
	{
		//创建组件
		mp=new MyPanel3();
		mp.setBackground(Color.gray);
		//添加组件
		this.add(mp);
		//注册监听
		this.addMouseListener(mp);
		this.addKeyListener(mp);
		//设置窗口属性
		this.setSize(400,300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocation(100,100);
		this.setVisible(true);
	}
}
//1.让MyPanel知道鼠标按下的消息，并且知道点击的位置（x,y）
//2.让MyPanel知道那个键被按下
//3.让MyPanel知道鼠标移动，拖拽
//4.让MyPanel知道窗口被最小化了
class MyPanel3 extends JPanel implements MouseListener,KeyListener,MouseMotionListener
{
	public void paint(Graphics g)
	{
		super.paint(g);
	}

//
	//鼠标点击
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("鼠标点击了("+e.getX()+","+e.getY()+")");
	}


	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	//鼠标移动到MyPanel
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println(e.getKeyChar()+"键被按下");
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("鼠标被移动");
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
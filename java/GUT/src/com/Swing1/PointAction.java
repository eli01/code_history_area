package com.Swing1;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class PointAction extends JFrame{
	//设置组件
	MyPanel2 mp=null;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PointAction pa=new PointAction();
	}
	//构造函数
	public PointAction()
	{
		mp=new MyPanel2();
		//mp.setBackground(Color.blue);
		//加入到JFrame
		this.add(mp);
		
		this.addKeyListener(mp);
		
		this.setSize(400,300);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocation(100,100);
		this.setVisible(true);
		
	}

}
//定义自己的Panel
class MyPanel2 extends JPanel implements KeyListener
{
	int x=10;
	int y=10;
	public void paint(Graphics g)
	{
		super.paint(g);
		g.fillOval(x, y,10, 10);
	}

	//键的一个值被输出
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
	
	}

	//键被按下
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		//System.out.println("被按下"+(char)e.getKeyCode());
		if(e.getKeyCode()==KeyEvent.VK_UP)
		{
			y-=10;
		}else if(e.getKeyCode()==KeyEvent.VK_DOWN){
			y+=10;
		}else if(e.getKeyCode()==KeyEvent.VK_RIGHT){
			x+=10;
		}else if(e.getKeyCode()==KeyEvent.VK_LEFT){
			x-=10;
		}
		//调用repaint()函数，重绘
		this.repaint();
	}

	//键被释放
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	//构造函数
//	public MyPanel()
//	{
//		
//	}
}

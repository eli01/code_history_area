package com.Swing1;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class PointAction extends JFrame{
	//�������
	MyPanel2 mp=null;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PointAction pa=new PointAction();
	}
	//���캯��
	public PointAction()
	{
		mp=new MyPanel2();
		//mp.setBackground(Color.blue);
		//���뵽JFrame
		this.add(mp);
		
		this.addKeyListener(mp);
		
		this.setSize(400,300);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocation(100,100);
		this.setVisible(true);
		
	}

}
//�����Լ���Panel
class MyPanel2 extends JPanel implements KeyListener
{
	int x=10;
	int y=10;
	public void paint(Graphics g)
	{
		super.paint(g);
		g.fillOval(x, y,10, 10);
	}

	//����һ��ֵ�����
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
	
	}

	//��������
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		//System.out.println("������"+(char)e.getKeyCode());
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
		//����repaint()�������ػ�
		this.repaint();
	}

	//�����ͷ�
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	//���캯��
//	public MyPanel()
//	{
//		
//	}
}

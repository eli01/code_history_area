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
	//���캯��
	public Text36()
	{
		//�������
		mp=new MyPanel3();
		mp.setBackground(Color.gray);
		//������
		this.add(mp);
		//ע�����
		this.addMouseListener(mp);
		this.addKeyListener(mp);
		//���ô�������
		this.setSize(400,300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocation(100,100);
		this.setVisible(true);
	}
}
//1.��MyPanel֪����갴�µ���Ϣ������֪�������λ�ã�x,y��
//2.��MyPanel֪���Ǹ���������
//3.��MyPanel֪������ƶ�����ק
//4.��MyPanel֪�����ڱ���С����
class MyPanel3 extends JPanel implements MouseListener,KeyListener,MouseMotionListener
{
	public void paint(Graphics g)
	{
		super.paint(g);
	}

//
	//�����
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("�������("+e.getX()+","+e.getY()+")");
	}


	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	//����ƶ���MyPanel
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
		System.out.println(e.getKeyChar()+"��������");
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("��걻�ƶ�");
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
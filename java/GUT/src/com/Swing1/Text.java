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
	//���캯��
	public Text()
	{
		//�������
		cat=new Cat();
		mp=new MyPanel();
		jb1=new JButton("��ɫ");
	
		jb2=new JButton("��ɫ");
		//ע�����
		jb1.addActionListener(this);
		jb1.addActionListener(cat);
		//ָ��action����
		jb1.setActionCommand("��ɫ");
		jb2.addActionListener(this);
		jb2.setActionCommand("��ɫ");
		jb2.addActionListener(cat);
		//������
		this.add(jb1,BorderLayout.NORTH);
		this.add(jb2,BorderLayout.SOUTH);
		this.add(mp,BorderLayout.CENTER);
		//���ô�������
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(300,200);
		this.setLocation(100,100);
		this.setVisible(true);
	}
	//���¼�����ķ���
	public void actionPerformed(ActionEvent e)
	{
		//System.out.println("ok!");
		//�ж��Ǹ���ť�����
		if(e.getActionCommand().equals("��ɫ"))
		{
			System.out.println("�������Ǻ�ɫ��ť!");
			mp.setBackground(Color.red);
		}else if(e.getActionCommand().equals("��ɫ"))
		{
			System.out.println("����������ɫ��ť��");
			mp.setBackground(Color.blue);
		
		}else{
			System.out.println("��֪��");//����������ᷢ��
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
		if(arg0.getActionCommand().equals("��ɫ"))
		{
			System.out.println("èҲ֪���㰴���˺�ɫ��ť��");
		}
	}
}

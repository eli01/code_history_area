package com.Swing1;
import java.awt.*;
import javax.swing.*;
public class Test31_1 extends JFrame{
	//�������
	JButton jb1,jb2,jb3,jb4,jb5,jb6;
	JPanel jp1,jp2;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Test31_1 text=new Test31_1();
	}
	//���캯��
	public Test31_1()
	{
		//�������
		jp1=new JPanel();
		jp2=new JPanel();
		
		jb1=new JButton("ƻ��");
		jb2=new JButton("��");
		jb3=new JButton("����");
		jb4=new JButton("��֦");
		jb5=new JButton("�㽶");
		jb6=new JButton("����");
		//���ô��ڹ�����
		jp1.add(jb1);
		jp1.add(jb2);
		jp2.add(jb3);
		jp2.add(jb4);
		jp2.add(jb5);
		
		this.add(jp1,BorderLayout.NORTH);
		this.add(jp2,BorderLayout.SOUTH);
		this.add(jb6,BorderLayout.CENTER);
		//���ô�������
		this.setSize(400, 400);
		this.setLocation(300,300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//��ʾ
		this.setVisible(true);
	}

}

package com.Swing1;
import java.awt.*;
import javax.swing.*;
public class Text30_3 extends JFrame{

	//�������
	int size=9;
	JButton jbs[]=new JButton[size];
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Text30_3 text=new Text30_3();
	}
	//���캯��
	public Text30_3()
	{
		//�������
		for(int i=0;i<9;i++)
		{
			jbs[i]=new JButton(String.valueOf(i));
		}
		//�������񲼾ֹ�����
		this.setLayout(new GridLayout(3,3,10,10));
		//������
		for(int i=0;i<size;i++)
		{
			this.add(jbs[i]);
		}
		//���ô�������
		this.setTitle("���񲼾ְ���");
		this.setSize(300,200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocation(200,200);
		//��ʾ
		this.setVisible(true);
	}

}

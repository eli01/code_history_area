package com.Swing1;
import java.awt.*;
import javax.swing.*;
public class Text32_1 extends JFrame{
	//�������
	JList jlist;
	JLabel jl;
	JSplitPane jsp;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Text32_1 te=new Text32_1();
	}
//���캯��
	public Text32_1()
	{
		//�������
		String []s1={"a","about","add","astronant","afried","agle","aunt"};
		jlist=new JList(s1);
		
		jl=new JLabel(new ImageIcon("images\\��ɽ�ʰ�Linux.png"));
		
		jsp=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,jlist,jl);
		jsp.setOneTouchExpandable(true);
		//���ò��ֹ�����
		
		//������
		this.add(jsp);
		//���ô�������
		this.setSize(500,300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocation(400,400);
		this.setTitle("��ɽ�ʰ�2012 V30");
		//��ʾ
		this.setVisible(true);
	}
} 

package com.Swing1;
import java.awt.*;
import javax.swing.*;
public class qqChattingWindow extends JFrame{
	//�������
	JButton jb;
	JTextArea jta;
	JScrollPane jsp;
	JTextField jtf;
	JPanel jp;
	JComboBox jcb;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		qqChattingWindow qq=new qqChattingWindow();
	}
	//���캯��
	public qqChattingWindow()
	{
		//�������
		jb=new JButton("����");
		jta=new JTextArea();
		jp=new JPanel();
		jtf=new JTextField(10);
		
		String s[]={"��ʲ","����"};
		jcb=new JComboBox(s);
		jsp=new JScrollPane(jta);
		//���ò��ֹ�����
		//������
		jp.add(jcb);
		jp.add(jtf);
		jp.add(jb);
		//���JFrame
		this.add(jsp);
		this.add(jp,BorderLayout.SOUTH);
		//���ô�������
		this.setIconImage(new ImageIcon("images\\VIP.PNG").getImage());
		this.setSize(400,350);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocation(300,300);
		this.setTitle("��ѶQQ");
		//��ʾ
		this.setVisible(true);
	}
}

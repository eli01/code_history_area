package com.Swing1;
import java.awt.*;

import javax.swing.*;
public class QQLoading extends JFrame{

	//�������
	JLabel jl1,jl2,jl3,jl4,jl5;
	JPasswordField jpf;
	JTextField jtf;
	JButton jb1,jb2,jb3,jb4;
	JCheckBox jcb1,jcb2;
	JTabbedPane jtp;
	JPanel jp1,jp2,jp3,jp4;
	JTabbedPane jtb;
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		QQLoading qq=new QQLoading();
	}
	//���캯��
	public QQLoading()
	{
		//�������
		jl1=new JLabel("QQ����",JLabel.CENTER);
		
		jl2=new JLabel("QQ����",JLabel.CENTER);
	
		jl3=new JLabel("��������");
		//jl3.setFont(new Font("����",Font.PLAIN,16));
		//jl3.setForeground(Color.BLUE);
		
		jl4=new JLabel("gbdsa");
		jl4.setBackground(Color.BLUE);
		jl4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		
			jl5 = new JLabel(new ImageIcon("images/1.jpg"));
			jpf = new JPasswordField();
			jtf = new JTextField();
			jb1 = new JButton(new ImageIcon("images/1.jpg"));
			jb2 = new JButton(new ImageIcon("images/1.jpg"));
			jb3 = new JButton(new ImageIcon("images/1.jpg"));
			jb4 = new JButton(new ImageIcon("images/1.jpg"));
			jcb1 = new JCheckBox("�����½");
			jcb2 = new JCheckBox("��ס����");
			jtp = new JTabbedPane();
			jp1 = new JPanel();
			jp2 = new JPanel();
			jp3 = new JPanel();
			jp3.setBackground(Color.BLUE);
			jp4 = new JPanel();
			jp4.setBackground(Color.RED);
			//���ò��ֹ�����
			//this.setLayout(new FlowLayout(FlowLayout.));
			//������
			//jp1.setLayout();
			
			jp1.add(jl1);
			jp1.add(jtf);
			jp1.add(jb1);//, what)
			jp1.add(jl2);
			//jp.add(jl2);
			jp1.add(jpf);
			jp1.add(jl3);
			jp1.add(jcb1);
			try {jp1.add(jcb2);
			jp1.add(jl4);
			
			jp2.add(jb2);
			jp2.add(jb3);
			jp2.add(jb4);
			
			jtb.add("QQ����", jp1);
			jtp.add("�ֻ�����", jp3);
			jtp.add("��������", jp4);
			//���JFrame
		//��������
			this.add(jl5, BorderLayout.NORTH);
			//�ϲ�
			this.add(jp2, BorderLayout.SOUTH);
			//�в�
			this.add(jtb, BorderLayout.CENTER);
			//���ô�������
			this.setSize(300, 200);
			this.setLocation(300, 300);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			//this.setTitle("")
			//this.setIconImage(new ImageIcon("20071219162745385_1.gif").getImage());
			this.setVisible(true);
		} catch (Exception e) {
			// TODO: handle exception
			e.getMessage();
			e.printStackTrace();
			
			System.out.println("������ѽ");
			e.getMessage();
		}
	}

}

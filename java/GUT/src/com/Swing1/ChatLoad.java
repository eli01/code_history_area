package com.Swing1;
import java.awt.*;

import javax.swing.*;
public class ChatLoad extends JFrame{
   //��������
	JLabel jl1;
	
	//�ϲ�����
	JButton jb1,jb2,jb3;
	JPanel jp1;
	
	//�в�����
	JTabbedPane jtp;//ѡ�����
	JPanel jp2,jp3,jp4;
	
	JTextField jtf;
	JLabel jl2,jl3,jl4,jl5;
	JPasswordField jpf;
	JButton jb4;
	JCheckBox jcb1,jcb2;
	
	public ChatLoad()
	{
		//�������
		
		//��������
		//jl1=new JLabel();
		
		jl2=new JLabel("QQ����",JLabel.CENTER);
		jl3=new JLabel("QQ����",JLabel.CENTER);
		
		jl4=new JLabel("��������",JLabel.CENTER);
		jl4.setFont(new Font("����",Font.PLAIN,16));
		jl4.setForeground(Color.BLUE);
		
		jl5=new JLabel("�������뱣��",JLabel.CENTER);
		jl5=new JLabel("<html><a href='www.qq.com'>�������뱣��</a></html>");
		jl5.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		//����ͷ�����Ϸ�ʱ���С�ֵ���״
		//��������
		jtf=new JTextField();
		//���������
		jpf=new JPasswordField(10);
		
		jb4=new JButton(new ImageIcon("images/JB.jpg"));
		
		jcb1=new JCheckBox("�����½");
		jcb2=new JCheckBox("��ס����");
		
		//��������
		jl1=new JLabel(new ImageIcon("images\\JL1.PNG"));
		
		//�ϲ�
		jp1=new JPanel();
		jb1=new JButton(new ImageIcon("images\\JB.PNG"));
		jb2=new JButton(new ImageIcon("images\\JB.PNG"));
		jb3=new JButton(new ImageIcon("images\\JB.PNG"));
		//�в�
		jtp=new JTabbedPane();
		jp2=new JPanel();
		jp3=new JPanel();
		jp3.setBackground(Color.BLACK);
		jp4=new JPanel();
		jp4.setBackground(Color.BLUE);
		//�����ӵ�ѡ�������
		jtp.add("QQ����",jp2);
		jtp.add("�ֻ�����",jp3);
		jtp.add("��������",jp4);
		
		//������
		jp1.add(jb1);
		jp1.add(jb2);
		jp1.add(jb3);
		
		jp2.setLayout(new GridLayout(3,3,10,10));
		jp2.add(jl2);
		jp2.add(jtf);
		jp2.add(jb4);
		jp2.add(jl3);
		jp2.add(jpf);
		jp2.add(jl4);
		jp2.add(jcb1);
		jp2.add(jcb2);
		jp2.add(jl5);
		
		
		this.add(jl1,BorderLayout.NORTH);
		this.add(jtp,BorderLayout.CENTER);
		this.add(jp1,BorderLayout.SOUTH);
		//���ô�������
		this.setSize(400,300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocation(300, 300);
		this.setIconImage(new ImageIcon("5.PNG").getImage());
		this.setResizable(false);
		this.setVisible(true);
												
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ChatLoad();
	}

}

package com.Swing1;
import java.awt.*;
import javax.swing.*;
public class Text31_4 extends JFrame{

	//�������
	JPanel jp1,jp2;
	JLabel jl1,jl2;
	JComboBox jcb;
	JList jlt;
	JScrollPane jsp;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Text31_4 text=new Text31_4();
	}
	//���캯��
	public Text31_4()
	{
		//�������
		jp1=new JPanel();
		jp2=new JPanel();
		
		jl1=new JLabel("��ļ�����");
		jl2=new JLabel("��ϲ��ȥ�ĵ���");
		String []s1=new String[]{"����","�Ϻ�","����","����","����","����"};
		jcb=new JComboBox(s1);
		String []s2=new String[]{"��կ��","�ػʵ�","����","����","ŦԼ","����"};
		jlt=new JList(s2);
		jlt.setVisibleRowCount(2);
		jsp=new JScrollPane(jlt);
		
		
		//���ò��ֹ�����
		this.setLayout(new GridLayout(2,1));
		//������
		jp1.add(jl1);
		jp1.add(jcb);
		
		jp2.add(jl2);
		jp2.add(jsp);
		//����JFrame
		this.add(jp1);
		this.add(jp2);
		//���ô�������
		this.setSize(300,200);
		this.setLocation(300,300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("�û�����");
		//��ʾ
		this.setVisible(true);
		
		
	}

}

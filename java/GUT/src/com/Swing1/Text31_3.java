/**
 *���ܣ��û�ע�����
 * 
 */
package com.Swing1;
import java.awt.*;
import javax.swing.*;
 class Text31_3 extends JFrame{

	 //�������
	 JPanel jp1,jp2,jp3;
	 JLabel jlb1,jlb2;
	 JButton jb1,jb2;
	 JCheckBox jcb1,jcb2,jcb3;
	 JRadioButton jrb1,jrb2;
	 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Text31_3 text=new Text31_3();
	}
	//���캯��
	public Text31_3()
	{
		//�������
		jp1=new JPanel();
		jp2=new JPanel();
		jp3=new JPanel();
		
		jlb1=new JLabel("����ϲ�����˶�");
		jlb2=new JLabel("����Ա�");
		
		jb1=new JButton("ע���û�");
		jb2=new JButton("ȡ��ע��");
		
		jcb1=new JCheckBox("����");
		jcb2=new JCheckBox("����");
		jcb3=new JCheckBox("����");
		
		jrb1=new JRadioButton("��");
		jrb2=new JRadioButton("Ů");
		//������
		jp1.add(jlb1);
		jp1.add(jcb1);
		jp1.add(jcb2);
		jp1.add(jcb3);
		
		jp2.add(jlb2);
		jp2.add(jrb1);
		jp2.add(jrb2);
		
		jp3.add(jb1);
		jp3.add(jb2);
		//��jrb1��jrb2�ŵ�һ��ButttonGroup��
		ButtonGroup bg=new ButtonGroup();
		bg.add(jrb1);
		bg.add(jrb2);
		//���ò��ֹ�����
		this.setLayout(new GridLayout(3,1));
		//����JFrame
		this.add(jp1);
		this.add(jp2);
		this.add(jp3);
		//���ô�������
		this.setSize(300,200);
		this.setLocation(300,300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("�û�ע�����");
		//��ʾ
		this.setVisible(true);
	}

}

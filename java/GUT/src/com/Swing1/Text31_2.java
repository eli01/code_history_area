/**
 * ���ܣ���Ա��¼ϵͳ
 */
package com.Swing1;
import java.awt.*;
import javax.swing.*;
public class Text31_2 extends JFrame {
	//�������
	JPanel jp1,jp2,jp3;
	JButton jb1,jb2;
	JTextField jtf;
	JPasswordField jpf;
	JLabel jlb1,jlb2;
	
	public static void main(String[] args){
		Text31_2 text=new Text31_2();
	}
	//���캯��
	public Text31_2()
	{
		//�������
		jp1=new JPanel();
		jp2=new JPanel();
		jp3=new JPanel();
		
		jb1=new JButton("ȷ��");
		jb2=new JButton("ȡ��");
		
		jtf=new JTextField(10);
		jpf=new JPasswordField(10);
		
		jlb1=new JLabel("����Ա");
		jlb2=new JLabel("��    ��");
		//���ò��ֹ�����
		this.setLayout(new GridLayout(3,1));
		//����������
		jp1.add(jlb1);
		jp1.add(jtf);
		
		jp2.add(jlb2);
		jp2.add(jpf);
		
		jp3.add(jb1);
		jp3.add(jb2);
		//����JFrame
		this.add(jp1);
		this.add(jp2);
		this.add(jp3);
		//���ô�������
		this.setSize(300,150);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocation(300,300);
		this.setTitle("��Ա����ϵͳ");
		//��ʾ
		this.setVisible(true);
	}

}

/**
 *���ܣ���ʽ���ְ���
 * 
 */
package com.Swing1;
import java.awt.*;

import javax.swing.*;
public class Text30_2 extends JFrame{
	//������Ҫ�����
	JButton jb1,jb2,jb3,jb4,jb5,jb6;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Text30_2 text=new Text30_2();
	}
	//���캯��
	public Text30_2()
	{
		//�������
		jb1=new JButton("����");
		jb2=new JButton("�ŷ�");
		jb3=new JButton("����");
		jb4=new JButton("��");
		jb5=new JButton("����");
		jb6=new JButton("κ��");
		//������
		this.add(jb1);
		this.add(jb2);
		this.add(jb3);
		this.add(jb4);
		this.add(jb5);
		this.add(jb6);
		//���ò��ֹ�����
		this.setLayout(new FlowLayout(FlowLayout.RIGHT));
		//this.setLayout(null);
		//���ô�������
		this.setTitle("�߽粼�ְ���");
		this.setSize(300,200);
		this.setLocation(200,200);
		//��ֹ�û��ı䴰�ڴ�С
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//��ʾ����
		this.setVisible(true);
		
		
	}

}

/**
 * 
 */
package com.Swing1;
import java.awt.*;
import javax.swing.*;
/**
 * @author Neo
 *
 */
public class Text29 extends JFrame {
//����Ҫ��Swing���������
	JButton jb=null;//JFrame��һ�����������������������swing������ࣩ
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	 Text29 text=new Text29();	
	
	}
	//���캯��
	public Text29()
	{
		JButton jb1=new JButton("���ǰ�ť");//����һ��Button��ť
		//���JButton���
		this.add(jb1);
		//���������һ������
		this.setTitle("Hello!world��");
		//���������ø�
		this.setSize(200,200);
		//���ó�ʼλ��
		this.setLocation(100,200);
		//��ʾ
		this.setVisible(true);	
		//���رմ��ڵ�ʱ��֤JVMҲ�˳�
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}

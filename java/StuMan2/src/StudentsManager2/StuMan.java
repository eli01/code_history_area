/**
 * model2ģʽ��mvģʽ��
 */
package StudentsManager2;
import javax.swing.*;

import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class StuMan extends JFrame implements ActionListener{

	//����һһЩ���
	JPanel jp1,jp2;
	JButton jb1,jb2,jb3,jb4;
	JLabel jl;
	JTextField jtf;
	JTable jt;
	JScrollPane jsp;
	StuModel smo;
	//Vector rowData,columnNames;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StuMan sm3=new StuMan();
	}
	//���캯��
	public StuMan()
	{
		//����
		jp1=new JPanel();
		jl=new JLabel("������ѧ��");
		jtf=new JTextField(10);
		jb1=new JButton("��ѯ");
		jb1.addActionListener(this);//ע�����
		jp1.add(jl);
		jp1.add(jtf);
		jp1.add(jb1);
		//�ϱ�
		jp2=new JPanel();
		jb2=new JButton("���");
		jb2.addActionListener(this);
		jb3=new JButton("�޸�");
		jb3.addActionListener(this);
		jb4=new JButton("ɾ��");
		jb4.addActionListener(this);//ע�����
		jp2.add(jb2);
		jp2.add(jb3);
		jp2.add(jb4);
		//�м�
		//����һ������ģ�Ͷ���
		smo=new StuModel();//��mvcģʽ��ȥ����ԭ�����캯������Ҫ������ģ���ó�Ա��������ʼ��
		String[] paras={"1"};
		smo.queryStu("select * from stu where 1=?", paras);
		
		jt=new JTable(smo);
		//jt=new JTable(rowData,columnNames);//��ʼ��JTable
		jsp=new JScrollPane(jt);
		//��jsp����jframe
		this.add(jp1,"North");
		this.add(jp2,"South");
		this.add(jsp);//Ĭ�ϼӵ������м�
		this.setSize(400,300);
		this.setLocation(400,400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		//�ж��Ǹ���ť�����
		//PreparedStatement ps=null;
		//Connection ct=null;
		if(e.getSource()==jb1)
		{
			//System.out.println("ִ�в�ѯ���");
			//�õ��û���
			String ID=this.jtf.getText().trim();//���˿��ַ���
			//String sql="select*from stu where stuId='"+name+"'";//�õ�sql��䣬����ע��©��
			String sql="select*from stu where stuId=?";
			String []paras={ID};
			//�����µ�����ģ���࣬������
			smo=new StuModel();
			smo.queryStu(sql, paras);
			//����JTable
			jt.setModel(smo);
			
		}else if(e.getSource()==jb2)
		{
			StuAddDialog sad=new StuAddDialog(this,"��Ӵ���",true);
			//���»���µ�����ģ��
			smo=new StuModel();
			String []paras={"1"};
			smo.queryStu("select*from stu where 1=?",paras);
			//����JTabel
			jt.setModel(smo);
		}else if(e.getSource()==jb3)
		{
			//˵���û����޸�ѧ����Ϣ
			int rowNum=this.jt.getSelectedRow();//���ѡ�е�����
			if(rowNum==-1)
			{
				JOptionPane.showMessageDialog(this, "��ѡ��һ��");
				return;
			}
			//��ʾ�޸ĶԻ���
			new StuUpdate(this,"�޸�ѧ����Ϣ",true,smo,rowNum);
			//�����µ�����ģ���࣬������
			smo=new StuModel();
			String []paras={"1"};
			smo.queryStu("select*from stu where 1=?",paras);
			
			//����JTable
			jt.setModel(smo);
		}
		else if(e.getSource()==jb4)
		{
			//˵���û�ϣ��ɾ����¼
			//1.�õ�ѧ����ID
			int rowNum=this.jt.getSelectedRow();//�����û����е���
			//����û�һ����û���򷵻�-1
			if(rowNum==-1)
			{
				//��ʾ
				JOptionPane.showMessageDialog(this, "��ѡ��һ��");
				return;
			}
			//�õ�ѧ�����
			String stuId=(String) smo.getValueAt(rowNum,0);
			String sql="delete from stu where stuId=?";
			String[] paras={stuId};
			StuModel temp=new StuModel();
			temp.updateStu(sql, paras);
			//System.out.println("�õ���Ҫɾ����ѧ���ı�ţ�"+stuId);
			//�������ݿ����ɾ������

			
			//���»���µ�����ģ��
			smo=new StuModel();
			String[] paras2={"1"};
			smo.queryStu("select *from stu where 1=?", paras2);
			//����JTabel
			jt.setModel(smo);
		}
	}
}


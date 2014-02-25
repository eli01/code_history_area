//�޸ĶԻ���
package StudentsManager2;
import java.awt.*;
//import java.awt.event;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.*;
import java.sql.*;

public class StuUpdate extends JDialog implements ActionListener{
	JLabel jl1,jl2,jl3,jl4,jl5,jl6;
	JButton jb1,jb2;
	JTextField jtf1,jtf2,jtf3,jtf4,jtf5,jtf6;
	JPanel jp1,jp2,jp3;
	//Frame�����ڡ�String������������ģʽ
	public StuUpdate (Frame owner,String title,boolean modal,StuModel sm,int rowNums)
	{
		super(owner,title,modal);//���ø��๹�췽����ʼ������ģ̬
		//��ʼ�����ĸ������
		jl1=new JLabel("stuId");
		jl2=new JLabel("stuName");
		jl3=new JLabel("stuSex");
		jl4=new JLabel("stuAge");
		jl5=new JLabel("stuJg");
		jl6=new JLabel("stuDept");
		
		jtf1=new JTextField();
		jtf2=new JTextField();
		jtf3=new JTextField();
		jtf4=new JTextField();
		jtf5=new JTextField();
		jtf6=new JTextField();
		//��ʼ���ı���
		jtf1.setText((String)sm.getValueAt(rowNums,0));//��objectתΪString
		jtf1.setEditable(false);//������ֹ�޸�
		jtf2.setText((String)sm.getValueAt(rowNums,1));
		jtf3.setText((String)sm.getValueAt(rowNums,2));
		//jtf4.setText((String)sm.getValueAt(rowNums,3));
		jtf4.setText(sm.getValueAt(rowNums,3).toString());
		jtf5.setText((String)sm.getValueAt(rowNums,4));
		jtf6.setText((String)sm.getValueAt(rowNums,5));
		
		jp1=new JPanel();
		jp2=new JPanel();
		jp3=new JPanel();
		
		jb1=new JButton("�޸�");
		jb2=new JButton("ȡ��");
		
		//���ò��ֹ�����,jp3Ĭ��Ϊ��ʽ����
		jp1.setLayout(new GridLayout(6,1));
		jp2.setLayout(new GridLayout(6,1));
		
		
		//������
		jp1.add(jl1);
		jp1.add(jl2);
		jp1.add(jl3);
		jp1.add(jl4);
		jp1.add(jl5);
		jp1.add(jl6);
		
		jp2.add(jtf1);
		jp2.add(jtf2);
		jp2.add(jtf3);
		jp2.add(jtf4);
		jp2.add(jtf5);
		jp2.add(jtf6);
		
		jp3.add(jb1);
		jp3.add(jb2);
		
		this.add(jp1,BorderLayout.WEST);
		this.add(jp2,BorderLayout.CENTER);
		this.add(jp3,BorderLayout.SOUTH);
		
		//ע�����
		jb1.addActionListener(this);
		jb2.addActionListener(this);
		//չʾ
		this.setSize(400,300);
		this.setLocation(400,400);
		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);									
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==jb1)
		{
			String sql="update stu set stuName=?,"+
		"stuSex=?,stuAge=?,stuJg=?,stuDept=? where stuId=?";
			String []paras={jtf2.getText(),jtf3.getText(),jtf4.getText(),jtf5.getText(),jtf6.getText(),jtf1.getText()};
			StuModel temp=new StuModel();//����ʵ���Ĺ����е����˹��췽�������췽��ͬʱ������init(),�����ݿ�����������������д��Ż�
			temp.updateStu(sql, paras);
			this.dispose();
		}else if(e.getSource()==jb2)
		{
			this.dispose();
		}
	}
}


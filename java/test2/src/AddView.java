/**
 * ���ߣ�mengqingshen
 * ʱ�䣺2012.11.28/14:51
 * ���ܣ����û������Ӳ���ʱ���öԻ������������Ӳ���
 * ��־����Ϊ�öԻ����߼�����orderManager���panel���ӶԻ����ڣ������췽����ȴ��������һ��panel��һ��dialog��
 * �����ڣ�Ϊ������������ڸ���orderManager�е�table,�����һ��ȳ�����orderManager����������ڵġ���ӡ���ť
 */

import javax.swing.*;

//import com.FixedWaterSystem.Model.*;

import java.awt.*;
import java.awt.event.*;
import java.util.Vector;

public class AddView extends JDialog implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
/*	
	//������Ҫ�����
	Vector<JLabel> jlabel=new Vector<JLabel>();
	Vector<JTextField> jtf=new Vector<JTextField>();
	JButton confirm,cancel;
	OrderModel ordermodel;
	JPanel jp1,jp2,jp3;

	public AddView()
	{
		//��ͨ��orderModel�����Ҫ������
		ordermodel=new OrderModel();
		String sql="select*from orderForm where 1=?";
		String paras[]={"1"};
		ordermodel.query(sql, paras);//���Ƕ���orderby�Ѿ������õ�������
		//�������
		int columnNum=ordermodel.getColumnCount();
		for(int i=0;i<columnNum;i++)//�������
		{
			//String temp=ordermodel.getColumnName(i+1);
			JTextField jtftemp=new JTextField();
			JLabel temp=new JLabel(ordermodel.getColumnName(i+1));//���õõ�����������JLabel
			jlabel.add(temp);	
			jtf.add(jtftemp);//���õõ�����������JTextField
		}
		confirm=new JButton("���");
		cancel=new JButton("ȡ��");
		
		//���ü���
		confirm.addActionListener(this);
		
		//���ò��ֹ�����,jp3Ĭ��Ϊ��ʽ����
		jp1.setLayout(new GridLayout(11,1));
		jp2.setLayout(new GridLayout(11,1));
		
		//������
		for(int i=0;i<columnNum;i++)
		{
			jp1.add(jlabel.get(i+1));
			jp2.add(jtf.get(i+1));
		}
		//������
		jp3.add(confirm);//Ĭ��������
		jp3.add(cancel);
		
		//��ӵ��Ի���
		this.add(jp1,"West");
		this.add(jp2,"Center");
		this.add(jp3,"South");
		
		//��ӵ��Ի���
		this.add(jp1,"West");
		this.add(jp2,"Center");
		this.add(jp3,"South");
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
*/
}

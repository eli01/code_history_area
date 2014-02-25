/**
 * 作者：mengqingshen
 * 时间：2012.11.28/14:51
 * 功能：当用户点击添加操作时，该对话框跳出完成添加操作
 * 日志：因为该对话框逻辑上是orderManager这个panel的子对话窗口，但构造方法中却不允许让一个panel作一个dialog的
 * 父窗口，为了能在这个窗口更新orderManager中的table,下面我会先尝试让orderManager监听这个窗口的“添加”按钮
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
	//定义需要的组件
	Vector<JLabel> jlabel=new Vector<JLabel>();
	Vector<JTextField> jtf=new Vector<JTextField>();
	JButton confirm,cancel;
	OrderModel ordermodel;
	JPanel jp1,jp2,jp3;

	public AddView()
	{
		//先通过orderModel获得需要的列名
		ordermodel=new OrderModel();
		String sql="select*from orderForm where 1=?";
		String paras[]={"1"};
		ordermodel.query(sql, paras);//这是对象orderby已经可以拿到列名了
		//创建组件
		int columnNum=ordermodel.getColumnCount();
		for(int i=0;i<columnNum;i++)//获得列数
		{
			//String temp=ordermodel.getColumnName(i+1);
			JTextField jtftemp=new JTextField();
			JLabel temp=new JLabel(ordermodel.getColumnName(i+1));//利用得到的列名创建JLabel
			jlabel.add(temp);	
			jtf.add(jtftemp);//利用得到的列数创建JTextField
		}
		confirm=new JButton("添加");
		cancel=new JButton("取消");
		
		//设置监听
		confirm.addActionListener(this);
		
		//设置布局管理器,jp3默认为流式布局
		jp1.setLayout(new GridLayout(11,1));
		jp2.setLayout(new GridLayout(11,1));
		
		//添加组件
		for(int i=0;i<columnNum;i++)
		{
			jp1.add(jlabel.get(i+1));
			jp2.add(jtf.get(i+1));
		}
		//添加组件
		jp3.add(confirm);//默认流布局
		jp3.add(cancel);
		
		//添加到对话框
		this.add(jp1,"West");
		this.add(jp2,"Center");
		this.add(jp3,"South");
		
		//添加到对话框
		this.add(jp1,"West");
		this.add(jp2,"Center");
		this.add(jp3,"South");
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
*/
}

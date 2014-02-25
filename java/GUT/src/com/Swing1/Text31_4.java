package com.Swing1;
import java.awt.*;
import javax.swing.*;
public class Text31_4 extends JFrame{

	//定义组件
	JPanel jp1,jp2;
	JLabel jl1,jl2;
	JComboBox jcb;
	JList jlt;
	JScrollPane jsp;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Text31_4 text=new Text31_4();
	}
	//构造函数
	public Text31_4()
	{
		//创建组件
		jp1=new JPanel();
		jp2=new JPanel();
		
		jl1=new JLabel("你的籍贯是");
		jl2=new JLabel("你喜欢去的地区");
		String []s1=new String[]{"北京","上海","三东","广西","云南","西藏"};
		jcb=new JComboBox(s1);
		String []s2=new String[]{"九寨沟","秦皇岛","巴黎","东京","纽约","荷兰"};
		jlt=new JList(s2);
		jlt.setVisibleRowCount(2);
		jsp=new JScrollPane(jlt);
		
		
		//设置布局管理器
		this.setLayout(new GridLayout(2,1));
		//添加组件
		jp1.add(jl1);
		jp1.add(jcb);
		
		jp2.add(jl2);
		jp2.add(jsp);
		//加入JFrame
		this.add(jp1);
		this.add(jp2);
		//设置窗口属性
		this.setSize(300,200);
		this.setLocation(300,300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("用户调查");
		//显示
		this.setVisible(true);
		
		
	}

}

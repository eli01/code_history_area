package com.Swing1;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
public class Jishiben extends JFrame implements ActionListener{
	//创建组件
	JMenuBar jmb;
	//JMenu jm[];//=new JMenu[5];
	//JMenuItem jmi[];//1,jmi2,jmi3,jmi4,jmi5,jmi6;
	JMenu xinjian;
	JMenuItem jmi1,jmi2;
	JTextArea jta;
	JToolBar jtb;
	//JButton jb1,jb2,jb3,jb4,jb5,jb6;
	JScrollPane jsp;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Jishiben j=new Jishiben();
	}
	
	public Jishiben()
	{
		//创建组件
		jmb=new JMenuBar();
		JMenu jm[]={new JMenu("文件(F)"),new JMenu("编辑(E)"),new JMenu("格式(O)"),new JMenu("查看(V)"),new JMenu("帮助(H)")};
		//为菜单设置助记符
	    jm[0].setMnemonic('F');
	    jm[1].setMnemonic('E');
	    jm[2].setMnemonic('O');
	    jm[3].setMnemonic('V');
	    jm[4].setMnemonic('H');
	    //菜单添加分割线
	    for(int i=0;i<jm.length;i++)
	    {
	    	jm[i].addSeparator();
	    }
		JMenuItem jmi[]={new JMenuItem("打开"),new JMenuItem("保存"),new JMenuItem("另存为"),new JMenuItem("页面设置"),new JMenuItem("打印"),new JMenuItem("退出")};
		
		jmi[0].addActionListener(this);//注册监听
		jmi[0].setActionCommand("open");//设置监听命令
		
		jmi[1].addActionListener(this);//注册监听
		jmi[1].setActionCommand("save");//设置监听命令
		
		xinjian=new JMenu("新建（A）");
		//二级子菜单项
		jmi1=new JMenuItem("文件");
		jmi2=new JMenuItem("工程");
		//文本区
		jta=new JTextArea();
		//为文本区创建滚动条
		jsp=new JScrollPane(jta);
		//创建工具条
		jtb=new JToolBar();
		//创建工具按钮
		JButton[] jb={new JButton(new ImageIcon("images/打开.png")),new JButton(new ImageIcon("images/保存.png")),new JButton(new ImageIcon("images/粘贴.png")),new JButton(new ImageIcon("images/剪切.png")),new JButton(new ImageIcon("images/复制.png")),new JButton(new ImageIcon("images/新建.png"))};
		//为jb设置提示信息
		jb[0].setToolTipText("打开");
		jb[0].addActionListener(this);//注册监听
		jb[0].setActionCommand("open");//设置监听命令
		
		jb[1].setToolTipText("保存");
		jb[1].addActionListener(this);//注册监听
		jb[1].setActionCommand("save");//设置监听命令
		
		jb[2].setToolTipText("粘贴");
		jb[3].setToolTipText("剪切");
		jb[4].setToolTipText("复制");
		jb[5].setToolTipText("新建");
		//设置布局
		
		//添加组件
		//为菜单条添加菜单
		for(int i=0;i<jm.length;i++)
		{
			jmb.add(jm[i]);
		}
		//为菜单添加菜单项
		jm[0].add(xinjian);
		for(int i=0;i<jmi.length;i++)
		{
			jm[0].add(jmi[i]);
		}
		//为子菜单添加二级菜单项
		xinjian.add(jmi1);
		xinjian.add(jmi2);
		//为工具栏添加工具按钮
		for(int i=0;i<jb.length;i++)
		{
			jtb.add(jb[i]);
		}
		//将菜单条添加到窗体上
		this.setJMenuBar(jmb);
		//将工具条添加到窗体上
		this.add(jtb,BorderLayout.NORTH);
		this.add(jsp);
		jsp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		
		//展现
		
		this.setTitle("记事本");
		ImageIcon imi=new ImageIcon("images/title.png");//給窗头设置图标
		this.setIconImage(imi.getImage());
		this.setSize(800,600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		//判断那个菜单被选中
		if(e.getActionCommand().equals("open"))
		{
			//System.out.println("open file");
			//文件选择组件
			JFileChooser jfc1=new JFileChooser();
			//设置名字
			jfc1.setDialogTitle("请选择文件");
			//设置默认
			jfc1.showOpenDialog(null);
			//显示
			jfc1.setVisible(true);
			//得到用户选择的文件路径
			String filename=jfc1.getSelectedFile().getAbsolutePath();
			
			BufferedReader br=null;
			FileReader fr=null;
			//BufferedWriter bw=null;
			//先创建一个file对象
			
			try {
				fr=new FileReader(filename);
				br=new BufferedReader(fr);
				//FileWriter fw=new FileWriter("d:/bbb.txt");
				//bw=new BufferedWriter(fw); 
				//从文件中循环读取文件
				String s="";
				String allString="";
				while((s=br.readLine())!=null)
				{
					allString+=s+"\r\n";				
				}
				//放置到jta
				jta.setText(allString);
				
			} catch (Exception e4){
				// TODO Auto-generated catch block
				e4.printStackTrace();
			}finally{
				try {
					br.close();
					fr.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				//bw.close();
			}
		}else if(e.getActionCommand().equals("save"))
		{
			//出现保存对话框
			JFileChooser jfc2=new JFileChooser();
			jfc2.setDialogTitle("另存为……");
			//按默认方式显示
			jfc2.showSaveDialog(null);
			jfc2.setVisible(true);
			//获得选择保存的路径
			String filename=jfc2.getSelectedFile().getAbsolutePath();
			FileWriter fw=null;
			BufferedWriter bw=null;
			try{
				fw=new FileWriter(filename);
				bw=new BufferedWriter(fw);
		
				bw.write(this.jta.getText());
			}catch(Exception e2){
				e2.printStackTrace();
			}finally{
				try {
					fw.close();
					bw.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
			}
		}
		
	}
}

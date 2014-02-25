package MyServer3;
import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.*;
public class MyServer3 extends JFrame implements ActionListener{

	/**
	 * @param args
	 */
	JTextArea jta=null;
	JTextField jtf=null;
	JButton jb=null;
	JPanel jp1=null;
	JScrollPane jsp=null;
	PrintWriter pw=null;//把信息发给客户端的对象
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyServer3 ms3=new MyServer3();
	}
	//构造函数
	public MyServer3()
	{
		//创建组件
		jtf=new JTextField(20);
		jta=new JTextArea();
		jb=new JButton("发送");
		jsp=new JScrollPane(jta);
		jp1=new JPanel();//默认流布局
		//添加组件
		jp1.add(jtf);
		jp1.add(jb);
		this.add(jsp,"Center");
		this.add(jp1,"South");
		//设置窗口
		this.setSize(400,300);
		this.setLocation(200,200);
		this.setVisible(true);
		this.setTitle("服务器端对话窗口");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		try {
			//服务器监听
			ServerSocket ss=new ServerSocket(9998);
			//等待连接
			Socket s=ss.accept();
			
			InputStreamReader isr=new InputStreamReader(s.getInputStream());
			BufferedReader br=new BufferedReader(isr);
			pw=new PrintWriter(s.getOutputStream(),true);
			//读取从客户端发来的信息
			while(true)
			{
				String info=br.readLine();
				jta.setText(info);
			}
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==jb)
		{
			
		}
	}

}

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
	PrintWriter pw=null;//����Ϣ�����ͻ��˵Ķ���
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyServer3 ms3=new MyServer3();
	}
	//���캯��
	public MyServer3()
	{
		//�������
		jtf=new JTextField(20);
		jta=new JTextArea();
		jb=new JButton("����");
		jsp=new JScrollPane(jta);
		jp1=new JPanel();//Ĭ��������
		//������
		jp1.add(jtf);
		jp1.add(jb);
		this.add(jsp,"Center");
		this.add(jp1,"South");
		//���ô���
		this.setSize(400,300);
		this.setLocation(200,200);
		this.setVisible(true);
		this.setTitle("�������˶Ի�����");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		try {
			//����������
			ServerSocket ss=new ServerSocket(9998);
			//�ȴ�����
			Socket s=ss.accept();
			
			InputStreamReader isr=new InputStreamReader(s.getInputStream());
			BufferedReader br=new BufferedReader(isr);
			pw=new PrintWriter(s.getOutputStream(),true);
			//��ȡ�ӿͻ��˷�������Ϣ
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

package com.Swing1;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
public class Jishiben extends JFrame implements ActionListener{
	//�������
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
		//�������
		jmb=new JMenuBar();
		JMenu jm[]={new JMenu("�ļ�(F)"),new JMenu("�༭(E)"),new JMenu("��ʽ(O)"),new JMenu("�鿴(V)"),new JMenu("����(H)")};
		//Ϊ�˵��������Ƿ�
	    jm[0].setMnemonic('F');
	    jm[1].setMnemonic('E');
	    jm[2].setMnemonic('O');
	    jm[3].setMnemonic('V');
	    jm[4].setMnemonic('H');
	    //�˵���ӷָ���
	    for(int i=0;i<jm.length;i++)
	    {
	    	jm[i].addSeparator();
	    }
		JMenuItem jmi[]={new JMenuItem("��"),new JMenuItem("����"),new JMenuItem("���Ϊ"),new JMenuItem("ҳ������"),new JMenuItem("��ӡ"),new JMenuItem("�˳�")};
		
		jmi[0].addActionListener(this);//ע�����
		jmi[0].setActionCommand("open");//���ü�������
		
		jmi[1].addActionListener(this);//ע�����
		jmi[1].setActionCommand("save");//���ü�������
		
		xinjian=new JMenu("�½���A��");
		//�����Ӳ˵���
		jmi1=new JMenuItem("�ļ�");
		jmi2=new JMenuItem("����");
		//�ı���
		jta=new JTextArea();
		//Ϊ�ı�������������
		jsp=new JScrollPane(jta);
		//����������
		jtb=new JToolBar();
		//�������߰�ť
		JButton[] jb={new JButton(new ImageIcon("images/��.png")),new JButton(new ImageIcon("images/����.png")),new JButton(new ImageIcon("images/ճ��.png")),new JButton(new ImageIcon("images/����.png")),new JButton(new ImageIcon("images/����.png")),new JButton(new ImageIcon("images/�½�.png"))};
		//Ϊjb������ʾ��Ϣ
		jb[0].setToolTipText("��");
		jb[0].addActionListener(this);//ע�����
		jb[0].setActionCommand("open");//���ü�������
		
		jb[1].setToolTipText("����");
		jb[1].addActionListener(this);//ע�����
		jb[1].setActionCommand("save");//���ü�������
		
		jb[2].setToolTipText("ճ��");
		jb[3].setToolTipText("����");
		jb[4].setToolTipText("����");
		jb[5].setToolTipText("�½�");
		//���ò���
		
		//������
		//Ϊ�˵�����Ӳ˵�
		for(int i=0;i<jm.length;i++)
		{
			jmb.add(jm[i]);
		}
		//Ϊ�˵���Ӳ˵���
		jm[0].add(xinjian);
		for(int i=0;i<jmi.length;i++)
		{
			jm[0].add(jmi[i]);
		}
		//Ϊ�Ӳ˵���Ӷ����˵���
		xinjian.add(jmi1);
		xinjian.add(jmi2);
		//Ϊ��������ӹ��߰�ť
		for(int i=0;i<jb.length;i++)
		{
			jtb.add(jb[i]);
		}
		//���˵�����ӵ�������
		this.setJMenuBar(jmb);
		//����������ӵ�������
		this.add(jtb,BorderLayout.NORTH);
		this.add(jsp);
		jsp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		
		//չ��
		
		this.setTitle("���±�");
		ImageIcon imi=new ImageIcon("images/title.png");//�o��ͷ����ͼ��
		this.setIconImage(imi.getImage());
		this.setSize(800,600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		//�ж��Ǹ��˵���ѡ��
		if(e.getActionCommand().equals("open"))
		{
			//System.out.println("open file");
			//�ļ�ѡ�����
			JFileChooser jfc1=new JFileChooser();
			//��������
			jfc1.setDialogTitle("��ѡ���ļ�");
			//����Ĭ��
			jfc1.showOpenDialog(null);
			//��ʾ
			jfc1.setVisible(true);
			//�õ��û�ѡ����ļ�·��
			String filename=jfc1.getSelectedFile().getAbsolutePath();
			
			BufferedReader br=null;
			FileReader fr=null;
			//BufferedWriter bw=null;
			//�ȴ���һ��file����
			
			try {
				fr=new FileReader(filename);
				br=new BufferedReader(fr);
				//FileWriter fw=new FileWriter("d:/bbb.txt");
				//bw=new BufferedWriter(fw); 
				//���ļ���ѭ����ȡ�ļ�
				String s="";
				String allString="";
				while((s=br.readLine())!=null)
				{
					allString+=s+"\r\n";				
				}
				//���õ�jta
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
			//���ֱ���Ի���
			JFileChooser jfc2=new JFileChooser();
			jfc2.setDialogTitle("���Ϊ����");
			//��Ĭ�Ϸ�ʽ��ʾ
			jfc2.showSaveDialog(null);
			jfc2.setVisible(true);
			//���ѡ�񱣴��·��
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

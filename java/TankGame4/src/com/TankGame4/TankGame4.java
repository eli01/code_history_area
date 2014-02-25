/**
 *TankGame4.0
 * ���ܣ�
 * 1:����̹��
 * 2�����������ƶ�
 * 3�����Է����ӵ�
 * 4.���˱��һ���ʱ��ʧ������ը��
 * 5.�ұ����˻���ʱ��ʧ������ը��
 * 6.����̹�˻��໥����
 * 7.���ùؿ�
 *  7.1��һ����ʼ��panel
 * 8.������;��ͣ
 *  8.1���û������ͣʱ���ӵ���̹�˵��ٶ���Ϊ�㣬��ά�ַ��򲻱�
 * 9.���Լ�¼��ҳɼ�
 *  9.1���ļ���
 *  9.2��дһ�����¼��ҵ�����
 *  9.3�ȱ�����ٵ���̹������
 *  9.4�����˳�
 * 10.�������ֱ���
 */
package com.TankGame4;
import java.awt.event.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import javax.imageio.ImageIO;
import javax.swing.*;
public class TankGame4 extends JFrame implements ActionListener{
	static int XL=1100;
	static int YL=740;
	final static int GXL=840;
	final static int GYL=660;
	//����һ����ʼ�����
	startPanel sp=null;
	//�����ҵ����
	MyPanel mp=null;
	JMenuBar jmb=null;//�����˵�
	JMenu jm1,jm2,jm3;
	JMenuItem jmi1,jmi2,jmi3,jmi4;
	JButton jb1,jb2,jb3,jb4,jb5;
	JToolBar jtb;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TankGame4 tank1=new TankGame4();
	}
	//���캯��
	public TankGame4()
	{
		//�������
		jmb=new JMenuBar();
		jm1=new JMenu("��Ϸ(G)");//��Ϸ�˵�
		jm1.setMnemonic('G');//��Ϸ�˵������Ƿ���G
		jmi1=new JMenuItem("����Ϸ(N)");//�˵������Ϸ��
		jmi1.addActionListener(this);
		jmi1.setActionCommand("newGame");
		jmi2=new JMenuItem("������Ϸ");
		jmi2.addActionListener(this);
		jmi2.setActionCommand("continue");
		jmi3=new JMenuItem("�˳�(E)");
		jmi3.addActionListener(this);
		jmi3.setActionCommand("exit");
		jmi4=new JMenuItem("�����˳�(R)");
		jmi4.addActionListener(this);
		jmi4.setActionCommand("saveandexit");
		jtb=new JToolBar();//����������
		jb1=new JButton(new ImageIcon("images/����Ϸ.png"));
		jb2=new JButton(new ImageIcon("images/����.png"));
		jb3=new JButton(new ImageIcon("images/�˳�.png"));
		jb4=new JButton(new ImageIcon("images/����.png"));
		jb5=new JButton(new ImageIcon("images/����.png"));
		//Ϊjb������ʾ��Ϣ
		jb1.setToolTipText("����Ϸ");
		jb1.addActionListener(this);//ע�����
		jb1.setActionCommand("newGame");//���ü�������
//		
		jb5.setToolTipText("������Ϸ");
		jb5.addActionListener(this);//ע�����
		jb5.setActionCommand("continue");//���ü�������
//		
		jb3.setToolTipText("�˳�");
		jb3.addActionListener(this);
		jb3.setActionCommand("exit");
//		//jb[3].setToolTipText("����");
		jb2.setToolTipText("�˳�����");
		jb2.addActionListener(this);
		jb2.setActionCommand("saveandexit");
		jb4.setToolTipText("����");
		//������
		jm1.add(jmi1);
		jm1.add(jmi2);
		jm1.add(jmi3);
		jm1.add(jmi4);
		jmb.add(jm1);
		jtb.add(jb1);
		jtb.add(jb5);
		jtb.add(jb2);
		jtb.add(jb3);
		jtb.add(jb4);
		sp=new startPanel();
		this.add(sp);
		Thread t=new Thread(sp);
		t.start();
	
		//this.add(jtb,BorderLayout.SOUTH);
		this.setJMenuBar(jmb);
		this.setSize(XL,YL);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().equals("newGame"))//����˵�������ս��
		{
		
			mp=new MyPanel("newGame");	
			this.remove(sp);//����ʼ���ɾ��
			this.add(mp);
			Thread t=new Thread(mp);
			t.start();//����mp�߳�
			this.addKeyListener(mp);
			this.setVisible(true);//ˢ����ʾ�����
		}else if(e.getActionCommand().equals("exit")){
			//�û�������˳�ϵͳ
			//������ٵ���̹�˵�����
			Recorder.keepRecord();
			System.exit(0);
		}else if(e.getActionCommand().equals("continue")){
			//Recorder.readRecord();
			//System.out.println("12345");
			mp=new MyPanel("continue");
			
			this.remove(sp);//����ʼ���ɾ��
			this.add(mp);
			Thread t=new Thread(mp);
			t.start();//����mp�߳�
			this.addKeyListener(mp);
			this.setVisible(true);//ˢ����ʾ�����
		}else if(e.getActionCommand().equals("saveandexit"))
		{
			Recorder rd=new Recorder();
			rd.setEts(mp.ets);
			rd.saveAndExit();
		}
		
	}	
}
class Node
{
	int x=0;
	int y=0;
	int direct=0;
	public Node(int x,int y,int direct)
	{
		this.x=x;
		this.y=y;
		this.direct=direct;
	}
}
class Recorder
{
	//��¼ÿ���ж��ٵ���
	private static int enSize=10;
	private static int myLife=3;
	private static int distroyEnemyNum=0;
	private static BufferedWriter bw=null;
	private static FileWriter fw=null;
	private static BufferedReader br=null;
	private static FileReader fr=null;
	private static Vector<EnemyTanks> ets=null;
	static Vector<Node> nodes=new Vector<Node>();
	public Vector<EnemyTanks> getEts() {
		return ets;
	}
	public void setEts(Vector<EnemyTanks> ets) {
		this.ets = ets;
	}
	public  void saveAndExit()
	{
//		File f2=new File("d:/TankGame4_saveAll.txt");
//		if(!f2.exists())
//		{
//			try {
//				f2.createNewFile();
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}else{
//			System.out.println("���ļ��Ѵ��ڣ�");
//		}
		try {
			fw=new FileWriter("d:/TankGame4_saveAll.txt");
     	    bw=new BufferedWriter(fw);
		    bw.write(distroyEnemyNum+"\r\n");
			for(int i=0;i<ets.size();i++)
			{
				EnemyTanks et=ets.get(i);
				if(et.isAlive)
				{
					String info=et.x+" "+et.y+" "+et.direct;
					//д�뵽�ļ�
					bw.write(info+"\r\n");
				}
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				bw.close();
				fw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	
		System.exit(0);
	}
	public Vector<Node>  readRecord()//��ȡ�ļ��е�����
	{
		try {
			fr=new FileReader("d:/TankGame4_saveAll.txt");
			br=new BufferedReader(fr);
			
			String n="";
			n=br.readLine();		
			distroyEnemyNum=Integer.parseInt(n);
			while((n=br.readLine())!=null)
			{
				String []threePart=n.split(" ");
				Node node=new Node(Integer.parseInt(threePart[0]),Integer.parseInt(threePart[1]),Integer.parseInt(threePart[2]));
				nodes.add(node);
			}
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				br.close();
				fr.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return nodes;
	}
	public static void keepRecord()//�������ݵ��ļ�
	{
		File f2=new File("d:/TankGame4.txt");
		if(!f2.exists())
		{
			try {
				f2.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{
			//System.out.println("���ļ��Ѵ��ڣ�");
		}
		try {
			fw=new FileWriter("d:/TankGame4.txt");
			bw=new BufferedWriter(fw);
			bw.write(distroyEnemyNum+"\r\n");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				bw.close();
				fw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	public static int getDistroyEnemyNum() {
		return distroyEnemyNum;
	}
	public static void setDistroyEnemyNum(int distroyEnemyNum) {
		Recorder.distroyEnemyNum = distroyEnemyNum;
	}
	public static int getEnSize() {
		return enSize;
	}
	public static void setEnSize(int enSize) {
		Recorder.enSize = enSize;
	}
	public static int getMyLife() {
		return myLife;
	}
	public static void setMyLife(int myLife) {
		Recorder.myLife = myLife;
	}

	public static void reduceEnsize()
	{
		enSize--;
	}
	public static void increaseDistroy()
	{
		distroyEnemyNum++;
	}
	public static void reduceMyLife()
	{
		myLife--;
	}
}
//���ÿ�ʼ��壬����ʾ����

class startPanel extends JPanel implements Runnable
{
	int times=0;
	public void paint(Graphics g)
	{
		super.paint(g);
		
		g.fillRect(0, 0, TankGame4.XL, TankGame4.YL);
		
		//��ʾ��Ϣ
		if(times%2==0)
		{
			g.setColor(Color.yellow);
			Font myFont=new Font("����",Font.ITALIC,50);
			g.setFont(myFont);
			g.drawString("stage 1", 260, 300);
		}
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true)
		{
			try {
				Thread.sleep(50);//�����˸Ч��
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(times<100)
			{
				//System.out.println(times);
				this.times++;
			}else{
				this.times=0;
			}
			this.repaint();
			
		}
		
	}
}
//�ҵ����
class MyPanel extends JPanel implements KeyListener,Runnable
{
	//final float r2=3.6f*3.6f;//̹�˵�ֱ��13.7����̹�˿���һ��Բ��
	//�����ҵ�̹����
	MyTank mytank=null;
	Vector<MyTank> mytanks=new Vector<MyTank>();
	Vector<Node> nodes=new Vector<Node>();
	//������˵�̹����
	Vector<EnemyTanks> ets=new Vector<EnemyTanks>();
	//����̹�˵�����
	int enSize=Recorder.getEnSize();	
	Image image1=null;
	Image image2=null;
	Image image3=null;
	Vector<Bomb> bombs;//�����ҵ��ڵ�����
	public MyPanel(String flag)
	{
		
		mytank=new MyTank(600,600);//��ʼ���ҵ�̹�ˣ���̹��һ����ʼλ��
		//��ʼ�����˵�̹��
		if(flag.equals("newGame"))
		{
			for(int i=0;i<enSize;i++)
			{
				//����һ�����˵�̹�˶���
				EnemyTanks et=new EnemyTanks((i+1)*70,100);
				et.fire();	
				et.setColor(1);
				et.setDirect(1);
				et.setSpeed(10);
				ets.add(et);//����Vector			
				et.setEts(ets);//��mypanel�ϵ�̹�˽����õ���̹��
				Thread t=new Thread(et);
				t.start();		
				Shot s=new Shot(et.x+9,et.y+30,1);//���������һ���ӵ�			
				et.ss.add(s);//�������̹��
				Thread t2=new Thread(s);
				t2.start();
			}
		}else 
		{
			nodes=new Recorder().readRecord();
			for(int i=0;i<nodes.size();i++)
			{
				//����һ�����˵�̹�˶���
			
				Node node=nodes.get(i);
				EnemyTanks et=new EnemyTanks(node.x,node.y);
				et.fire();	
				et.setColor(1);
				et.setDirect(node.direct);
				et.setSpeed(10);
				ets.add(et);//����Vector			
				et.setEts(ets);//��mypanel�ϵ�̹�˽����õ���̹��
				Thread t=new Thread(et);
				t.start();		
				Shot s=new Shot(et.x+9,et.y+30,1);//���������һ���ӵ�			
				et.ss.add(s);//�������̹��
				Thread t2=new Thread(s);
				t2.start();
			}
		}
	
		bombs=new Vector<Bomb>();//��ʼ���ҵ��ڵ�����
		
		//��ʼ��ͼƬ
		try {
			image1=ImageIO.read(new File("D:/Users/Neo/Workspaces/MyEclipse 10/TankGame3/src/b1.gif"));
			image2=ImageIO.read(new File("D:/Users/Neo/Workspaces/MyEclipse 10/TankGame3/src/b2.gif"));
			image3=ImageIO.read(new File("D:/Users/Neo/Workspaces/MyEclipse 10/TankGame3/src/b3.gif"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		image1=Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/��ը1.png"));
//		image2=Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/��ը2.png"));
//		image3=Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/��ը3.png"));
	}
	public void showStateInfo(Graphics g)
	{
		g.setColor(Color.darkGray);
		g.fillRect(0,0,TankGame4.GXL,TankGame4.GYL);//��Ϸ����
		//g.fillRect(0,TankGame4.GYL,TankGame4.XL,TankGame4.YL);//��ʾ����ɫ
		this.drawTank(TankGame4.GXL+10, 50, g, 0, 1, true);//������ʾ��Ϣ̹��(����)����̹�˲�����ս��
		g.setColor(Color.BLACK);
		g.drawString(Recorder.getEnSize()+2+"", TankGame4.GXL+10, 120);
		this.drawTank(TankGame4.GXL+10, 170, g, 0, 0, true);
		g.setColor(Color.BLACK);
		g.drawString(Recorder.getMyLife()+"", TankGame4.GXL+14, 230);
		//������ҵ��ܳɼ�
		Font f=new Font("��Բ",Font.BOLD,15);//����ܳɼ�
		g.setColor(Color.darkGray);
		g.setFont(f);
		g.drawString("�����ܳɼ�:"+Recorder.getDistroyEnemyNum(),TankGame4.XL-150,20);
		int gEnemyNo=Recorder.getDistroyEnemyNum();
		int n=TankGame4.XL;
		for(int i=0;i<gEnemyNo;i++)
		{
			if(i*40<550)
			{
				this.drawTank(n-100,i*40+40, g,0, 1, true);
			}else{
				this.drawTank(n-160,i*40+40, g,0, 1, true);
			}
		
		}
	}
	public void paint(Graphics g)//��дpaint	
	{
		super.paint(g);	
		
		this.showStateInfo(g);//��״̬��Ϣ
		for(int i=0;i<ets.size();i++)
		{   		
			this.drawTank(ets.get(i).getX(), ets.get(i).getY(), g, ets.get(i).getDirect(), 1,ets.get(i).isAlive);//�������˵�̹��
			EnemyTanks et=ets.get(i);
			
			for(int j=0;j<et.ss.size();j++)
			{
				Shot enemyShot=et.ss.get(j);//ȡ���ӵ�
				if(enemyShot.isAlive)
				{
					g.draw3DRect(enemyShot.x,enemyShot.y, 1, 1,false);
				}
				else 
				{
					et.ss.remove(enemyShot);
				}
			}		
		}
		this.drawTank(mytank.getX(),mytank.getY(),g,mytank.getDirect(),0,mytank.isAlive);//�����ҵ�̹��
		//System.out.println("�����������ӵ�������97��"+ets.get(3).ss.size());
		//�����ҵ��ӵ�
		for(int i=0;i<mytank.ss.size();i++)
		{
			Shot myshot=mytank.ss.get(i);
			if((myshot!=null)&&(myshot.isAlive==true))
			{
				g.draw3DRect(myshot.x,myshot.y,1,1,false);
			}
			if(myshot.isAlive==false)
			{
				mytank.ss.remove(myshot);//��ss��ɾ�����ӵ�
			}
		}
		//�����ڵ�
		for(int i=0;i<bombs.size();i++)
		{
		
			//ȡ���ڵ�
			Bomb b=bombs.get(i);
			if(b.life>6)
			{
				g.drawImage(image1,b.x, b.y,30,30,this);
			}else if(b.life>3)
			{
				g.drawImage(image2,b.x, b.y, 30, 30,this);
			}else
			{
				g.drawImage(image3,b.x, b.y, 30, 30,this);
			}
			
			b.lifeDown();//��b������ֵ����
			if(b.life==0)
			{				
				bombs.remove(b);//����ڵ�����ΪֵΪ0���ͰѸ�ը����bombs������ȥ��
			}
		}
	
	}	
	//дһ�������ж�����̹���Ƿ���ײ,��ײ�޸�turn
//		public void haveCrash(EnemyTanks e1,EnemyTanks e2 )
//		{
//			
//					if(e1.direct==0)
//					{
//						if(e2.direct==1)
//						{
//							float chaX=e1.getX()-e2.getX();
//							float chaY=e2.getY()-e2.getY();
//							if(chaX*chaX+chaY*chaY<=this.r2)
//							{
//								e1.setY(e1.getY()-2);
//								
//								e2.setY(e2.getY()+2);
//								e2.setTurn(false);
//								e1.setTurn(false);
//							
//							}
//							
//						}else if(e1.direct==1)
//						{
//							if(e2.direct==1)
//							{
//								float chaX=e1.getX()-e2.getX();
//								float chaY=e2.getY()-e2.getY();
//								if(chaX*chaX+chaY*chaY<this.r2)
//								{
//									e1.setY(e1.getY()+2);
//								
//									e2.setY(e2.getY()-2);
//									e2.setTurn(false);
//									e1.setTurn(false);
//								}							
//							}
//						}else if(e1.direct==2)
//						{
//							if(e2.direct==3)
//							{
//								float chaX=e1.getX()-e2.getX();
//								float chaY=e2.getY()-e2.getY();
//								if(chaX*chaX+chaY*chaY<this.r2)
//								{
//									e1.setY(e1.getX()-2);
//								
//									e2.setY(e2.getX()+2);
//								    e2.setTurn(false);
//									e1.setTurn(false);
//								}							
//							}
//						}else
//						{
//							if(e2.direct==2)
//							{
//								float chaX=e1.getX()-e2.getX();
//								float chaY=e2.getY()-e2.getY();
//								if(chaX*chaX+chaY*chaY<this.r2)
//								{
//									e1.setY(e1.getX()+2);
//								
//									e2.setY(e2.getX()-2);
//									e2.setTurn(false);	
//									e1.setTurn(false);
//								}							
//							}
//						}
//					}
//				
//											
//			}
//	
//	//дһ�������жϵ��˵���������̹���Ƿ���ײ������haveCrash()����
//		public void judgeEnemyCrash()
//		{
//			EnemyTanks et1,et2;
//			for(int i=0;i<ets.size();i++)
//			{
//				for(int j=0;j<ets.size();j++)
//				{				
//					if(i!=j)
//					{
//						et1=ets.get(i);
//						et2=ets.get(j);
//						this.haveCrash(et1, et2);
//					
//					}								
//				}
//			}
//		}
	//
	
	
	//дһ��ר���жϵ���̹���Ƿ񱻻��еĺ���
	public void haveHitEnemy(Shot s,Tank t)
	{
		switch(t.getDirect())
		{
		case 0:
		case 1:
			if(s.x>t.x&&s.x<t.x+20&&s.y>t.y&&s.y<t.y+30)
			{
				s.setAlive(false);//�ӵ�����
				t.setAlive(false);//̹����ʧ
				Recorder.reduceEnsize();
				Recorder.increaseDistroy();
				Bomb b=new Bomb(t.getX(),t.getY());
				this.bombs.add(b);
			}
		case 2:
		case 3:
			if(s.x>t.x-5&&s.x<t.x+25&&s.y>t.y+5&&s.y<t.y+25)
			{
				s.setAlive(false);
				t.setAlive(false);
				Recorder.reduceEnsize();
				Recorder.increaseDistroy();
				Bomb b=new Bomb(t.getX(),t.getY());
				this.bombs.add(b);
			}
		}
	}
	public void haveHitMyTank(Shot s,Tank t)
	{
		switch(t.getDirect())
		{
		case 0:
		case 1:
			if(s.x>t.x&&s.x<t.x+20&&s.y>t.y&&s.y<t.y+30)
			{
				s.setAlive(false);//�ӵ�����				
				Recorder.reduceMyLife();//����ֵ��1
				if(Recorder.getMyLife()<=0)
				{
					t.setAlive(false);//̹����ʧ
				}
				Bomb b=new Bomb(t.getX(),t.getY());
				this.bombs.add(b);
			}
			break;
		case 2:
			
		case 3:
			if(s.x>t.x-5&&s.x<t.x+25&&s.y>t.y+5&&s.y<t.y+25)
			{
				s.setAlive(false);			
				Recorder.reduceMyLife();//����ֵ��1
				if(Recorder.getMyLife()<=0)
				{
					t.setAlive(false);//̹����ʧ
				}		
				Bomb b=new Bomb(t.getX(),t.getY());
				this.bombs.add(b);
			}
			break;
		}
	}
	public void hitEnemy()
	{
		//��ÿһ���ӵ���ÿһ�����˵�̹�����αȶ����꣬�����С��㽫̹�˺��ӵ�������isAlive����Ϊflase,��ͼʱ���޷�ͨ���ж�
		for(int i=0;i<mytank.ss.size();i++)
		{
			Shot myShot=mytank.ss.get(i);
			if(myShot.isAlive)
			{
				for(int j=0;j<ets.size();j++)
				{
					EnemyTanks et=ets.get(j);
					if(et.isAlive)
					{
						this.haveHitEnemy(myShot,et);
						
					}
						
				}
			}
		}
	}
	public void hitMyTank()
	{
		//���˵��ӵ����ҵ�λ�ñȶԣ��ж����Ƿ񱻻���
		for(int i=0;i<this.ets.size();i++)
		{
			EnemyTanks et=this.ets.get(i);
			for(int j=0;j<et.ss.size();j++)
			{
			
				Shot s=et.ss.get(j);
				if(this.mytank.isAlive)
				{
					this.haveHitMyTank(s,mytank);
					
				}
			}
		}
	}
	//����̹�˵ĺ���
	public void drawTank(int x,int y,Graphics g,int direct,int type,boolean isAlive)
		{
			if(isAlive)
			{
				//�ж�̹�˵�����
				switch(type)
				{
					case 0://�ҵ�̹��
						g.setColor(Color.cyan);
						break;
					case 1://���˵�̹��
						g.setColor(Color.yellow);
						break;
				}
				//�ж�̹�˵ķ���
				switch(direct)
				{
				case 0://����
					//�����ҵ�̹�ˣ���ʱ��װ��һ��������
					
				 //1.������ߵľ���
					g.fill3DRect(x,y ,5, 30, false);
					//2.�����ұߵľ���
					g.fill3DRect(x+15, y,5, 30, false);
					//3.�����м�ľ���
					g.fill3DRect(x+5, y+5,10, 20, false);
					//4.�����м��Բ
					g.fillOval(x+4, y+10,10,10);
					//5.������
					g.drawLine(x+9,y +15,x+9,y );
					break;
				case 1://����
					//�����ҵ�̹�ˣ���ʱ��װ��һ��������
					
				 //1.������ߵľ���
					g.fill3DRect(x,y ,5, 30, false);
					//2.�����ұߵľ���
					g.fill3DRect(x+15, y,5, 30, false);
					//3.�����м�ľ���
					g.fill3DRect(x+5, y+5,10, 20, false);
					//4.�����м��Բ
					g.fillOval(x+4, y+10,10,10);
					//5.������
					g.drawLine(x+9,y +15,x+9,y+30 );
					break;
				case 2://����
					//1.��������ľ���
					g.fill3DRect(x-5,y+5,30,5,false);
					//2.��������ľ���
					g.fill3DRect(x-5, y+20, 30, 5, false);
					//3.�����м�ľ���
					g.fill3DRect(x, y+10, 20, 10, false);
					//4.�����м��Բ
					g.fillOval(x+4,y+10,10,10);
					//5.����ֱ��
					g.drawLine(x+5,y+15,x-5,y+15);
					break;
				case 3://����
					//1.��������ľ���
					g.fill3DRect(x-5,y+5,30,5,false);
					//2.��������ľ���
					g.fill3DRect(x-5, y+20, 30, 5, false);
					//3.�����м�ľ���
					g.fill3DRect(x, y+10, 20, 10, false);
					//4.�����м��Բ
					g.fillOval(x+4,y+10,10,10);
					//5.����ֱ��
					g.drawLine(x+14,y+15,x+25,y+15);
					break;
					default:System.out.println("��ͼʱ���ֹ��ϣ��������");					
				}
			}

			
				
		}
		//����һ��ֵ�����
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
		
		}

		//�������� ����
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
			//System.out.println("������"+(char)e.getKeyCode());
			if(e.getKeyCode()==KeyEvent.VK_UP||e.getKeyCode()==KeyEvent.VK_W)
			{
				mytank.setDirect(0);
				this.mytank.moveUp();
				
			}else if(e.getKeyCode()==KeyEvent.VK_DOWN||e.getKeyCode()==KeyEvent.VK_S){
				this.mytank.setDirect(1);
				mytank.moveDown();
				
			}else if(e.getKeyCode()==KeyEvent.VK_RIGHT||e.getKeyCode()==KeyEvent.VK_D){
				this.mytank.setDirect(3);
				mytank.moveRight();
				
			}else if(e.getKeyCode()==KeyEvent.VK_LEFT||e.getKeyCode()==KeyEvent.VK_A){
				this.mytank.setDirect(2);
				mytank.moveLeft();
				
			}
			if(e.getKeyCode()==KeyEvent.VK_F)//�����Ұ���J��
			{
				if(this.mytank.ss.size()<3)
				{
					this.mytank.fire();		
				}								
			}
			//����repaint()�������ػ�
			this.repaint();
		}
		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void run() {
			// TODO Auto-generated method stub
			
			while(true)
			{
				try {
					Thread.sleep(50);	//ÿ��50�����ػ�һ��
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
				this.hitEnemy();
				this.hitMyTank();
				//this.judgeEnemyCrash();
				
				//���˵��ӵ����ҵ�λ�ñȶԣ��ж����Ƿ񱻻���
//				for(int i=0;i<this.ets.size();i++)
//				{
//					EnemyTanks et=this.ets.get(i);
//					for(int j=0;j<et.ss.size();j++)
//					{
//					
//						Shot s=et.ss.get(i);
//						if(this.mytank.isAlive)
//						{
//							switch(this.mytank.getDirect())
//							{
//							case 0:
//							case 1:
//								if(s.x>this.mytank.x&&s.x<this.mytank.x+20&&s.y>this.mytank.y&&s.y<this.mytank.y+30)
//								{
//									s.setAlive(false);//�ӵ�����
//									this.mytank.setAlive(false);//̹����ʧ
//									Bomb b=new Bomb(this.mytank.getX(),this.mytank.getY());
//									this.bombs.add(b);
//								}
//							case 2:
//							case 3:
//								if(s.x>this.mytank.x-5&&s.x<this.mytank.x+25&&s.y>this.mytank.y+5&&s.y<this.mytank.y+25)
//								{
//									s.setAlive(false);
//									this.mytank.setAlive(false);
//									Bomb b=new Bomb(this.mytank.getX(),this.mytank.getY());
//									this.bombs.add(b);
//								}
//							}
//						}
//					}
//				}
				//��δ�����Կ�������
//				//�ж��Ƿ���Ҫ��̹�˼����µ��ӵ�
//				//�ж��ӵ��Ƿ�û��
//			
//				for(int i=0;i<ets.size();i++)
//				{
//					EnemyTanks et=ets.get(i);
//					if(et.isAlive)
//					{
//						Shot s=null;
//						//û���ӵ�
//						//���
//						if(et.ss.size()==0)//����ӵ�������
//						{
//							switch(et.direct)
//							{
//							case 0:
//								s=new Shot(et.x+9,et.y,0);//����һ���ӵ�
//							    et.ss.add(s);//���ӵ���������
//								break;
//							case 1:
//								s=new Shot(et.x+9,et.y+30,1);
//								et.ss.add(s);
//								break;
//							case 2:
//								s=new Shot(et.x-5,et.y+15,2);
//								et.ss.add(s);
//								break;
//							case 3:
//								s=new Shot(et.x+25,et.y+15,3);	
//								et.ss.add(s);
//								break;		
//							}
//							//�����ӵ�
//							Thread t=new Thread(s);
//							t.start();
//						}
//						
//					}
//				}
				this.repaint();	//�ػ�
			}
		}
	
}

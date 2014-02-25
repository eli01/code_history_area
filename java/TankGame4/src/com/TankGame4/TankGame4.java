/**
 *TankGame4.0
 * 功能：
 * 1:画出坦克
 * 2：上下左右移动
 * 3：可以发射子弹
 * 4.敌人被我击中时消失（并爆炸）
 * 5.我被敌人击中时消失（并爆炸）
 * 6.敌人坦克会相互避让
 * 7.设置关卡
 *  7.1做一个开始的panel
 * 8.可以中途暂停
 *  8.1当用户点击暂停时将子弹和坦克的速度置为零，并维持方向不变
 * 9.可以记录玩家成绩
 *  9.1用文件流
 *  9.2单写一个类记录玩家的数据
 *  9.3先保存击毁敌人坦克数量
 *  9.4存盘退出
 * 10.设置音乐背景
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
	//定义一个开始的面板
	startPanel sp=null;
	//定义我的面板
	MyPanel mp=null;
	JMenuBar jmb=null;//做出菜单
	JMenu jm1,jm2,jm3;
	JMenuItem jmi1,jmi2,jmi3,jmi4;
	JButton jb1,jb2,jb3,jb4,jb5;
	JToolBar jtb;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TankGame4 tank1=new TankGame4();
	}
	//构造函数
	public TankGame4()
	{
		//创建组件
		jmb=new JMenuBar();
		jm1=new JMenu("游戏(G)");//游戏菜单
		jm1.setMnemonic('G');//游戏菜单的助记符是G
		jmi1=new JMenuItem("新游戏(N)");//菜单项“新游戏”
		jmi1.addActionListener(this);
		jmi1.setActionCommand("newGame");
		jmi2=new JMenuItem("继续游戏");
		jmi2.addActionListener(this);
		jmi2.setActionCommand("continue");
		jmi3=new JMenuItem("退出(E)");
		jmi3.addActionListener(this);
		jmi3.setActionCommand("exit");
		jmi4=new JMenuItem("存盘退出(R)");
		jmi4.addActionListener(this);
		jmi4.setActionCommand("saveandexit");
		jtb=new JToolBar();//创建工具条
		jb1=new JButton(new ImageIcon("images/新游戏.png"));
		jb2=new JButton(new ImageIcon("images/存盘.png"));
		jb3=new JButton(new ImageIcon("images/退出.png"));
		jb4=new JButton(new ImageIcon("images/帮助.png"));
		jb5=new JButton(new ImageIcon("images/继续.png"));
		//为jb设置提示信息
		jb1.setToolTipText("新游戏");
		jb1.addActionListener(this);//注册监听
		jb1.setActionCommand("newGame");//设置监听命令
//		
		jb5.setToolTipText("继续游戏");
		jb5.addActionListener(this);//注册监听
		jb5.setActionCommand("continue");//设置监听命令
//		
		jb3.setToolTipText("退出");
		jb3.addActionListener(this);
		jb3.setActionCommand("exit");
//		//jb[3].setToolTipText("剪切");
		jb2.setToolTipText("退出存盘");
		jb2.addActionListener(this);
		jb2.setActionCommand("saveandexit");
		jb4.setToolTipText("帮助");
		//添加组件
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
		if(e.getActionCommand().equals("newGame"))//点击菜单，布置战场
		{
		
			mp=new MyPanel("newGame");	
			this.remove(sp);//将开始面板删除
			this.add(mp);
			Thread t=new Thread(mp);
			t.start();//启动mp线程
			this.addKeyListener(mp);
			this.setVisible(true);//刷新显示新面板
		}else if(e.getActionCommand().equals("exit")){
			//用户点击了退出系统
			//保存击毁敌人坦克的数量
			Recorder.keepRecord();
			System.exit(0);
		}else if(e.getActionCommand().equals("continue")){
			//Recorder.readRecord();
			//System.out.println("12345");
			mp=new MyPanel("continue");
			
			this.remove(sp);//将开始面板删除
			this.add(mp);
			Thread t=new Thread(mp);
			t.start();//启动mp线程
			this.addKeyListener(mp);
			this.setVisible(true);//刷新显示新面板
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
	//记录每关有多少敌人
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
//			System.out.println("该文件已存在！");
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
					//写入到文件
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
	public Vector<Node>  readRecord()//读取文件中的数据
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
	public static void keepRecord()//保存数据到文件
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
			//System.out.println("该文件已存在！");
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
//设置开始面板，起到提示作用

class startPanel extends JPanel implements Runnable
{
	int times=0;
	public void paint(Graphics g)
	{
		super.paint(g);
		
		g.fillRect(0, 0, TankGame4.XL, TankGame4.YL);
		
		//提示信息
		if(times%2==0)
		{
			g.setColor(Color.yellow);
			Font myFont=new Font("黑体",Font.ITALIC,50);
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
				Thread.sleep(50);//造成闪烁效果
				
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
//我的面板
class MyPanel extends JPanel implements KeyListener,Runnable
{
	//final float r2=3.6f*3.6f;//坦克的直径13.7（把坦克看成一个圆）
	//定义我的坦克组
	MyTank mytank=null;
	Vector<MyTank> mytanks=new Vector<MyTank>();
	Vector<Node> nodes=new Vector<Node>();
	//定义敌人的坦克组
	Vector<EnemyTanks> ets=new Vector<EnemyTanks>();
	//敌人坦克的数量
	int enSize=Recorder.getEnSize();	
	Image image1=null;
	Image image2=null;
	Image image3=null;
	Vector<Bomb> bombs;//定义我的炮弹向量
	public MyPanel(String flag)
	{
		
		mytank=new MyTank(600,600);//初始化我的坦克，给坦克一个初始位置
		//初始化敌人的坦克
		if(flag.equals("newGame"))
		{
			for(int i=0;i<enSize;i++)
			{
				//创建一辆敌人的坦克对象
				EnemyTanks et=new EnemyTanks((i+1)*70,100);
				et.fire();	
				et.setColor(1);
				et.setDirect(1);
				et.setSpeed(10);
				ets.add(et);//加入Vector			
				et.setEts(ets);//将mypanel上的坦克交给该敌人坦克
				Thread t=new Thread(et);
				t.start();		
				Shot s=new Shot(et.x+9,et.y+30,1);//给敌人添加一颗子弹			
				et.ss.add(s);//加入敌人坦克
				Thread t2=new Thread(s);
				t2.start();
			}
		}else 
		{
			nodes=new Recorder().readRecord();
			for(int i=0;i<nodes.size();i++)
			{
				//创建一辆敌人的坦克对象
			
				Node node=nodes.get(i);
				EnemyTanks et=new EnemyTanks(node.x,node.y);
				et.fire();	
				et.setColor(1);
				et.setDirect(node.direct);
				et.setSpeed(10);
				ets.add(et);//加入Vector			
				et.setEts(ets);//将mypanel上的坦克交给该敌人坦克
				Thread t=new Thread(et);
				t.start();		
				Shot s=new Shot(et.x+9,et.y+30,1);//给敌人添加一颗子弹			
				et.ss.add(s);//加入敌人坦克
				Thread t2=new Thread(s);
				t2.start();
			}
		}
	
		bombs=new Vector<Bomb>();//初始化我的炮弹向量
		
		//初始化图片
		try {
			image1=ImageIO.read(new File("D:/Users/Neo/Workspaces/MyEclipse 10/TankGame3/src/b1.gif"));
			image2=ImageIO.read(new File("D:/Users/Neo/Workspaces/MyEclipse 10/TankGame3/src/b2.gif"));
			image3=ImageIO.read(new File("D:/Users/Neo/Workspaces/MyEclipse 10/TankGame3/src/b3.gif"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		image1=Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/爆炸1.png"));
//		image2=Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/爆炸2.png"));
//		image3=Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/爆炸3.png"));
	}
	public void showStateInfo(Graphics g)
	{
		g.setColor(Color.darkGray);
		g.fillRect(0,0,TankGame4.GXL,TankGame4.GYL);//游戏区域
		//g.fillRect(0,TankGame4.GYL,TankGame4.XL,TankGame4.YL);//提示区颜色
		this.drawTank(TankGame4.GXL+10, 50, g, 0, 1, true);//画出提示信息坦克(敌人)，该坦克不参与战斗
		g.setColor(Color.BLACK);
		g.drawString(Recorder.getEnSize()+2+"", TankGame4.GXL+10, 120);
		this.drawTank(TankGame4.GXL+10, 170, g, 0, 0, true);
		g.setColor(Color.BLACK);
		g.drawString(Recorder.getMyLife()+"", TankGame4.GXL+14, 230);
		//画出玩家的总成绩
		Font f=new Font("幼圆",Font.BOLD,15);//玩家总成绩
		g.setColor(Color.darkGray);
		g.setFont(f);
		g.drawString("您的总成绩:"+Recorder.getDistroyEnemyNum(),TankGame4.XL-150,20);
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
	public void paint(Graphics g)//重写paint	
	{
		super.paint(g);	
		
		this.showStateInfo(g);//画状态信息
		for(int i=0;i<ets.size();i++)
		{   		
			this.drawTank(ets.get(i).getX(), ets.get(i).getY(), g, ets.get(i).getDirect(), 1,ets.get(i).isAlive);//画出敌人的坦克
			EnemyTanks et=ets.get(i);
			
			for(int j=0;j<et.ss.size();j++)
			{
				Shot enemyShot=et.ss.get(j);//取出子弹
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
		this.drawTank(mytank.getX(),mytank.getY(),g,mytank.getDirect(),0,mytank.isAlive);//画出我的坦克
		//System.out.println("第三个敌人子弹的数量97行"+ets.get(3).ss.size());
		//画出我的子弹
		for(int i=0;i<mytank.ss.size();i++)
		{
			Shot myshot=mytank.ss.get(i);
			if((myshot!=null)&&(myshot.isAlive==true))
			{
				g.draw3DRect(myshot.x,myshot.y,1,1,false);
			}
			if(myshot.isAlive==false)
			{
				mytank.ss.remove(myshot);//从ss中删除该子弹
			}
		}
		//画出炮弹
		for(int i=0;i<bombs.size();i++)
		{
		
			//取出炮弹
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
			
			b.lifeDown();//让b的生命值减少
			if(b.life==0)
			{				
				bombs.remove(b);//如果炮弹生命为值为0，就把该炸弹从bombs向量中去掉
			}
		}
	
	}	
	//写一个函数判断两辆坦克是否相撞,相撞修改turn
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
//	//写一个函数判断敌人的所有两个坦克是否相撞，调用haveCrash()函数
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
	
	
	//写一个专门判断敌人坦克是否被击中的函数
	public void haveHitEnemy(Shot s,Tank t)
	{
		switch(t.getDirect())
		{
		case 0:
		case 1:
			if(s.x>t.x&&s.x<t.x+20&&s.y>t.y&&s.y<t.y+30)
			{
				s.setAlive(false);//子弹死亡
				t.setAlive(false);//坦克消失
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
				s.setAlive(false);//子弹死亡				
				Recorder.reduceMyLife();//生命值减1
				if(Recorder.getMyLife()<=0)
				{
					t.setAlive(false);//坦克消失
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
				Recorder.reduceMyLife();//生命值减1
				if(Recorder.getMyLife()<=0)
				{
					t.setAlive(false);//坦克消失
				}		
				Bomb b=new Bomb(t.getX(),t.getY());
				this.bombs.add(b);
			}
			break;
		}
	}
	public void hitEnemy()
	{
		//让每一颗子弹与每一个敌人的坦克依次比对坐标，“击中”便将坦克和子弹的属性isAlive设置为flase,绘图时便无法通过判断
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
		//敌人的子弹和我的位置比对，判断我是否被击中
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
	//画出坦克的函数
	public void drawTank(int x,int y,Graphics g,int direct,int type,boolean isAlive)
		{
			if(isAlive)
			{
				//判断坦克的类型
				switch(type)
				{
					case 0://我的坦克
						g.setColor(Color.cyan);
						break;
					case 1://敌人的坦克
						g.setColor(Color.yellow);
						break;
				}
				//判断坦克的方向
				switch(direct)
				{
				case 0://向上
					//画出我的坦克（到时封装成一个函数）
					
				 //1.画出左边的矩形
					g.fill3DRect(x,y ,5, 30, false);
					//2.画出右边的矩形
					g.fill3DRect(x+15, y,5, 30, false);
					//3.画出中间的矩形
					g.fill3DRect(x+5, y+5,10, 20, false);
					//4.画出中间的圆
					g.fillOval(x+4, y+10,10,10);
					//5.画出线
					g.drawLine(x+9,y +15,x+9,y );
					break;
				case 1://向下
					//画出我的坦克（到时封装成一个函数）
					
				 //1.画出左边的矩形
					g.fill3DRect(x,y ,5, 30, false);
					//2.画出右边的矩形
					g.fill3DRect(x+15, y,5, 30, false);
					//3.画出中间的矩形
					g.fill3DRect(x+5, y+5,10, 20, false);
					//4.画出中间的圆
					g.fillOval(x+4, y+10,10,10);
					//5.画出线
					g.drawLine(x+9,y +15,x+9,y+30 );
					break;
				case 2://向左
					//1.画出上面的矩形
					g.fill3DRect(x-5,y+5,30,5,false);
					//2.画出下面的矩形
					g.fill3DRect(x-5, y+20, 30, 5, false);
					//3.画出中间的矩形
					g.fill3DRect(x, y+10, 20, 10, false);
					//4.画出中间的圆
					g.fillOval(x+4,y+10,10,10);
					//5.画出直线
					g.drawLine(x+5,y+15,x-5,y+15);
					break;
				case 3://向右
					//1.画出上面的矩形
					g.fill3DRect(x-5,y+5,30,5,false);
					//2.画出下面的矩形
					g.fill3DRect(x-5, y+20, 30, 5, false);
					//3.画出中间的矩形
					g.fill3DRect(x, y+10, 20, 10, false);
					//4.画出中间的圆
					g.fillOval(x+4,y+10,10,10);
					//5.画出直线
					g.drawLine(x+14,y+15,x+25,y+15);
					break;
					default:System.out.println("画图时出现故障！请检查代码");					
				}
			}

			
				
		}
		//键的一个值被输出
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
		
		}

		//键被按下 处理
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
			//System.out.println("被按下"+(char)e.getKeyCode());
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
			if(e.getKeyCode()==KeyEvent.VK_F)//如果玩家按下J键
			{
				if(this.mytank.ss.size()<3)
				{
					this.mytank.fire();		
				}								
			}
			//调用repaint()函数，重绘
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
					Thread.sleep(50);	//每隔50毫秒重绘一次
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
				this.hitEnemy();
				this.hitMyTank();
				//this.judgeEnemyCrash();
				
				//敌人的子弹和我的位置比对，判断我是否被击中
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
//									s.setAlive(false);//子弹死亡
//									this.mytank.setAlive(false);//坦克消失
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
				//这段代码可以控制连发
//				//判断是否需要给坦克加入新的子弹
//				//判断子弹是否没有
//			
//				for(int i=0;i<ets.size();i++)
//				{
//					EnemyTanks et=ets.get(i);
//					if(et.isAlive)
//					{
//						Shot s=null;
//						//没有子弹
//						//添加
//						if(et.ss.size()==0)//如果子弹已死亡
//						{
//							switch(et.direct)
//							{
//							case 0:
//								s=new Shot(et.x+9,et.y,0);//创建一个子弹
//							    et.ss.add(s);//将子弹加入向量
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
//							//启动子弹
//							Thread t=new Thread(s);
//							t.start();
//						}
//						
//					}
//				}
				this.repaint();	//重绘
			}
		}
	
}

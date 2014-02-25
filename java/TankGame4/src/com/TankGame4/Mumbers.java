package com.TankGame4;
import java.util.*;
//炸弹类
class Bomb
{
	int x,y;
	int life=9;//炸弹的生命
	boolean isAlive=true;
	public Bomb(int x,int y)
	{
		this.x=x;
		this.y=y;
	}
	//减少生命值
	public void lifeDown()
	{
		if(life>0)
		{
			life--;
		}else{
			isAlive=false;
		}
	}
}
//子弹类
class Shot implements Runnable
{
	int x;
	int y;
	int direct;
	int speed=12;
	boolean isAlive=true;//状态（或者或者已死亡）
	public boolean isAlive() {
		return isAlive;
	}
	public void setAlive(boolean isAlive) {
		this.isAlive = isAlive;
	}
	public Shot(int x,int y,int direct)
	{
		this.x=x;
		this.y=y;
		this.direct=direct;
	}
	public void run()
	{
		while(true)
		{
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			switch(direct)
			{
			case 0:
				y-=speed;
				break;
			case 1:
				y+=speed;
				break;
			case 2:
				x-=speed;
				break;
			case 3:
				x+=speed;
				break;
			}
			//子弹何时死亡
			//System.out.println("x="+x+" y="+y);
			//判断子弹是否碰到边缘
			if(x<0||x>TankGame4.GXL||y<0||y>TankGame4.GYL)
			{
				this.isAlive=false;
				break;
			}
		}
	}
}
class Tank
{
	//坦克的横坐标
	 int x=0;
	//坦克的纵坐标
	 int y=0;
	//坦克标志
	 boolean turn=true;
	public boolean isTurn() {
		return turn;
	}
	public void setTurn(boolean turn) {
		this.turn = turn;
	}
	//坦克方向
	//0:上；1：下；2：左；3：右
	int direct=0;//默认向上
	//设置坦克的速度
	int speed=1;
	int color=0;
	boolean isAlive=true;
	//子弹
	Shot s=null;
	//开火
	Vector<Shot> ss=new Vector<Shot>();
	public void fire()
	{
		//s=new Shot(mytank.getX(),mytank.getY());
		switch(this.direct)
		{
		case 0:
			this.s=new Shot(x+9,y,0);//创建一个子弹
			this.ss.add(s);//将子弹加入向量
			break;
		case 1:
			this.s=new Shot(x+9,y+30,1);
			this.ss.add(s);
			break;
		case 2:
			this.s=new Shot(x-5,y+15,2);
			this.ss.add(s);
			break;
		case 3:
			this.s=new Shot(x+25,y+15,3);	
			this.ss.add(s);
			break;		
		}
		//启动子弹
		Thread t=new Thread(s);
		t.start();
	}
	public boolean isAlive() {
		return isAlive;
	}

	public void setAlive(boolean isAlive) {
		this.isAlive = isAlive;
	}

	public int getColor() {
		return color;
	}

	public void setColor(int color) {
		this.color = color;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}
	
	public int getDirect() {
		return direct;
	}

	public void setDirect(int direct) {
		this.direct = direct;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}


	
	public Tank(int x,int y)
	{
		this.x=x;
		this.y=y;
	}
}

//我的坦克
class MyTank extends Tank
{
	Vector<MyTank> mytanks=new Vector<MyTank>();
   int t=3;
	public MyTank(int x,int y)
	{
		//用父类的构造函数初始化子类
		super(x, y);		
	}
	//坦克向上移动
	public void moveUp()
	{
		y-=t*speed;
	}
	//坦克向下移动
	public void moveDown()
	{
		y+=t*speed;
	}
	//坦克向左移动
	public void moveLeft()
	{
		x-=t*speed;
	}
	//坦克向右移动
	public void moveRight()
	{
		x+=t*speed;
	}
}
//敌人的坦克
class EnemyTanks extends Tank implements Runnable
{
	int sleep=150;//暂停时间
	int step=10;
	int length=TankGame4.GYL-30;
	int width=TankGame4.GXL-30;
	int random=5;
	int times=0;
	Vector<EnemyTanks> ets=new Vector<EnemyTanks>();
	Vector<Shot> ss=new Vector<Shot>();
	public EnemyTanks(int x,int y)
	{
		super(x,y);
	}
	public boolean isEnemyCrash()
	{
		boolean b=false;
		switch(this.direct)
		{
			case 0://坦克向上
				for(int i=0;i<ets.size();i++)
				{
					EnemyTanks et=ets.get(i);
					if(et!=this)//排除自己
					{
						if(et.direct==0||et.direct==1)//如果敌人方向上、下
						{
							if(this.x>=et.x&&this.x<=et.x+20&&this.y>=et.y&&this.y<=et.y+30)
							{
								return true;
							}else
							if(this.x+20>=et.x&&this.x<=et.x+20&&this.y>=et.y&&this.y<=et.y+30)
							{
								return true;
							}
						}else//如果敌人左右运动
						{
							if(this.x>=et.x-5&&this.x<=et.x+25&&this.y>=et.y+5&&this.y<=et.y+25)
							{
								return true;
							}else
							if(this.x+20>=et.x-5&&this.x+20<=et.x+25&&this.y>=et.y+5&&this.y<=et.y+25)
							{
								return true;
							}
						}
					}
				}
				
				break;
			case 1://坦克向下
				for(int i=0;i<ets.size();i++)
				{
					EnemyTanks et=ets.get(i);
					if(et!=this)//排除自己
					{
						if(et.direct==0||et.direct==1)//如果敌人方向上、下
						{
							if(this.x>=et.x&&this.x<=et.x+20&&this.y+30>=et.y&&this.y+30<=et.y+30)
							{
								return true;
							}else
							if(this.x+20>=et.x&&this.x<=et.x+20&&this.y+30>=et.y&&this.y+30<=et.y+30)
							{
								return true;
							}
						}else//如果敌人左右运动
						{
							if(this.x>=et.x-5&&this.x<=et.x+25&&this.y>=et.y+5&&this.y<=et.y+25)
							{
								return true;
							}else
							if(this.x+20>=et.x-5&&this.x+20<=et.x+25&&this.y>=et.y+5&&this.y<=et.y+25)
							{
								return true;
							}
						}
					}
				}
				break;
			case 2:
				for(int i=0;i<ets.size();i++)
				{
					EnemyTanks et=ets.get(i);
					if(et!=this)//排除自己
					{
						if(et.direct==0||et.direct==1)//如果敌人方向上、下
						{
							if(this.x-5>=et.x&&this.x-5<=et.x+20&&this.y>=et.y&&this.y<=et.y+30)
							{
								return true;
							}else
							if(this.x+-5>=et.x&&this.x-5<=et.x+20&&this.y+20>=et.y&&this.y+20<=et.y+30)
							{
								return true;
							}
						}else//如果敌人左右运动
						{
							if(this.x-5>=et.x-5&&this.x-5<=et.x+25&&this.y+5>=et.y+5&&this.y+5<=et.y+25)
							{
								return true;
							}else
							if(this.x-5>=et.x-5&&this.x-5<=et.x+25&&this.y+25>=et.y+5&&this.y+25<=et.y+25)
							{
								return true;
							}
						}
					}
				}
				break;
			case 3:
				for(int i=0;i<ets.size();i++)
				{
					EnemyTanks et=ets.get(i);
					if(et!=this)//排除自己
					{
						if(et.direct==0||et.direct==1)//如果敌人方向上、下
						{
							if(this.x+25>=et.x-5&&this.x+25<=et.x+20&&this.y+5>=et.y&&this.y+5<=et.y+30)
							{
								return true;
							}else
							if(this.x+25>=et.x-5&&this.x+25<=et.x+20&&this.y+25>=et.y&&this.y+25<=et.y+30)
							{
								return true;
							}
						}else//如果敌人左右运动
						{
							if(this.x>=et.x&&this.x<=et.x+30&&this.y>=et.y&&this.y<=et.y+20)
							{
								return true;
							}else
							if(this.x>=et.x&&this.x<=et.x+30&&this.y+20>=et.y&&this.y+20<=et.y+20)
							{
								return true;
							}
						}
					}
				}
				break;
		}
		return b;
	}
	public void setEts(Vector<EnemyTanks> ets)
	{
		this.ets=ets;//将面板上的敌人坦克传到该敌人坦克中
	}
	@Override
	public void run() {
		int change;
		// TODO Auto-generated method stub
		while(true)
		{	
			//int random=(int)Math.random()*step;	
			//System.out.println("此时的random="+random);
			switch(this.direct)
			{
				
			case 0://正在向上移动
			
				for(int i=0;i<step;i++)
				{
				
					if(y>0&&!this.isEnemyCrash())
					{
						y-=speed;
						try {
							Thread.sleep(sleep);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
//						if(i==random)
//						{
//							//System.out.println("0敌人进程中的fire运行了！");
//							this.fire();
//						}
					}else break;
			
				}
			
				break;
			case 1://向下
			
				for(int i=0;i<step;i++)
				{
				
			
					if(y<width&&!this.isEnemyCrash())
					{
						y+=speed;
						try {
							Thread.sleep(sleep);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
//						if(i==random)
//						{
//							//System.out.println("1敌人进程中的fire运行了！");
//							this.fire();
//						}
					}else break;
				
				}
				break;
			case 2://向左
				
				for(int i=0;i<step;i++)
				{
				
					if(x>0&&!this.isEnemyCrash())
					{
//						if(i==random)
//						{
//							//System.out.println("2敌人进程中的fire运行了！");
//							this.fire();
//						}
						x-=speed;
						try {
							Thread.sleep(sleep);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}else break;
					
				}	
				break;
			case 3://向右			
			
					for(int i=0;i<step;i++)
					{
						
						if(x<length&&!this.isEnemyCrash())
						{
//							if(i==random)
//							{
//								//System.out.println("3敌人进程中的fire运行了！");
//								this.fire();
//							}
							x+=speed;
							try {
								Thread.sleep(sleep);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}else break;
					
					
					}	
					break;
				}
			times++;
			if(times%2==0)//times为偶数时便创建一个子弹，即每3秒发射一颗
			{
				if(this.isAlive)
				{
					Shot s=null;
					//没有子弹
					//添加
					
					if(this.ss.size()==0)//如果子弹已死亡
					{
						switch(this.direct)
						{
						case 0:
							s=new Shot(this.x+9,this.y,0);//创建一个子弹
						    this.ss.add(s);//将子弹加入向量
							break;
						case 1:
							s=new Shot(this.x+9,this.y+30,1);
							this.ss.add(s);
							break;
						case 2:
							s=new Shot(this.x-5,this.y+15,2);
							this.ss.add(s);
							break;
						case 3:
							s=new Shot(this.x+25,this.y+15,3);	
							this.ss.add(s);
							break;		
						}
						//启动子弹
						Thread t=new Thread(s);
						t.start();
					}
			      }
			  }
			
			//让坦克产生一个随机的方向
			
			do{
				change=(int)(Math.random()*4);
			}while(change==this.direct);
			this.setDirect(change);
			this.setTurn(true);
			//System.out.println(this.direct);
			//判断敌人是否死亡
			if(!this.isAlive)
			{
				break;//让坦克死亡后退出线程
			}
		
		}
	}
}

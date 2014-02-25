package com.TankGame4;
import java.util.*;
//ը����
class Bomb
{
	int x,y;
	int life=9;//ը��������
	boolean isAlive=true;
	public Bomb(int x,int y)
	{
		this.x=x;
		this.y=y;
	}
	//��������ֵ
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
//�ӵ���
class Shot implements Runnable
{
	int x;
	int y;
	int direct;
	int speed=12;
	boolean isAlive=true;//״̬�����߻�����������
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
			//�ӵ���ʱ����
			//System.out.println("x="+x+" y="+y);
			//�ж��ӵ��Ƿ�������Ե
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
	//̹�˵ĺ�����
	 int x=0;
	//̹�˵�������
	 int y=0;
	//̹�˱�־
	 boolean turn=true;
	public boolean isTurn() {
		return turn;
	}
	public void setTurn(boolean turn) {
		this.turn = turn;
	}
	//̹�˷���
	//0:�ϣ�1���£�2����3����
	int direct=0;//Ĭ������
	//����̹�˵��ٶ�
	int speed=1;
	int color=0;
	boolean isAlive=true;
	//�ӵ�
	Shot s=null;
	//����
	Vector<Shot> ss=new Vector<Shot>();
	public void fire()
	{
		//s=new Shot(mytank.getX(),mytank.getY());
		switch(this.direct)
		{
		case 0:
			this.s=new Shot(x+9,y,0);//����һ���ӵ�
			this.ss.add(s);//���ӵ���������
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
		//�����ӵ�
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

//�ҵ�̹��
class MyTank extends Tank
{
	Vector<MyTank> mytanks=new Vector<MyTank>();
   int t=3;
	public MyTank(int x,int y)
	{
		//�ø���Ĺ��캯����ʼ������
		super(x, y);		
	}
	//̹�������ƶ�
	public void moveUp()
	{
		y-=t*speed;
	}
	//̹�������ƶ�
	public void moveDown()
	{
		y+=t*speed;
	}
	//̹�������ƶ�
	public void moveLeft()
	{
		x-=t*speed;
	}
	//̹�������ƶ�
	public void moveRight()
	{
		x+=t*speed;
	}
}
//���˵�̹��
class EnemyTanks extends Tank implements Runnable
{
	int sleep=150;//��ͣʱ��
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
			case 0://̹������
				for(int i=0;i<ets.size();i++)
				{
					EnemyTanks et=ets.get(i);
					if(et!=this)//�ų��Լ�
					{
						if(et.direct==0||et.direct==1)//������˷����ϡ���
						{
							if(this.x>=et.x&&this.x<=et.x+20&&this.y>=et.y&&this.y<=et.y+30)
							{
								return true;
							}else
							if(this.x+20>=et.x&&this.x<=et.x+20&&this.y>=et.y&&this.y<=et.y+30)
							{
								return true;
							}
						}else//������������˶�
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
			case 1://̹������
				for(int i=0;i<ets.size();i++)
				{
					EnemyTanks et=ets.get(i);
					if(et!=this)//�ų��Լ�
					{
						if(et.direct==0||et.direct==1)//������˷����ϡ���
						{
							if(this.x>=et.x&&this.x<=et.x+20&&this.y+30>=et.y&&this.y+30<=et.y+30)
							{
								return true;
							}else
							if(this.x+20>=et.x&&this.x<=et.x+20&&this.y+30>=et.y&&this.y+30<=et.y+30)
							{
								return true;
							}
						}else//������������˶�
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
					if(et!=this)//�ų��Լ�
					{
						if(et.direct==0||et.direct==1)//������˷����ϡ���
						{
							if(this.x-5>=et.x&&this.x-5<=et.x+20&&this.y>=et.y&&this.y<=et.y+30)
							{
								return true;
							}else
							if(this.x+-5>=et.x&&this.x-5<=et.x+20&&this.y+20>=et.y&&this.y+20<=et.y+30)
							{
								return true;
							}
						}else//������������˶�
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
					if(et!=this)//�ų��Լ�
					{
						if(et.direct==0||et.direct==1)//������˷����ϡ���
						{
							if(this.x+25>=et.x-5&&this.x+25<=et.x+20&&this.y+5>=et.y&&this.y+5<=et.y+30)
							{
								return true;
							}else
							if(this.x+25>=et.x-5&&this.x+25<=et.x+20&&this.y+25>=et.y&&this.y+25<=et.y+30)
							{
								return true;
							}
						}else//������������˶�
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
		this.ets=ets;//������ϵĵ���̹�˴����õ���̹����
	}
	@Override
	public void run() {
		int change;
		// TODO Auto-generated method stub
		while(true)
		{	
			//int random=(int)Math.random()*step;	
			//System.out.println("��ʱ��random="+random);
			switch(this.direct)
			{
				
			case 0://���������ƶ�
			
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
//							//System.out.println("0���˽����е�fire�����ˣ�");
//							this.fire();
//						}
					}else break;
			
				}
			
				break;
			case 1://����
			
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
//							//System.out.println("1���˽����е�fire�����ˣ�");
//							this.fire();
//						}
					}else break;
				
				}
				break;
			case 2://����
				
				for(int i=0;i<step;i++)
				{
				
					if(x>0&&!this.isEnemyCrash())
					{
//						if(i==random)
//						{
//							//System.out.println("2���˽����е�fire�����ˣ�");
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
			case 3://����			
			
					for(int i=0;i<step;i++)
					{
						
						if(x<length&&!this.isEnemyCrash())
						{
//							if(i==random)
//							{
//								//System.out.println("3���˽����е�fire�����ˣ�");
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
			if(times%2==0)//timesΪż��ʱ�㴴��һ���ӵ�����ÿ3�뷢��һ��
			{
				if(this.isAlive)
				{
					Shot s=null;
					//û���ӵ�
					//���
					
					if(this.ss.size()==0)//����ӵ�������
					{
						switch(this.direct)
						{
						case 0:
							s=new Shot(this.x+9,this.y,0);//����һ���ӵ�
						    this.ss.add(s);//���ӵ���������
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
						//�����ӵ�
						Thread t=new Thread(s);
						t.start();
					}
			      }
			  }
			
			//��̹�˲���һ������ķ���
			
			do{
				change=(int)(Math.random()*4);
			}while(change==this.direct);
			this.setDirect(change);
			this.setTurn(true);
			//System.out.println(this.direct);
			//�жϵ����Ƿ�����
			if(!this.isAlive)
			{
				break;//��̹���������˳��߳�
			}
		
		}
	}
}

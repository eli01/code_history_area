package com.DuoxianchengText2;

public class Text3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Pig pig=new Pig();
		Bird bird=new Bird(9);
		Thread t1=new Thread(pig);
		Thread t2=new Thread(bird);
		t1.start();
		t2.start();
	}

}
class Pig implements Runnable
{
	int n=10;
	int times=0;
	
	public void run()
	{
		while(true)
		{
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
			System.out.println("我是一个线程，正在输出第"+(times+1)+"个Hello,world!");
			times++;
			if(n==times)
			{
				break;
			}
		}
	}
}

class Bird implements Runnable
{
	int n=0;
	int res=0;
	int times=0;
	public Bird(int n)
	{
		this.n=n;
	}
	public void run()
	{
		while(true)
		{
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
			}
			res+=(++times);
			if(times!=n)
			{
				System.out.println("当前结果是："+res);
			}else
			{
				break;
			}
		}
	}
}
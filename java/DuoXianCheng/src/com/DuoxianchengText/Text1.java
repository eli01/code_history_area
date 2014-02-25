package com.DuoxianchengText;

public class Text1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//创建一个Cat对象
		Cat cat=new Cat();
		//启动线程，会导致run函数的运行
		cat.start();
	}

}
class Cat extends Thread
{
	//重新编写run函数
	public void run()
	{
		int times=0;
		while(true)
		{
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Hello,world!"+times);
			times++;
			if(times==10)
			{
				break;
			}	
		}
		
	
	
	}
}

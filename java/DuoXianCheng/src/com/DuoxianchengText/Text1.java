package com.DuoxianchengText;

public class Text1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//����һ��Cat����
		Cat cat=new Cat();
		//�����̣߳��ᵼ��run����������
		cat.start();
	}

}
class Cat extends Thread
{
	//���±�дrun����
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

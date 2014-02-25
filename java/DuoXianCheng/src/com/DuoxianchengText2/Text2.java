package com.DuoxianchengText2;

public class Text2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Dog dog=new Dog();
		Thread t=new Thread(dog);
		t.start();
	}

}
class Dog implements Runnable
{
	int times=0;
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
			times++;
			System.out.println("aaa"+times);
			if(times==10)
			{
				break;
			}
		}
	}
}
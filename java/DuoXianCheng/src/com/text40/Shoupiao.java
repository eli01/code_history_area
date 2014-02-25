package com.text40;

public class Shoupiao {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TicketWindow tw1=new TicketWindow();
		
		
		Thread t1=new Thread(tw1);		
		Thread t2=new Thread(tw1);
		Thread t3=new Thread(tw1);
		
		t1.start();
		t2.start();
		t3.start();
	
		
	}

}
//售票窗口
class TicketWindow implements Runnable
{
	//一共2000张票
	private  int nums=2000;

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true)
		{
			//认为if else要保证原子性（同步代码块）
			synchronized(this)
			{
				//先判断是否还有票
				if(nums>0)
				{
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println(Thread.currentThread().getName()+"正在售出"+nums+"张票");
					nums--;
				}else{
					break;//售票结束
				}
			}
			
		}
	}
}
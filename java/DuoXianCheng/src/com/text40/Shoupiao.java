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
//��Ʊ����
class TicketWindow implements Runnable
{
	//һ��2000��Ʊ
	private  int nums=2000;

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true)
		{
			//��Ϊif elseҪ��֤ԭ���ԣ�ͬ������飩
			synchronized(this)
			{
				//���ж��Ƿ���Ʊ
				if(nums>0)
				{
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println(Thread.currentThread().getName()+"�����۳�"+nums+"��Ʊ");
					nums--;
				}else{
					break;//��Ʊ����
				}
			}
			
		}
	}
}
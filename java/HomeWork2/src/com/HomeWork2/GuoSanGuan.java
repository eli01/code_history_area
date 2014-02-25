package com.HomeWork2;
import java.io.*;
public class GuoSanGuan {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//����һ������װ��ֻ���ӵĶ�������
		int size=5;
		Monkey []monkey=new Monkey[size];
		InputStreamReader isr=new InputStreamReader(System.in);
		BufferedReader br=new BufferedReader(isr);
		//��ʼ����������
		for(int i=0;i<monkey.length;i++)
		{
			System.out.println("�������"+(i+1)+"ֻ���ӵĸ߶�");
			try {
				String height=br.readLine();
				monkey[i]=new Monkey((i+1)+"",Float.parseFloat(height));//�����������ʼ��
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//���Ϻ�������
		Monkey oldMonkey=new Monkey("100",1.2f);
		System.out.println("����ǰ��");
		oldMonkey.show(monkey);//����ǰ
		//����
		//��֤
		oldMonkey.insertSort(monkey);//���鲻�ǻ����������ͣ����Դ��Ƶ���
		System.out.println("�����");
		oldMonkey.show(	monkey);
		
	}

}
class Monkey//����һ��������--
{
	private String monkeyID;
	private float height;
	public Monkey(String monkeyID,float height)
	{
		this.monkeyID=monkeyID;
		this.height=height;
	}
	//�Ŷ�
	public void BubbleSort(Monkey[] monkey)
	{
		boolean change=true;
		Monkey tempID=null;
		//����ð�����򷨸�������������
		for(int i=monkey.length-1;i>=1&&change;i--)
		{
			change=false;
			for(int j=0;j<i;++j)
			{
				if(monkey[j].height>monkey[j+1].height)
				{
					tempID=monkey[j];
					monkey[j]=monkey[j+1];
					monkey[j+1]=tempID;
					change=true;
				}
			}
		}
		//return monkey;
	}
	//ѡ����������
	public void selectSort(Monkey []monkey)
	{
		Monkey temp=null;
		for(int i=0;i<monkey.length;i++)
		{
			int minIndex=i;
			for(int j=i+1;j<monkey.length;j++)
			{
				
				if(monkey[minIndex].height>monkey[j].height)
				{
					//minIndex=j;
					temp=monkey[minIndex];
					monkey[minIndex]=monkey[j];
					monkey[j]=temp;
				}
			}			
		}
	}
	//��������
	public void insertSort(Monkey []monkey)
	{
		//��ʼ����
		int lastIndex;
		float unSortHeight;
		Monkey temp;
		Monkey thisMonkey; 
		for(int i=1;i<monkey.length;i++)
		{
			unSortHeight=monkey[i].height;
			
			lastIndex=i-1;
			while(lastIndex>=0&&monkey[lastIndex].height>unSortHeight)
			{
				temp=monkey[lastIndex+1];
				monkey[lastIndex+1]=monkey[lastIndex];
				monkey[lastIndex]=temp;
				lastIndex--;
			}
		}
	}
	//��ʾ����
	public void show(Monkey []monkey)
	{
		for(int i=0;i<monkey.length;i++){
			System.out.println("���ӵı�ţ�"+(monkey[i].monkeyID)+"  ��ߣ�"+monkey[i].height);
		}
		
	}
}

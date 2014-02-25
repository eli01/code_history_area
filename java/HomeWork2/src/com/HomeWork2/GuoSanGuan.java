package com.HomeWork2;
import java.io.*;
public class GuoSanGuan {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//定义一个可以装五只猴子的对象数组
		int size=5;
		Monkey []monkey=new Monkey[size];
		InputStreamReader isr=new InputStreamReader(System.in);
		BufferedReader br=new BufferedReader(isr);
		//初始化各个猴子
		for(int i=0;i<monkey.length;i++)
		{
			System.out.println("请输入第"+(i+1)+"只猴子的高度");
			try {
				String height=br.readLine();
				monkey[i]=new Monkey((i+1)+"",Float.parseFloat(height));//将对象数组初始化
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//让老猴子排序
		Monkey oldMonkey=new Monkey("100",1.2f);
		System.out.println("排序前：");
		oldMonkey.show(monkey);//排序前
		//排序
		//验证
		oldMonkey.insertSort(monkey);//数组不是基本数据类型，可以创制调用
		System.out.println("排序后：");
		oldMonkey.show(	monkey);
		
	}

}
class Monkey//建立一个猴子类--
{
	private String monkeyID;
	private float height;
	public Monkey(String monkeyID,float height)
	{
		this.monkeyID=monkeyID;
		this.height=height;
	}
	//排队
	public void BubbleSort(Monkey[] monkey)
	{
		boolean change=true;
		Monkey tempID=null;
		//运用冒泡排序法给对象数组排序
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
	//选择排序法排序
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
	//插入排序
	public void insertSort(Monkey []monkey)
	{
		//开始排序
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
	//显示队列
	public void show(Monkey []monkey)
	{
		for(int i=0;i<monkey.length;i++){
			System.out.println("猴子的编号："+(monkey[i].monkeyID)+"  身高："+monkey[i].height);
		}
		
	}
}

/**
 * 
 */
package com.HomeWork;
import java.io.*;
import java.util.*;
/**
 * @author Neo
 *功能：实现一个简单学生成绩管理系统
 */
public class SearchAndManage {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("*******欢迎进入学生管理系统！*******\n请对学生进行初始化操作：");
		StudentsManageSystem sms=new StudentsManageSystem();//执行初始化操作
		System.out.println("*******\n欢初始化已完成！*******");
		while(true){
		System.out.println("请选择您要进行的操作：\n1.输入学号，打印学生的成绩；" +
				"\n2.输入成绩，打印该学生的学号\n3.统计各个分数阶段的学生\n4.输入学号，实现删除学生学号功能\n5.退出系统！");
		Scanner sc=new Scanner(System.in);
		int tableChoice=sc.nextInt();
		
		switch(tableChoice)
		{
		case 1:
			System.out.println("请输入学生的学号：");
			int index=sc.nextInt();
			System.out.println("学生"+index+"的成绩为："+sms.printScore(index));
			break;
		case 2:
			System.out.println("请输入学生的成绩：");
			float score=sc.nextFloat();
			System.out.println("查找到匹配的以下学号：");
			sms.findStuIndex(score);
			break;
		case 3:
			sms.grade();
			break;
		case 4:
			System.out.println("请输入学生的号码：");
			int index2=sc.nextInt();
			sms.delate(index2);
			System.out.println("该学生成绩已删除！");
			break;
		case 5:
			System.exit(0);
			default:System.out.println("操作有误！请重新输入！");
			break;
		}
	 }
	}

}
class StudentsManageSystem
{
	float students[]=null;
	int size=10;
	//构造函数
	public StudentsManageSystem()
	{
		students=new float[size];
		//初始化10个学生
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		for(int i=0;i<students.length;i++)
		{
			
			System.out.println("输入学生"+i+"的成绩：");
			try {
				students[i] = Float.parseFloat(br.readLine());
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		
	}
	//1.输入学号，打印该学生的成绩
	public float printScore(int index)
	{
		return students[index];
	}
	//2.输入成绩，打印该学生的学号
	public int findStuIndex(float score)
	{
		int findNum[]=null;
		int size=0;
		for(int i=0;i<students.length;i++)
		{
			if(score==students[i])
			{
				//return i;
				size++;
				//int stuIndex=i;
				System.out.println(" "+i);
			}
		}
		return size;
	}
	//3.统计各个分数阶段的学生
	public void grade()
	{
		//ArrayList al=new ArrayList();
		//al.add();
		int sup[]=new int[10],supNum=0;
		int better[]=new int[10], beNum=0;
		int ave[]=new int[10],aveNum=0;
		int fail[]=new int[10],failNum=0;
		for(int i=0;i<students.length;i++)
			{
				if(students[i]<60){					
					fail[failNum++]=i;
				}else if(students[i]<80){
					ave[aveNum++]=i;
				}else if(students[i]<90){
					better[beNum++]=i;
				}else{
					sup[supNum++]=i;
				}
			}
		System.out.println("A.统计出优秀的学生的学号：");
		for(int i=0;i<sup.length;i++)
		{
			System.out.print(" "+sup[i]);
		}
		
		System.out.println("\nB.统计出良好的学生的学号：");
		for(int i=0;i<better.length;i++)
		{
			System.out.print(" "+better[i]);
		}
	
		System.out.println("\nC.统计出中等的学生的学号：");
		for(int i=0;i<better.length;i++)
		{
			System.out.print(" "+ave[i]);
		}
		System.out.println("\nD.统计出不及格的学生的学号：");
		for(int i=0;i<better.length;i++)
		{
			System.out.print(" "+fail[i]);
		}
	}
	//4.输入学号，实现删除学生学号功能
	public void delate(int index)
	{
		students[index]=0;
	}
}

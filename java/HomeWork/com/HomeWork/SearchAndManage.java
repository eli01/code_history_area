/**
 * 
 */
package com.HomeWork;
import java.io.*;
import java.util.*;
/**
 * @author Neo
 *���ܣ�ʵ��һ����ѧ���ɼ�����ϵͳ
 */
public class SearchAndManage {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("*******��ӭ����ѧ������ϵͳ��*******\n���ѧ�����г�ʼ��������");
		StudentsManageSystem sms=new StudentsManageSystem();//ִ�г�ʼ������
		System.out.println("*******\n����ʼ������ɣ�*******");
		while(true){
		System.out.println("��ѡ����Ҫ���еĲ�����\n1.����ѧ�ţ���ӡѧ���ĳɼ���" +
				"\n2.����ɼ�����ӡ��ѧ����ѧ��\n3.ͳ�Ƹ��������׶ε�ѧ��\n4.����ѧ�ţ�ʵ��ɾ��ѧ��ѧ�Ź���\n5.�˳�ϵͳ��");
		Scanner sc=new Scanner(System.in);
		int tableChoice=sc.nextInt();
		
		switch(tableChoice)
		{
		case 1:
			System.out.println("������ѧ����ѧ�ţ�");
			int index=sc.nextInt();
			System.out.println("ѧ��"+index+"�ĳɼ�Ϊ��"+sms.printScore(index));
			break;
		case 2:
			System.out.println("������ѧ���ĳɼ���");
			float score=sc.nextFloat();
			System.out.println("���ҵ�ƥ�������ѧ�ţ�");
			sms.findStuIndex(score);
			break;
		case 3:
			sms.grade();
			break;
		case 4:
			System.out.println("������ѧ���ĺ��룺");
			int index2=sc.nextInt();
			sms.delate(index2);
			System.out.println("��ѧ���ɼ���ɾ����");
			break;
		case 5:
			System.exit(0);
			default:System.out.println("�����������������룡");
			break;
		}
	 }
	}

}
class StudentsManageSystem
{
	float students[]=null;
	int size=10;
	//���캯��
	public StudentsManageSystem()
	{
		students=new float[size];
		//��ʼ��10��ѧ��
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		for(int i=0;i<students.length;i++)
		{
			
			System.out.println("����ѧ��"+i+"�ĳɼ���");
			try {
				students[i] = Float.parseFloat(br.readLine());
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		
	}
	//1.����ѧ�ţ���ӡ��ѧ���ĳɼ�
	public float printScore(int index)
	{
		return students[index];
	}
	//2.����ɼ�����ӡ��ѧ����ѧ��
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
	//3.ͳ�Ƹ��������׶ε�ѧ��
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
		System.out.println("A.ͳ�Ƴ������ѧ����ѧ�ţ�");
		for(int i=0;i<sup.length;i++)
		{
			System.out.print(" "+sup[i]);
		}
		
		System.out.println("\nB.ͳ�Ƴ����õ�ѧ����ѧ�ţ�");
		for(int i=0;i<better.length;i++)
		{
			System.out.print(" "+better[i]);
		}
	
		System.out.println("\nC.ͳ�Ƴ��еȵ�ѧ����ѧ�ţ�");
		for(int i=0;i<better.length;i++)
		{
			System.out.print(" "+ave[i]);
		}
		System.out.println("\nD.ͳ�Ƴ��������ѧ����ѧ�ţ�");
		for(int i=0;i<better.length;i++)
		{
			System.out.print(" "+fail[i]);
		}
	}
	//4.����ѧ�ţ�ʵ��ɾ��ѧ��ѧ�Ź���
	public void delate(int index)
	{
		students[index]=0;
	}
}

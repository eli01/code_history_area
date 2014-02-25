/**
 * 
 */
package com.HomeWork;
//import java.util.*;
import java.io.*;
/**
 * @author Neo
 *���ܣ�1.��ˮ������8����ί��֣��˶�Ա�ĳɼ���8���ɼ�ȥ��һ����߷֣�
 *    ȥ��һ����ͷ֣�ʣ�µ�6��������ƽ���־������÷֡�ʹ��һά����
 *    ʵ�ִ�ֹ��ܡ�
 *    2.��Ѵ���߷ֵ���ί����ͷֵ���ί�ҳ�����
 */
public class DivingCompetition {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub

	Judge judge=new Judge();
	System.out.println("ȥ��һ����߷֣�ȥ��һ����ͷ֣���ѡ�ֵ����յ÷�Ϊ��"+judge.lastScore());
	System.out.println("������߷ֵ���ί��ţ�"+(judge.getMaxScoreIndex()+1)+"\n"+"������ͷ���ί���Ϊ��"+(judge.getMinScoreIndex()+1));
	System.out.println("�����ί�ǵ�"+(judge.getExcellent()+1)+"λ��ί�������ί�ǵ�"+(judge.getWorst()+1)+"λ��ί��");
  }
}
class Judge
{
	float fens[]=null;
	int size=8;
	//���캯��
	public Judge()
	{
		fens=new float[size];
		//BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		InputStreamReader isr=new InputStreamReader(System.in);
		BufferedReader br=new BufferedReader(isr);
//		try {
//			String str=br.readLine();
//		} catch (IOException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
		
		System.out.println("��8λ��ί����Ϊѡ�ִ�֣�");
		try{

		for(int i=0;i<fens.length;i++)
			{  
				System.out.println("�������"+(i+1)+"λ��ί��֣�");
				
					fens[i]=Float.parseFloat(br.readLine());
			}
					}catch(IOException e){
						e.printStackTrace();
					}finally{
						try {
							br.close();
						} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
	
	}
	

	//�õ��˶�Ա�����÷�
	public float lastScore()
	{
		float allScore=0;
		
		for(int i=0;i<fens.length;i++)
		{
			allScore+=fens[i];
		}
		return (allScore-fens[getMaxScoreIndex()]-fens[getMinScoreIndex()])/(fens.length-2);	//ѡ�ֵ÷�
	}
	public int getMaxScoreIndex()
	{
		float maxScore=fens[0];
		int maxIndex=0;
		
		for(int i=0;i<fens.length;i++)
		{
			if(maxScore<fens[i])
			{
				maxScore=fens[i];
				maxIndex=i;
			}
		}
		return maxIndex;
	}
	public int getMinScoreIndex()
	{
	
		float minScore=fens[0];
		int minIndex=0;
		for(int i=0;i<fens.length;i++)
		{
			if(minScore>fens[i])
			{
				minScore=fens[i];
				minIndex=i;
			}
		}
		return minIndex;
	}
	//�ҳ������ί�������ί
	public int getWorst()
	{
		float lastFen=this.lastScore();
		int worstIndex=0;
		float ca=Math.abs(lastFen-fens[0]);
		float tempCa=0f;
		for(int i=0;i<fens.length;i++)
		  {
			tempCa=Math.abs(lastFen-fens[worstIndex]);
			if(ca<tempCa)
			{
				worstIndex=i;
				ca=tempCa;
			}
		  }
		return worstIndex;
	   }
		public int getExcellent()
		{
			float lastFen=this.lastScore();
			int excelIndex=0;
			float ca=Math.abs(lastFen-fens[0]);
			float tempCa=0f;;
			for(int i=0;i<fens.length;i++)
			{
				tempCa=Math.abs(lastFen-fens[i]);
				if(ca>tempCa)
				{
					excelIndex=i;
					ca=tempCa;
				}
			}
		return excelIndex;
	     }
	
}

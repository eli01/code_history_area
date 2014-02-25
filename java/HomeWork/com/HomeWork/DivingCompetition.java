/**
 * 
 */
package com.HomeWork;
//import java.util.*;
import java.io.*;
/**
 * @author Neo
 *功能：1.跳水比赛，8个评委打分，运动员的成绩是8个成绩去掉一个最高分，
 *    去掉一个最低分，剩下的6个分数的平均分就是最后得分。使用一维数组
 *    实现打分功能。
 *    2.请把打最高分的评委和最低分的评委找出来。
 */
public class DivingCompetition {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub

	Judge judge=new Judge();
	System.out.println("去掉一个最高分，去掉一个最低分，该选手的最终得分为："+judge.lastScore());
	System.out.println("给出最高分的评委编号："+(judge.getMaxScoreIndex()+1)+"\n"+"给出最低分评委编号为："+(judge.getMinScoreIndex()+1));
	System.out.println("最佳评委是第"+(judge.getExcellent()+1)+"位评委；最差评委是第"+(judge.getWorst()+1)+"位评委。");
  }
}
class Judge
{
	float fens[]=null;
	int size=8;
	//构造函数
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
		
		System.out.println("请8位评委依次为选手打分：");
		try{

		for(int i=0;i<fens.length;i++)
			{  
				System.out.println("请输入第"+(i+1)+"位评委打分：");
				
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
	

	//得到运动员的最后得分
	public float lastScore()
	{
		float allScore=0;
		
		for(int i=0;i<fens.length;i++)
		{
			allScore+=fens[i];
		}
		return (allScore-fens[getMaxScoreIndex()]-fens[getMinScoreIndex()])/(fens.length-2);	//选手得分
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
	//找出最佳评委和最差评委
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

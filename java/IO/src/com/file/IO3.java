package com.file;
import java.io.*;
public class IO3 {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		FileReader fr=null;
		FileWriter fw=null;
		try {
			fr=new FileReader("d:/aaa.txt");
			fw=new FileWriter("d:/bbb.txt");
			char c[]=new char[1024];
			int n=0;//��¼ʵ�ʶ�ȡ�����ַ���
			while((n=fr.read(c))!=-1)
			{
				String s=new String(c,0,n);
				fw.write(c,0,n);//����ַ�
				System.out.println(c);
			}
	
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			fw.close();
			fr.close();
		}
		
	}

}

/**
 * ��ʾ�����ַ���
 */
package com.file;
import java.io.*;
public class IO4 {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
	BufferedReader br=null;
	BufferedWriter bw=null;
	//�ȴ���һ��file����
	
	try {
		FileReader f = new FileReader("d:/aaa.txt");
		br=new BufferedReader(f);
		FileWriter fw=new FileWriter("d:/bbb.txt");
		bw=new BufferedWriter(fw); 
		//ѭ����ȡ�ļ�
		String s="";
		while((s=br.readLine())!=null)
		{
			bw.write(s+"\r\n");
		}
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally{
		br.close();
		bw.close();
	}

	}

}

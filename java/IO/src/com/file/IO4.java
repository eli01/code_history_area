/**
 * 演示缓冲字符流
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
	//先创建一个file对象
	
	try {
		FileReader f = new FileReader("d:/aaa.txt");
		br=new BufferedReader(f);
		FileWriter fw=new FileWriter("d:/bbb.txt");
		bw=new BufferedWriter(fw); 
		//循环读取文件
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

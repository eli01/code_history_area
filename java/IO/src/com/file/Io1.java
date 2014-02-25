package com.file;
import java.io.*;
public class Io1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//创建一个文件对象
//		File f=new File("d:\\aaa.txt");
//		System.out.println("文件路径："+f.getAbsolutePath());
//		System.out.println("文件大小："+f.length());
	//创建文件和创建文件夹
//		File f2=new File("d:\\hsp.txt");
//		if(!f2.exists())
//		{
//			try {
//				f2.createNewFile();
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}else{
//			System.out.println("该文件已存在！");
//		}
//		File f2=new File("d:/ff");
//		if(f.isDirectory())
//		{
//			System.out.println("该文件夹已存在！");
//		}else
//		{
//			//创建一个文件夹
//			f2.mkdir();
//		}
		//列出一个文件夹下的所有文件
		File f=new File("d:\\");
		if(f.isDirectory())
		{
			File list[]=f.listFiles();
			for(int i=0;i<list.length;i++)
			{
				System.out.println(list[i].getName());
			}
		}
	}

}

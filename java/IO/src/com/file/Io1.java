package com.file;
import java.io.*;
public class Io1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//����һ���ļ�����
//		File f=new File("d:\\aaa.txt");
//		System.out.println("�ļ�·����"+f.getAbsolutePath());
//		System.out.println("�ļ���С��"+f.length());
	//�����ļ��ʹ����ļ���
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
//			System.out.println("���ļ��Ѵ��ڣ�");
//		}
//		File f2=new File("d:/ff");
//		if(f.isDirectory())
//		{
//			System.out.println("���ļ����Ѵ��ڣ�");
//		}else
//		{
//			//����һ���ļ���
//			f2.mkdir();
//		}
		//�г�һ���ļ����µ������ļ�
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

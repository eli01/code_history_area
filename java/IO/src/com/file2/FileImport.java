package com.file2;
import java.io.*;
public class FileImport {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		File f=new File("d:/aaa.txt");
//		FileInputStream fis=new FileInputStream(f);
//		//��ΪFileû�ж�д�������������ҪImportStream
//		try {
//		
//			
//			//����һ���ֽ�����
//			byte []bytes=new byte[1024];//�൱�ڻ���
//			int n=0;
//			while((n=fis.read(bytes))!=-1)
//			{
//				//���ֽ�ת��String
//				String s=new String(bytes,0,n);
//				System.out.println(s);
//			}
//		
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}finally{
//			//�ر��ļ���
//			fis.close();
//		}
		
		//�ֽ������
		FileOutputStream fos=null;
		try {
			fos = new FileOutputStream(f);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		String s="�ҵĵ���";
		try {
			fos.write(s.getBytes());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			fos.close();
		}
	}

}

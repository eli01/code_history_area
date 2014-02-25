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
//		//因为File没有读写的能力，因此需要ImportStream
//		try {
//		
//			
//			//定义一个字节数组
//			byte []bytes=new byte[1024];//相当于缓存
//			int n=0;
//			while((n=fis.read(bytes))!=-1)
//			{
//				//把字节转成String
//				String s=new String(bytes,0,n);
//				System.out.println(s);
//			}
//		
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}finally{
//			//关闭文件流
//			fis.close();
//		}
		
		//字节输出流
		FileOutputStream fos=null;
		try {
			fos = new FileOutputStream(f);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		String s="我的电脑";
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

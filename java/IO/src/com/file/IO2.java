package com.file;
import java.io.*;
public class IO2 {

	/**
	 * @param args
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		FileInputStream fis=null;
		FileOutputStream fos=null;
		try{
			fis=new FileInputStream("D:/Users/Neo/Workspaces/MyEclipse 10/TankGame3/src/b1.gif");
			fos=new FileOutputStream("d:/b1.gif");
			byte bytes[]=new byte[512];
			int n=0;
			while((n=fis.read(bytes))!=-1)
			{
				fos.write(bytes);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				fis.close();
				fos.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	
		
	}

}

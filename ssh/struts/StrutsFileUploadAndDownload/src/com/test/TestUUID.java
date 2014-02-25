package com.test;

import java.util.UUID;

public class TestUUID {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String uuid=UUID.randomUUID().toString();
		System.out.println(uuid);
	   /*È¥µôºó×º*/
		String filename="sunset.jpg";
		String filename1=filename.substring(0,filename.lastIndexOf("."));
		System.out.println(filename1);
		/* sunset.jpg -> uuid.jpg*/
		String filename2=uuid+filename.substring(filename.lastIndexOf("."),filename.length());
		System.out.println(filename2);
	}

}

package com.sp.model;

public class Tools {
	public static String getNewString(String input){
		String newStr="";
		try{
			newStr=new String(input.getBytes("iso-8859-1"),"gb2312");
		}catch(Exception e){
			e.printStackTrace();
		}
		return newStr;
	}
}

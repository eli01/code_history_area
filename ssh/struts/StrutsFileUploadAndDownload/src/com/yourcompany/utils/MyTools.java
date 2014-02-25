package com.yourcompany.utils;

import java.util.UUID;

public class MyTools {
	public static String getUUIDFileName(String filename){
		return UUID.randomUUID()+filename.substring(filename.lastIndexOf("."),filename.length());
	}
}

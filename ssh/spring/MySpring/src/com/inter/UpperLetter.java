package com.inter;

public class UpperLetter implements ChangeLetter {
	private String str;
	
	public String getStr() {
		return str;
	}

	public void setStr(String str) {
		this.str = str;
	}

	@Override
	public void change() {
		// СЩ->��д
		System.out.println(str.toUpperCase());
		
	}

}

package com.inter;

public class LowerLetter implements ChangeLetter {

private String str;
	
	public String getStr() {
		return str;
	}

	public void setStr(String str) {
		this.str = str;
	}

	@Override
	public void change() {
		// ´óÐ´->Ð¡Ð©
		System.out.println(str.toLowerCase());
		
	}
}

package com.service;

public class BybService {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public void SayBye(){
		System.out.println("Good bye!"+name);
	}
}

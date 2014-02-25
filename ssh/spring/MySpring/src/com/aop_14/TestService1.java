package com.aop_14;

public class TestService1 implements TestServiceInter ,TestServiceInter2 {
	private String name;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void sayhello() {
		// TODO Auto-generated method stub
		System.out.println("Hello,"+name);
	}

	@Override
	public void sayBey() {
		// TODO Auto-generated method stub
		System.out.println("Bey"+name);
		//int a=10/0;
	}

}

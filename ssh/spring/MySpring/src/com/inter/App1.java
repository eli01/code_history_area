package com.inter;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ac=new ClassPathXmlApplicationContext("com/inter/beans.xml");
		/*��ȡbean�����ýӿ�*/
		//UpperLetter ul=(UpperLetter)ac.getBean("changeLetter");
		//ul.change();
		/*��ȡbean,ʹ�ýӿ�*/
		ChangeLetter cl=(ChangeLetter)ac.getBean("changeLetter");
		cl.change();
	}

}

package com.Swing1;
import javax.swing.*;

import java.awt.*;
public class Button  extends JFrame{

	/**
	 * @param args
	 */
	JList jl1,jl2,jl3;
	String []data={"one","two","three","three","three","three","three","three","three","three","three","three","three"};
	int number[]={10,20,30,40,50};
	JPanel jp1;
	JScrollPane jsp;
	JSpinner jspinner,jspinner2;
	//¹¹Ôìº¯Êý
	public Button()
	{
		SpinnerDateModel slm=new SpinnerDateModel();
		//slm.setValue(number);
		jspinner=new JSpinner(slm);
		jspinner2=new JSpinner();
		jp1=new JPanel();
		jl1=new JList(data);
		
		System.out.println(jspinner.getValue());
		jsp=new JScrollPane(jl1);
		jp1.add(jspinner);
		jp1.add(jspinner2);
		jp1.add(jsp);
		this.add(jp1);
		
		this.setSize(400,300);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args){
		// TODO Auto-generated method stub
		Button b=new Button();
	}

}

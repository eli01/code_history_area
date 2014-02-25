package test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test1 {
	public static void main(String[] args){
		p("abc".matches("..."));
		
		p("a79978a".replaceAll("\\d", "-"));
		Pattern p=Pattern.compile("[a-z](3)");
		Matcher m=p.matcher("fgh");
		p(m.matches());
		p("fgh".matches("[a-z](3)"));
	}
	
	public static void p(Object o){
		System.out.println(o);
	}
}

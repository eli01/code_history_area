package RegullarLearn;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Exp1 {

	public static void main(String[] args) {
		// 初步认识正则表达式."."代表任意一个字符
		System.out.println("abc".matches("..."));
		//"\d代表一位数字，在java语法中，“\”代表转译字符，为了打印出字符“\”,需要这样"\\"
		p("a6464a".replaceAll("\\d", "-"));
		
		//编译这个正则表达式，加快后面匹配的速度
		Pattern p=Pattern.compile("[a-z]");//一位字母
		Matcher m=p.matcher("abc");
		p(m.matches());
		
		//上面三行代码等价于
		p("abc".matches("[a-z]"));
		
		//初步认识. * +
		//. 任意一个字符
		//* 0或多个字符
		//+ 1或多个
		//？ 0或1个
		p("a".matches("a."));
		p("aa".matches("aa"));
		p("aaaa".matches("a*"));
		p("aaaa".matches("a+"));
		p("".matches("a*"));
		p("a".matches("a?"));
		//p("2334354657687".matches("\\d{1,3}\\.\\d{1,3}\\.\\d{1,3\\.\\d{1,3}"));
		p("432".matches("[0-2][0-9]."));
		
		//认识一下【】
		//[] 匹配中括号内祖父i集合中的一个
		p("a".matches("[abc]"));//abc中的任意一个
		p("a".matches("[^abc]"));//abc以外的任意字符
		//并集有多种表示方法
		p("A".matches("[a-zA-Z]"));//a-z或A-Z中的任意一个字符
		p("A".matches("[a-z]|[A-Z]"));//a-z或A-Z中任意一个字符
		p("A".matches("[a-z[A-Z]]"));//a-z或A-Z中任意一个字符
		p("R".matches("[A-Z&&[RFG]]"));//匹配A-Z且匹配RFG中一个字符
		
		//认识\s \w \d \
		//\s 一个空格[ \t\n\xOB\f\r]
		//\S 非空格 [^\s]
		//\w 一个单词[a-zA-Z_0-9]
		//\W 非一个文字[^\w]
		//\d 一个数字[0-9]
		//\D 非数字[^\d]
		//\ 反斜杠本身
		p(" \n\r\t".matches("\\s{4}"));
		p(" ".matches("\\S"));
		p("a_8".matches("\\w{3}"));
		p("abc888&^%".matches("[a-z]{1,3}\\ d+[&^#&]+"));
		p("\\".matches("\\\\"));//要用正则表达式匹配一个\要用两个\\,因为一个反斜杠无法代表斜刚本身，而在java中要表示一个反斜杠需要四个反斜杠
		
		//POSIX Style
		p("a".matches("\\p{Lower}"));
		
		//boundary 边界匹配
		//\b 文字边界：遇到空格，特殊字符
		//\B 非文字边界
		p("hello sir".matches("^h.*"));
		p("hello sir".matches(".*ir$"));
		p("hello sir".matches("^h[a-z]{1,3}o\\b.*"));
		p("hellosir".matches("^h[a-z]{1,3}o\\b.*"));
		
		//white line
		//统计代码中有多少空白行
		p("hello sir".matches("^[\\s&&[^\\n]]*\\n$"));
		
		p("aaa 8888c".matches(".*\\d{4}."));
		p("aaa 888c".matches(".*\\b\\d{4}."));
		p("aaa888c".matches(".*\\d{4}."));
		p("aaa888c".matches(".*\\b\\d{4}"));
	
		//email地址匹配
		//解释一下：email地址包括四块
		//1.@之前的邮箱名：1个或多个文字和.-
		//2.@
		//3.域名：一个或多个文字或.-中间用.隔开
		p("adbchfn_dsa@dsad.com".matches("[\\w[.-]]+@[\\w[.-]]+\\.[\\w]+"));
	
		//maches find looking
		Pattern p2=Pattern.compile("\\d{3,5}");
		String s="1234-123-123-12";
		Matcher mm=p2.matcher(s);
		
		p(mm.matches());//false
		//上面maches过后匹配过的部分不会吐出来，后面find将从上一次无法匹配的地方开始
		mm.reset();//reset一次后会从头匹配
		//结果逐个乡下匹配
		p(mm.find());
		p(mm.find());
		p(mm.find());
		p(mm.find());//false
		
		//每一次都看头上
		p(m.lookingAt());
		p(m.lookingAt());
		p(m.lookingAt());
		p(m.lookingAt());
		p("rererere".matches("[a-zA-Z0-9]{6,30}"));
		
	}
	//包装一个方便调用的方法
	public static void p(Object str){
		System.out.println(str);
	}
	
}

package Exercise;

import java.io.IOException;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class StuSystem {
	public static void main(String[] args) throws Exception{
		Scanner scanner=new Scanner(System.in);
		//显示操作界面
		System.out.println("查看所有学生的成绩-----view");
		System.out.println("按照学生id号码查询学生成绩------view");
		System.out.println("添加一个学生-----add");
		System.out.println("按照id更改一个学生的信息------change");
		System.out.println("按照id去删除一个学生------remove");
		System.out.println("保存学生信息------save");
		System.out.println("退出系统-------exit");
		
		StudentService stuService=new StudentService();
		//获取用户希望干什么
		String operType=scanner.next();//获取一行
		if(operType.equals("view")){
			System.out.println("所有学生的信息！");
			stuService.showStudsFen();
		}
	}

}
//写一个service类
class StudentService{
	//显示所有学生成绩的方法
	public void showStudsFen() throws Exception{
		try{
			Document document=this.getDocument("src/Exercise/StuXml.xml");
			//4.显示学生信息
			NodeList nodelist=document.getElementsByTagName("student");
			for(int i=0;i<nodelist.getLength();i++){
				Element stuNode=(Element)nodelist.item(i);//取出一个节点信息
				//System.out.println(stuNode.getAttribute("sid"));
				//System.out.println(((Element)stuNode.getElementsByTagName("name")).getTextContent());
				System.out.println("学生编号："+stuNode.getAttribute("sid")+"\t\t"+
						"姓名："+getFirElementText(stuNode,"name")+"\t\t"+
						"java成绩："+getFirElementText(stuNode,"java")+"\t\t"+
						"oracle成绩："+getFirElementText(stuNode,"oracle")+"\t\t"+
						"vb成绩："+getFirElementText(stuNode,"vb"));	
			}
		
		
		}catch(Exception e){
			e.printStackTrace();
		}
	}
		
	public String getFirElementText(Element e,String name){
		return ((Element)e.getElementsByTagName(name).item(0)).getTextContent();
	}
	public Document getDocument(String fullFilePath) throws Exception{
		//1.得到DocumentBuilderFactory
		DocumentBuilderFactory documentBuilderFactory=DocumentBuilderFactory.newInstance();
		//2.得到DocumentBuilder
		DocumentBuilder documentbuilder=documentBuilderFactory.newDocumentBuilder();
		//3.指定文件
		return documentbuilder.parse(fullFilePath);
	}
}
//学生类
class Student{
	private String sid;
	private String name;
	private int myjava;
	private int myorical;
	private int myvb;
	
	public String getSid() {
		return sid;
	}
	public void setSid(String sid) {
		this.sid = sid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getMyjava() {
		return myjava;
	}
	public void setMyjava(int myjava) {
		this.myjava = myjava;
	}
	public int getMyorical() {
		return myorical;
	}
	public void setMyorical(int myorical) {
		this.myorical = myorical;
	}
	public int getMyvb() {
		return myvb;
	}
	public void setMyvb(int myvb) {
		this.myvb = myvb;
	}

	
}

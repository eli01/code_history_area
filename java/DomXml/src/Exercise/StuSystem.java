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
		//��ʾ��������
		System.out.println("�鿴����ѧ���ĳɼ�-----view");
		System.out.println("����ѧ��id�����ѯѧ���ɼ�------view");
		System.out.println("���һ��ѧ��-----add");
		System.out.println("����id����һ��ѧ������Ϣ------change");
		System.out.println("����idȥɾ��һ��ѧ��------remove");
		System.out.println("����ѧ����Ϣ------save");
		System.out.println("�˳�ϵͳ-------exit");
		
		StudentService stuService=new StudentService();
		//��ȡ�û�ϣ����ʲô
		String operType=scanner.next();//��ȡһ��
		if(operType.equals("view")){
			System.out.println("����ѧ������Ϣ��");
			stuService.showStudsFen();
		}
	}

}
//дһ��service��
class StudentService{
	//��ʾ����ѧ���ɼ��ķ���
	public void showStudsFen() throws Exception{
		try{
			Document document=this.getDocument("src/Exercise/StuXml.xml");
			//4.��ʾѧ����Ϣ
			NodeList nodelist=document.getElementsByTagName("student");
			for(int i=0;i<nodelist.getLength();i++){
				Element stuNode=(Element)nodelist.item(i);//ȡ��һ���ڵ���Ϣ
				//System.out.println(stuNode.getAttribute("sid"));
				//System.out.println(((Element)stuNode.getElementsByTagName("name")).getTextContent());
				System.out.println("ѧ����ţ�"+stuNode.getAttribute("sid")+"\t\t"+
						"������"+getFirElementText(stuNode,"name")+"\t\t"+
						"java�ɼ���"+getFirElementText(stuNode,"java")+"\t\t"+
						"oracle�ɼ���"+getFirElementText(stuNode,"oracle")+"\t\t"+
						"vb�ɼ���"+getFirElementText(stuNode,"vb"));	
			}
		
		
		}catch(Exception e){
			e.printStackTrace();
		}
	}
		
	public String getFirElementText(Element e,String name){
		return ((Element)e.getElementsByTagName(name).item(0)).getTextContent();
	}
	public Document getDocument(String fullFilePath) throws Exception{
		//1.�õ�DocumentBuilderFactory
		DocumentBuilderFactory documentBuilderFactory=DocumentBuilderFactory.newInstance();
		//2.�õ�DocumentBuilder
		DocumentBuilder documentbuilder=documentBuilderFactory.newDocumentBuilder();
		//3.ָ���ļ�
		return documentbuilder.parse(fullFilePath);
	}
}
//ѧ����
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

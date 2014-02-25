package SaxXmlTest;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SaxXml {
	public static void main(String args[]) throws ParserConfigurationException, SAXException, IOException{
		SAXParserFactory spf=SAXParserFactory.newInstance();//1.创建SAXParserFactory
		SAXParser saxParser=spf.newSAXParser();//2.拿到解析器
		//3.把xml文件和事件处理对象关联
		saxParser.parse("src/SaxXmlTest/saxxml.xml", new MyHandler2());
	}
	
}
//定义时间类：只显示指定内容
class MyHandler2 extends DefaultHandler{
	
	private boolean isName=false;
	private boolean isAge=false;
	
	@Override
	public void startDocument() throws SAXException {
		// TODO Auto-generated method stub
		super.startDocument();
		System.out.println("----------开始----------");
	}

	@Override
	public void endDocument() throws SAXException {
		// TODO Auto-generated method stub
		super.endDocument();
		System.out.println("----------结束----------");
	}

	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		// TODO Auto-generated method stub
		super.startElement(uri, localName, qName, attributes);
		if(qName.equals("名字")){
			isName=true;
		}else if(qName.equals("年龄")){
			isAge=true;
		}
			
		
	}

	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		// TODO Auto-generated method stub
		super.endElement(uri, localName, qName);
	}

	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		// TODO Auto-generated method stub
		super.characters(ch, start, length);
		String con=new String(ch,start,length);
		if(!con.trim().equals("")&&(isName||isAge)) System.out.println(con);
		isName=false;
		isAge=false;
	}
	
}
//定义事件处理类
class MyHandler1 extends DefaultHandler{

	@Override
	public void startDocument() throws SAXException {
		// TODO Auto-generated method stub
		System.out.println("----------开始----------");
		super.startDocument();
	}

	@Override
	public void endDocument() throws SAXException {
		// TODO Auto-generated method stub
		super.endDocument();
		System.out.println("----------结束----------");
	}

	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		// TODO Auto-generated method stub
		System.out.print(qName+":");
		super.startElement(uri, localName, qName, attributes);
	}

	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		// TODO Auto-generated method stub
		super.endElement(uri, localName, qName);
	}

	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		String con=new String(ch,start,length);
		if(!con.trim().equals("")) System.out.println(new String(ch,start,length));
	
		// TODO Auto-generated method stub
		super.characters(ch, start, length);
	}
	
}

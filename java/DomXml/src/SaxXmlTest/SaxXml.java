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
		SAXParserFactory spf=SAXParserFactory.newInstance();//1.����SAXParserFactory
		SAXParser saxParser=spf.newSAXParser();//2.�õ�������
		//3.��xml�ļ����¼�����������
		saxParser.parse("src/SaxXmlTest/saxxml.xml", new MyHandler2());
	}
	
}
//����ʱ���ֻࣺ��ʾָ������
class MyHandler2 extends DefaultHandler{
	
	private boolean isName=false;
	private boolean isAge=false;
	
	@Override
	public void startDocument() throws SAXException {
		// TODO Auto-generated method stub
		super.startDocument();
		System.out.println("----------��ʼ----------");
	}

	@Override
	public void endDocument() throws SAXException {
		// TODO Auto-generated method stub
		super.endDocument();
		System.out.println("----------����----------");
	}

	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		// TODO Auto-generated method stub
		super.startElement(uri, localName, qName, attributes);
		if(qName.equals("����")){
			isName=true;
		}else if(qName.equals("����")){
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
//�����¼�������
class MyHandler1 extends DefaultHandler{

	@Override
	public void startDocument() throws SAXException {
		// TODO Auto-generated method stub
		System.out.println("----------��ʼ----------");
		super.startDocument();
	}

	@Override
	public void endDocument() throws SAXException {
		// TODO Auto-generated method stub
		super.endDocument();
		System.out.println("----------����----------");
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

package DomXmlTest;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
//ʹ��dom������xml�ļ�����crud����
public class DomXml {
	public static void main(String[] args) throws Exception{
		//����һ��DocumentBuilderFactory
		DocumentBuilderFactory dbf=DocumentBuilderFactory.newInstance();
		//ͨ��dbf�õ�һ��DocumentBuilder����
		DocumentBuilder dBuilder=dbf.newDocumentBuilder();
		//ָ�������ĸ�xml�ļ�
		Document document=dBuilder.parse("src/DomXmlTest/domxml.xml");
		//System.out.println(document);
		//list(document);
		//read(document);
		//create(document);
		//deleteStu(document);
		update(document);
	}
	public static void update(Document doc) throws Exception{
		//���²���
		//��������
		Element node=(Element)doc.getElementsByTagName("ѧ��").item(0);//��õ�һ��ѧ���ڵ�ת��Ԫ������
		Element node_name=(Element)node.getElementsByTagName("����").item(0);//������ֽڵ�
		node_name.setTextContent("�ν�");//�޸ĸýڵ�����
		node.setAttribute("sex", "��");//�޸�����
		//����
		TransformerFactory.newInstance().newTransformer().transform(new DOMSource(doc), new StreamResult("src/DomXmlTest/DomXml.xml"));
		
	}
	//ɾ��һ��ѧ��
	public static void deleteStu(Document doc) throws Exception{
		Node node=doc.getElementsByTagName("ѧ��").item(0);
		node.getParentNode().removeChild(node);
		TransformerFactory tff=TransformerFactory.newInstance();
		Transformer tf=tff.newTransformer(); 
		tf.transform(new DOMSource(doc), new StreamResult("src/DomXmlTest/domxml.xml"));
	}
	//������xml�ļ�
	public static void list(Node node){
		System.out.println("���֣�"+node.getNodeName());
		//ȡ��node�Ľڵ�
		NodeList nodelist=node.getChildNodes();
		for(int i=0;i<nodelist.getLength();i++){
			//��ȥ��ʾ
			Node n=nodelist.item(i);
			System.out.println(n.getNodeName());
			list(n);
		}
	}
	//���ָ��ĳ��Ԫ�ص���Ϣ
	public static void read(Document d){
		NodeList nodelist=d.getElementsByTagName("ѧ��");
		System.out.println("���ڵ���ѧ����ǩ��������"+nodelist.getLength());
		Element stu=(Element)nodelist.item(0);//��Nodeת��Element(���ӿ�ת���ӽӿ�)
		System.out.println("ѧ�����Ա��ǣ�"+stu.getAttribute("sex"));
		System.out.println(stu.getElementsByTagName("����").item(0).getTextContent());
	}
	//���һ���µ�ѧ����xml�ļ���
	public static void create(Document doc) throws Exception{
		Element newstu=doc.createElement("ѧ��");//�������µĽڵ�
		newstu.setAttribute("sex", "��");
		Element newstu_name=doc.createElement("����");//����һ�����ڡ�ѧ����������ӽڵ�
		newstu_name.setTextContent("С��");
		Element newstu_age=doc.createElement("����");
		newstu_age.setTextContent("32");
		Element newstu_intro=doc.createElement("����");
		newstu_intro.setTextContent("С�ٺܿ����ֹۣ�");
				
		newstu.appendChild(newstu_name);
		newstu.appendChild(newstu_age);
		newstu.appendChild(newstu_intro);
		
		//newstu.setTextContent("С��");//���µĽڵ�����
		doc.getDocumentElement().appendChild(newstu);//���µĽڵ���뵽��Ԫ����
		//doc.getDocumentElement().appendChild(newstu);
		//�õ�TransformerFactory
		TransformerFactory tff=TransformerFactory.newInstance();
		//ͨ��tff���һ��ת����
		Transformer tf=tff.newTransformer(); 
		tf.transform(new DOMSource(doc), new StreamResult("src/DomXmlTest/domxml.xml"));
		
	}
	
}

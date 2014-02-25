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
//使用dom技术对xml文件进行crud操作
public class DomXml {
	public static void main(String[] args) throws Exception{
		//创建一个DocumentBuilderFactory
		DocumentBuilderFactory dbf=DocumentBuilderFactory.newInstance();
		//通过dbf得到一个DocumentBuilder对象
		DocumentBuilder dBuilder=dbf.newDocumentBuilder();
		//指定解析哪个xml文件
		Document document=dBuilder.parse("src/DomXmlTest/domxml.xml");
		//System.out.println(document);
		//list(document);
		//read(document);
		//create(document);
		//deleteStu(document);
		update(document);
	}
	public static void update(Document doc) throws Exception{
		//更新操作
		//更新内容
		Element node=(Element)doc.getElementsByTagName("学生").item(0);//获得第一个学生节点转成元素类型
		Element node_name=(Element)node.getElementsByTagName("名字").item(0);//获得名字节点
		node_name.setTextContent("宋江");//修改该节点内容
		node.setAttribute("sex", "男");//修改属性
		//更新
		TransformerFactory.newInstance().newTransformer().transform(new DOMSource(doc), new StreamResult("src/DomXmlTest/DomXml.xml"));
		
	}
	//删除一个学生
	public static void deleteStu(Document doc) throws Exception{
		Node node=doc.getElementsByTagName("学生").item(0);
		node.getParentNode().removeChild(node);
		TransformerFactory tff=TransformerFactory.newInstance();
		Transformer tf=tff.newTransformer(); 
		tf.transform(new DOMSource(doc), new StreamResult("src/DomXmlTest/domxml.xml"));
	}
	//遍历该xml文件
	public static void list(Node node){
		System.out.println("名字："+node.getNodeName());
		//取出node的节点
		NodeList nodelist=node.getChildNodes();
		for(int i=0;i<nodelist.getLength();i++){
			//再去显示
			Node n=nodelist.item(i);
			System.out.println(n.getNodeName());
			list(n);
		}
	}
	//获得指定某个元素的信息
	public static void read(Document d){
		NodeList nodelist=d.getElementsByTagName("学生");
		System.out.println("根节点下学生标签的数量："+nodelist.getLength());
		Element stu=(Element)nodelist.item(0);//将Node转成Element(父接口转成子接口)
		System.out.println("学生的性别是："+stu.getAttribute("sex"));
		System.out.println(stu.getElementsByTagName("名字").item(0).getTextContent());
	}
	//添加一个新的学生到xml文件中
	public static void create(Document doc) throws Exception{
		Element newstu=doc.createElement("学生");//创建的新的节点
		newstu.setAttribute("sex", "男");
		Element newstu_name=doc.createElement("名字");//创建一个挂在“学生”下面的子节点
		newstu_name.setTextContent("小召");
		Element newstu_age=doc.createElement("年龄");
		newstu_age.setTextContent("32");
		Element newstu_intro=doc.createElement("介绍");
		newstu_intro.setTextContent("小召很开朗乐观！");
				
		newstu.appendChild(newstu_name);
		newstu.appendChild(newstu_age);
		newstu.appendChild(newstu_intro);
		
		//newstu.setTextContent("小明");//给新的节点内容
		doc.getDocumentElement().appendChild(newstu);//将新的节点加入到根元素下
		//doc.getDocumentElement().appendChild(newstu);
		//得到TransformerFactory
		TransformerFactory tff=TransformerFactory.newInstance();
		//通过tff获得一个转换器
		Transformer tf=tff.newTransformer(); 
		tf.transform(new DOMSource(doc), new StreamResult("src/DomXmlTest/domxml.xml"));
		
	}
	
}

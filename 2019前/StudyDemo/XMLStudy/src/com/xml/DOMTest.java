package com.xml;

import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class DOMTest {

	public static void main(String[] args) {
		//创建一个DocumentBuilderFactory的对象
		DocumentBuilderFactory dbf =  DocumentBuilderFactory.newInstance();
		try {
		//创建一个DocumentBuilder对象
		DocumentBuilder db = dbf.newDocumentBuilder();
		//通过DocumentBuilder对象的parse方法加载xml文件到当前项目下
		Document document = db.parse("books.xml");
		//获取book节点的集合
		NodeList bookList = document.getElementsByTagName("book");
		//遍历每一个book节点
		System.out.println("节点个数"+bookList.getLength());
		for(int i=0;i<bookList.getLength();i++){
			System.out.println("开始本书");
			//方式一
			Element bo = (Element) bookList.item(i);//book节点转换Element
			System.out.println("id"+bo.getAttribute("id"));//知道属性只有一个及名称时使用
			
			//方式二
			//通过item方法获取一个book节点
			Node book = bookList.item(i);
			//遍历book的属性
			book.getAttributes();
			//获取book节点的所有属性集合
			NamedNodeMap attrs = book.getAttributes();
			System.out.println(i+"属性节点数量"+attrs.getLength());
			//遍历book的属性
				for (int j = 0; j < attrs.getLength(); j++) {
					//通过item方法获取某一属性
					Node attr = attrs.item(j);
					//获取属性名
					System.out.print("属性名"+attr.getNodeName());
					//获取属性值
					System.out.println("属性值"+attr.getNodeValue());
				}	
				
				
				//解析book子节点
				NodeList childsNodes = book.getChildNodes();
				//遍历childNodes获取每个节点的节点名和节点值
				for(int k=0;k<childsNodes.getLength();k++){
					//区分出text类型的node以及element类型的node
					if(childsNodes.item(k).getNodeType() == Node.ELEMENT_NODE){
					System.out.print(childsNodes.item(k).getNodeName()+":");
					System.out.print(childsNodes.item(k).getNodeValue());
System.out.println(childsNodes.item(k).getFirstChild().getNodeValue());
System.out.println(childsNodes.item(k).getTextContent());
					}
				}
					
		}
		
		
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}
	
	
	}
}

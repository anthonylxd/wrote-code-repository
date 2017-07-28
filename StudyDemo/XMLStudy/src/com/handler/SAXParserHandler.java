package com.handler;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SAXParserHandler extends DefaultHandler {
	int bookIndex = 0;
	
	
	//用来遍历xml文件的开始标签
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		super.startElement(uri, localName, qName, attributes);
		//开始解析book元素的属性
		if(qName.equals("book")) {
			bookIndex++;
			System.out.println("开始遍历"+bookIndex);
			//已知book元素下属性的名称，获取属性值
			System.out.println("book的属性值"+attributes.getValue("id"));
//不知道book元素下属性名称及个数的情况下，
			for(int i=0;i<attributes.getLength();i++){
				System.out.print(attributes.getQName(i));
				System.out.println(attributes.getValue(i));
			}	
		}else if(!qName.equals("book") && !qName.equals("bookstore")){
			System.out.print("节点名称"+qName);
		}
	}
	
	
	//用来遍历xml文件的结束标签
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		super.endElement(uri, localName, qName);
		//判断是否针对一本书已经遍历结束
		if(qName.equals("book")){
			System.out.println("遍历结束");				
		}	
		
		
	}
	
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		super.characters(ch, start, length);
		String value = new String(ch,start,length);
		if(!value.trim().equals("")){
			System.out.println(" 节点值 "+value);
			
		}
	}
	
	
	
	//用来标识解析开始
	@Override
	public void startDocument() throws SAXException {
		super.startDocument();
		System.out.println("SAX解析开始");
	}
	
	
	//用来标识解析结束
	@Override
	public void endDocument() throws SAXException {
		super.endDocument();
		System.out.println("SAX解析结束");
	}
}

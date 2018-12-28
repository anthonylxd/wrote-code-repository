package com.xml;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

import com.handler.SAXParserHandler;

public class SAXTest {
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
	//获取一个SAXParseFactory的实例
	SAXParserFactory factory = SAXParserFactory.newInstance();
	//通过factory获取SAXParser实例
	SAXParser parser = factory.newSAXParser();
	//创建SAXParserHandler对象
	SAXParserHandler handler =  new SAXParserHandler();
	parser.parse("books.xml", handler);
	
	
}
}

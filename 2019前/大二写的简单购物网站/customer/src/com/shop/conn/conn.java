package com.shop.conn;
import java.sql.Connection;
import java.sql.*;
public class conn {
  public Connection getCon()
  {
	  try{
		  Class.forName("com.mysql.jdbc.Driver");
		  String url="jdbc:mysql://localhost:3306/shop?useUnicode=true&characterEncoding=utf-8";
	  String user="root";
	  String password="123456";
	  Connection conn=DriverManager.getConnection(url,user,password);
	  return conn;
	  }catch(Exception e){
		  e.printStackTrace();
		  return null;
	  }
  }
}
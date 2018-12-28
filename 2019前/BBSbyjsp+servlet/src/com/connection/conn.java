package com.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;


public class conn {
	private static String url="jdbc:mysql://localhost:3306/BBS?useUnicode=true&characterEncoding=UTF-8";
	private static String user="root";
	private static String pwd="123456";
	static
	{
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static Connection getConnection() throws SQLException
	{	Connection connection=null ;
		connection = DriverManager.getConnection(url,user,pwd);
		return connection;
	}
	public static void closecon(Connection conn,Statement st,ResultSet rs)
	{
		try {
		if(rs!=null){
				rs.close();
				}
		if(st!=null){
			st.close();
		}
		if(conn!=null){
			conn.close();		}
		} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
	}
}

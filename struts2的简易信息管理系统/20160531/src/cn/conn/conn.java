package cn.conn;

import java.sql.*;

public class conn {
	private static String url="jdbc:mysql://localhost:3306/jdbcs?useUnicode=true&characterEncoding=utf-8";
	private static String user = "root";
	private static String pwd = "123456";
	static{
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}}
	public static Connection getConnection() throws SQLException{
		Connection conn = null;
		conn = DriverManager.getConnection(url,user,pwd);
		return conn;
}
	public static void close(Connection conn,Statement st,ResultSet rs)
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

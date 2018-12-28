package com.shop.userservice;
import java.sql.Connection;
import java.sql.*;
import com.shop.model.customer;
public class customerservice {
	private Connection conn;
	private PreparedStatement pstmt;
	public customerservice(){
		conn=new com.shop.conn.conn().getCon();//调用conn方法建立连接
		}
	public boolean vailUser(customer user){
		try{
		pstmt=conn.prepareStatement("select*from customer where customername=? and password=?");
		pstmt.setString(1, user.getCustomername());
		pstmt.setString(2, user.getPassword());
		ResultSet rs=pstmt.executeQuery();
		if(rs.next())
			return true;
		else
			return false;
		}catch(SQLException e){
			e.printStackTrace();
			return false;
		}
		
	}
}
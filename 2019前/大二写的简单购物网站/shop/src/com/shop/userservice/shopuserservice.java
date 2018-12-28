package com.shop.userservice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.shop.model.shopuser;;

public class shopuserservice {
	private Connection conn;
	private PreparedStatement pstmt;
	public shopuserservice(){
		conn=new com.shop.conn.conn().getCon();//调用conn方法建立连接
		}
	public boolean vailUser(shopuser user){
		try{
		pstmt=conn.prepareStatement("select*from shopuser where shopusername=? and password=?");
		pstmt.setString(1, user.getShopusername());
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

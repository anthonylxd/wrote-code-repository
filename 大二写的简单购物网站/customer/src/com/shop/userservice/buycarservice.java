package com.shop.userservice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.shop.conn.conn;
import com.shop.model.buycar;
public class buycarservice {
	private Connection conn;
	private PreparedStatement pstmt;
	public buycarservice(){
		conn=new com.shop.conn.conn().getCon();
	}
	public boolean addcarProduct(buycar pro){
		try{pstmt=conn.prepareStatement("insert into buycar"
				+"(productname,productfare,fahuo)"
				+"values(?,?,?)");
		pstmt.setString(1,pro.getProductname());
		pstmt.setDouble(2,pro.getProductfare());
		pstmt.setString(3,pro.getFahuo());
			pstmt.executeUpdate();
			return true;
		}catch(SQLException e){
			e.printStackTrace();
			return false;
		}
	}
	public List querycarAllpro()
	{   List pros=new ArrayList();
		try{
			pstmt=conn.prepareStatement("select * from buycar");
		    ResultSet rs=pstmt.executeQuery();
		    while(rs.next())
		    {
		    	buycar pro=new buycar();
		    	pro.setProductname(rs.getString(1));
		    	pro.setProductfare(rs.getDouble(2));
		    	pro.setFahuo(rs.getString(3));
		    	pros.add(pro);
		    	
		    }return pros;
		}catch(SQLException e){
			e.printStackTrace();
			return null;
		}
	}
}

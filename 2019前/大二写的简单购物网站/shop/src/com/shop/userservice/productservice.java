package com.shop.userservice;
import java.util.*;
import java.sql.*;

import com.shop.model.product;
import com.shop.conn.conn;

public class productservice {
private Connection conn;
private PreparedStatement pstmt;
public productservice(){
	conn=new com.shop.conn.conn().getCon();
}
public boolean addProduct(product pro){
	try{pstmt=conn.prepareStatement("insert into product"
			+"(productname,productnum,productfare)"
			+"values(?,?,?)");
	pstmt.setString(1, pro.getProductname());
	pstmt.setInt(2, pro.getProductnum());
	pstmt.setDouble(3,pro.getProductfare());
		pstmt.executeUpdate();
		return true;
	}catch(SQLException e){
		e.printStackTrace();
		return false;
	}
}
public List queryAllpro()
{   List pros=new ArrayList();
	try{
		pstmt=conn.prepareStatement("select * from product");
	    ResultSet rs=pstmt.executeQuery();
	    while(rs.next())
	    {
	    	product pro=new product();
	    	pro.setProductname(rs.getString(1));
	    	pro.setProductnum(rs.getInt(2));
	    	pro.setProductfare(rs.getDouble(3));
	    	pros.add(pro);
	    	
	    }return pros;
	}catch(SQLException e){
		e.printStackTrace();
		return null;
	}
}
public product querybyname(String productname)
{   //List stus=new ArrayList();
	try{
		pstmt=conn.prepareStatement("select * from product where productname=?");
	   pstmt.setString(1,productname);
		ResultSet rs=pstmt.executeQuery();
	    if(rs.next())
	    {
	    	product pro=new product();
	    	pro.setProductname(rs.getString(1));
	    	pro.setProductnum(rs.getInt(2));
	    	pro.setProductfare(rs.getDouble(3));
            return pro;
	    }return null;
	}catch(SQLException e){
		e.printStackTrace();
		return null;
	}
}
public boolean update(product pro){
	try{
		pstmt=conn.prepareStatement("update product set productnum=?,productfare=? where productname=?");
		pstmt.setInt(1, pro.getProductnum());
		pstmt.setDouble(2, pro.getProductfare());
		pstmt.setString(3, pro.getProductname());
		pstmt.executeUpdate();
			return true;
	}catch(SQLException e){
		e.printStackTrace();
		return false;
	}
}public Boolean delete(String productname){
	try{
		pstmt=conn.prepareStatement("delete from product where productname=?");
		pstmt.setString(1,productname);
		pstmt.executeUpdate();
		return true;
	}catch(SQLException e){
		e.printStackTrace();
		return false;
	}
}

}

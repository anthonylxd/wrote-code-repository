package com.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.connection.conn;
import com.model.host;

public class hostservice {
private Connection conn;
private PreparedStatement pstmt;
public hostservice() throws SQLException{
	conn=new com.connection.conn().getConnection();
	
}
public boolean hostlogin(host host) throws SQLException{
	pstmt =conn.prepareStatement("select * from host where username=? and password=?");
	pstmt.setString(1, host.getUsername());
	pstmt.setString(2, host.getPassword());
	ResultSet rs=pstmt.executeQuery();
	if(rs.next())
		return true;
	else
		return false;
	
}


}

package com.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.connection.conn;
import com.model.user;


public class usercurd {
	private Connection conn;
	private PreparedStatement pstmt;
	public usercurd() throws SQLException
		{
		conn=new com.connection.conn().getConnection();
		}
public boolean userlogin(user user) throws SQLException
{
	pstmt = conn.prepareStatement("select * from user where username=? and password=?");
	pstmt.setString(1, user.getUsername());
	pstmt.setString(2, user.getPassword());
	ResultSet rs=pstmt.executeQuery();
	if(rs.next())
		return true;
	else
		return false;
}

public boolean useradd(user user) throws SQLException
{
	pstmt = conn.prepareStatement("insert into user"+"(username,password)"+" values(?,?)");
	pstmt.setString(1, user.getUsername());
	pstmt.setString(2, user.getPassword());
	pstmt.executeUpdate();
	return true;
}


public List displayuser() throws SQLException
{
	List users = new ArrayList();
	pstmt = conn.prepareStatement("select * from user");
	ResultSet rs = pstmt.executeQuery();
	while(rs.next())
	{
		user user = new user();
		user.setUsername(rs.getString(1));
		user.setPassword(rs.getString(2));
		users.add(user);
	}
	return users;
}
public boolean deleteuser(String username) throws SQLException
{
	pstmt = conn.prepareStatement("delete from user where username=?");
	pstmt.setString(1, username);
	pstmt.executeUpdate();
	return true;
}


}


package com.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.model.post;
import com.servlet.newtitleservlet;
import com.connection.conn;

public class postcurd {

	private Connection conn;
	private PreparedStatement pstmt;
	public postcurd() throws SQLException{
		conn =new com.connection.conn().getConnection();
	}
	
	public boolean addpost(post post) throws SQLException
	{
		pstmt = conn.prepareStatement("insert into post"+"(title,author,date,zan)"+"values(?,?,?,?)");
		pstmt.setString(1, post.getTitle());
		pstmt.setString(2, post.getAuthor());
		pstmt.setString(3, post.getDate());
		pstmt.setInt(4, post.getZan());
		pstmt.executeUpdate();
		return true;
	}
	public List display() throws SQLException
	{
		List posts = new ArrayList();
		pstmt = conn.prepareStatement("select * from post");
		ResultSet rs = pstmt.executeQuery();
		while(rs.next())
		{
			post post = new post();
			post.setTitle(rs.getString(1));
			post.setAuthor(rs.getString(2));
			post.setDate(rs.getString(3));
			post.setZan(rs.getInt(4));
			posts.add(post);
		}
		return posts;
	}
	public boolean dianzan(String title) throws SQLException
	{
		pstmt = conn.prepareStatement("update post set zan=zan+1 where title=?");

		pstmt.setString(1, title);
		pstmt.executeUpdate();
		return true;
	}
	public boolean deletepost(String title) throws SQLException
	{
		pstmt = conn.prepareStatement("delete from post where title=?");
		pstmt.setString(1, title);
		pstmt.executeUpdate();
		return true;
	}
	
}

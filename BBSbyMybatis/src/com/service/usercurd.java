package com.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import com.entity.User;
import com.entity.post;
import com.inter.userinter;
import com.tool.DBAccess;

public class usercurd {
	userinter userinter;
	SqlSession sqlSession;
	public usercurd() throws IOException{
		DBAccess dbaccess = new DBAccess();
		sqlSession = dbaccess.getSqlSession();
		userinter = sqlSession.getMapper(userinter.class);
	}
	public boolean userlogin(User user) throws SQLException
	{
		User u= userinter.userlogin(user);
		if(u==null){
			return false;
		}
		if(u.getUsername().equals(user.getUsername())&&u.getPassword().equals(user.getPassword()))
		{	System.out.println(user.getUsername()+user.getPassword());
			return true;
		}else
		{	System.out.println(u.getPassword()+u.getUsername());
			return false;}
	}
	public boolean useradd(User user){
		
		userinter.useradd(user);
		sqlSession.commit();
		return true;
	}
	public boolean deleteuser(String username){
		
		userinter.deleteuser(username);
		sqlSession.commit();
		return true;
	}
	public List<User> displayuser(){
		
		List<User> users = userinter.displayuser();
		return users;
	}
}

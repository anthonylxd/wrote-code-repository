package com.service;

import java.io.IOException;
import org.apache.ibatis.session.SqlSession;

import com.entity.User;
import com.entity.host;
import com.inter.hostinter;
import com.servlet.hostloginservlet;
import com.tool.DBAccess;

public class hostservice {
	hostinter hostinter;
	SqlSession sqlSession;
	public hostservice() throws IOException{
		DBAccess dbaccess = new DBAccess();
		sqlSession = dbaccess.getSqlSession();
		hostinter = sqlSession.getMapper(hostinter.class);
	}
	public boolean hostlogin(host host){
		host u= hostinter.hostlogin(host);
		 if(u==null){
			return false;
		}
		if(u.getUsername().equals(host.getUsername())&&u.getPassword().equals(host.getPassword()))
		{	
			return true;
		}else
		{	
			return false;}
	}
}

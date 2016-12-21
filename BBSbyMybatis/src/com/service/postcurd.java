package com.service;

import java.io.IOException;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import com.entity.User;
import com.entity.host;
import com.entity.post;
import com.inter.postinter;
import com.inter.userinter;
import com.tool.DBAccess;

public class postcurd {
	postinter postinter;
	SqlSession sqlSession;
	public postcurd() throws IOException{
		DBAccess dbaccess = new DBAccess();
		sqlSession = dbaccess.getSqlSession();
		postinter = sqlSession.getMapper(postinter.class);
	}
	
	public List<post> display(){
		
		List<post> posts = postinter.display();
		return posts;
	}
	public boolean deletepost(String title){
		boolean res = postinter.deletepost(title);
		sqlSession.commit();
		return true;
	}
	public boolean dianzan(String title){
		boolean res = postinter.dianzan(title);
		sqlSession.commit();
		return res;
	}
	public boolean addpost(post post){
		boolean res = postinter.addpost(post);
		sqlSession.commit();
		return res;
	}
}

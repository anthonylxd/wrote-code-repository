package com.service;

import java.io.IOException;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.session.SqlSession;
import com.tool.DBAccess;
import com.dao.likeDao;
import com.entity.like;

public class likeService {
	likeDao likeDao;
	SqlSession sqlSession;
	public likeService() throws IOException{
		DBAccess dbaccess = new DBAccess();
		sqlSession = dbaccess.getSqlSession();
		likeDao = sqlSession.getMapper(likeDao.class);
	}
	public boolean Insert(int weiboId,int userId) {
		like like = new like();
		like.setUserId(userId);
		like.setWeiboId(weiboId);
		int count = likeDao.likeInsert(like);
		if (count == 0) {
			return true;			
		}else{
			return false;
		}
	}
}

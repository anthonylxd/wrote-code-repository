package com.service;

import java.io.IOException;

import org.apache.ibatis.session.SqlSession;

import com.dao.usersetingDao;
import com.entity.userseting;
import com.tool.DBAccess;

public class usersetingService {
	usersetingDao usersetingDao;
	SqlSession sqlSession;
	public usersetingService() throws IOException {
		DBAccess dbaccess = new DBAccess();
		sqlSession = dbaccess.getSqlSession();
		usersetingDao = sqlSession.getMapper(usersetingDao.class);
	}
	//新增
	public boolean insert(userseting userseting) {
		usersetingDao.usersetingInsert(userseting);
		sqlSession.commit();
		return true;
	}
	//查询
	public userseting select(int userId) {
		userseting userseting = usersetingDao.usersetingSelect(userId);
		return userseting;
	}
	
	//更新头像
	public boolean headImgUpdate(int userId,int headImg) {
		usersetingDao.headImgUpdate(userId, headImg);
		sqlSession.commit();
		return true;
	}
}

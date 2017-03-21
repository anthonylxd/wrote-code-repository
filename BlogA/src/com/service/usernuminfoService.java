package com.service;

import java.io.IOException;
import org.apache.ibatis.session.SqlSession;
import com.tool.DBAccess;
import com.dao.usernuminfoDao;
import com.entity.usernuminfo;

public class usernuminfoService {
	usernuminfoDao usernuminfoDao;
	SqlSession sqlSession;
	public usernuminfoService() throws IOException{
		DBAccess dbaccess = new DBAccess();
		sqlSession = dbaccess.getSqlSession();
		usernuminfoDao = sqlSession.getMapper(usernuminfoDao.class);
	}
	public void insert(int userId){
		usernuminfoDao.usernuminfoInsert(userId);
		sqlSession.commit();
	}
	public usernuminfo select(int userId){
		usernuminfo usernuminfo = usernuminfoDao.usernuminfoSelect(userId);
		return usernuminfo;
	}
	public boolean weiboNum(int userId,int add) {
		int count = usernuminfoDao.weiboNumChange(userId, add);
		sqlSession.commit();
		if (count == 1) {
			return true;
		}else{
			return false;
		}
	}
	
}

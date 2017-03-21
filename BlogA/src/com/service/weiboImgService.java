package com.service;

import java.io.IOException;
import org.apache.ibatis.session.SqlSession;
import com.dao.weiboimgDao;
import com.entity.weiboImg;
import com.tool.DBAccess;

public class weiboImgService {
	weiboimgDao weiboimgDao;
	SqlSession sqlSession;
	public weiboImgService() throws IOException {
		DBAccess dbaccess = new DBAccess();
		sqlSession = dbaccess.getSqlSession();
		weiboimgDao = sqlSession.getMapper(weiboimgDao.class);
	}
	
	public int insert(String imgName,int userId) {
		weiboImg weiboImg = new weiboImg();
		weiboImg.setImgName(imgName);
		weiboImg.setUserId(userId);
		weiboimgDao.weiboimgInsert(weiboImg);
		int imgId = weiboImg.getImgId();
		sqlSession.commit();
		return imgId;
	}
	
	public String select(int imgId) {
		String imgName = weiboimgDao.weiboimgSelect(imgId);		
		return imgName;	
	}
}

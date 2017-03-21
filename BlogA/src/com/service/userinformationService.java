package com.service;

import java.io.IOException;
import org.apache.ibatis.session.SqlSession;
import com.tool.DBAccess;
import com.dao.userinformationDao;
import com.entity.userinformation;

public class userinformationService {
	userinformationDao userinformationDao;
	SqlSession sqlSession;
	public userinformationService() throws IOException{
		DBAccess dbaccess = new DBAccess();
		sqlSession = dbaccess.getSqlSession();
		userinformationDao = sqlSession.getMapper(userinformationDao.class);
	}
	public void insert(int userId){
		userinformationDao.userinfoInsert(userId);
		sqlSession.commit();
	}
	public userinformation userinfoSelect(int userId){
		userinformation userinformation = userinformationDao.userinfoSelect(userId);
		return userinformation;
	}
	
	public boolean userinfoUpdate(int userId,String email,String phone,String sex,String birthday,String residence,String profession) {
		userinformation userinformation = new userinformation();
		userinformation.setUserId(userId);
		userinformation.setEmail(email);
		userinformation.setPhone(phone);
		userinformation.setSex(sex);
		userinformation.setBirthday(birthday);
		userinformation.setResidence(residence);
		userinformation.setProfession(profession);
		userinformationDao.userinfoUpdate(userinformation);
		sqlSession.commit();
		return true;
	}
}

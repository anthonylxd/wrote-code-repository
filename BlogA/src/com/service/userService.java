package com.service;
/*
 * 用户活动
 */
import java.io.IOException;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import com.tool.DBAccess;
import com.alibaba.fastjson.JSON;
import com.dao.userDao;
import com.entity.user;

public class userService {
	userDao userDao;
	SqlSession sqlSession;
	public userService() throws IOException{
		DBAccess dbaccess = new DBAccess();
		sqlSession = dbaccess.getSqlSession();
		userDao = sqlSession.getMapper(userDao.class);
	}
	//登录
	public user login(user loginuser) {
		user user = userDao.userLogin(loginuser);
		//String retur = JSON.toJSONString(user);
		return user;
	}
	//注册
	public int register(user user) {
		userDao.register(user);
		int userId = user.getUserId();
		sqlSession.commit();
		return userId;
	}
	//用户搜索
	public List<user> select(String username) {
		List<user> users = userDao.userSelect(username);
		return users;
	}
	//用户检测，用户名是否已存在
	public boolean check(String username) {
		int count = userDao.userCheck(username);
		if (count == 0) {
			return true;			
		}else{
			return false;
		}
	}
	//用户名查询
	public user userSelectById(int userId) {
		user user = userDao.userSelectById(userId);
		return user;
	}
	
	//用户名查询
	public String usernameSelectById(int userId) {
		String username = userDao.usernameSelectById(userId);
		return username;
	}
	//修改密码
	public boolean passwordUpdate(String password,int userId) {
		userDao.passwordUpdate(password, userId);
		sqlSession.commit();
		return true;
	}
	//根据用户名查询用户
	public user userSelectByUsername(String username) {
		user user = userDao.userSelectByUsername(username);
		return user;
	}
}

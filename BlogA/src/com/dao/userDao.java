package com.dao;

import java.util.List;
import com.entity.user;

public interface userDao {
	//用户注册
	int register(user user);
	//用户登录
	user userLogin(user user);
	//用户查询
	List<user> userSelect(String username);
	//检查用户名是否已被注册
	int userCheck(String username);
	//根据id查询用户
	user userSelectById(int userId);
	//查询其它用户的名字
	String usernameSelectById(int userId);
	//修改密码
	boolean passwordUpdate(String password,int userId);
	//根据用户名查询用户
	user userSelectByUsername(String username);
}

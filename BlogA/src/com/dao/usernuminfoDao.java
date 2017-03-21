package com.dao;

import com.entity.usernuminfo;

public interface usernuminfoDao {
	//用户注册时，增加新的记录
	boolean usernuminfoInsert(int userId);
	//用户数量信息查询，根据userId
	usernuminfo usernuminfoSelect(int userId);
	//用户发表微博，微博数量加1
	int	weiboNumChange(int userId,int add);
}

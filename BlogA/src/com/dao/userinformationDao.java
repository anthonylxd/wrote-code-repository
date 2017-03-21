package com.dao;

import com.entity.userinformation;

public interface userinformationDao {
	//用户注册时新增用户记录
	boolean userinfoInsert(int userId);
	//用户更新信息
	boolean userinfoUpdate(userinformation userinformation);
	//查询用户信息
	userinformation userinfoSelect(int userId);
}

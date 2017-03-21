package com.dao;

/*
 * 用户设置记录
 * 包括用户名，用户头像
 */
import com.entity.userseting;

public interface usersetingDao {
	
	//新增用户设置记录
	int usersetingInsert(userseting userseting);
	
	//用户设置查询
	userseting usersetingSelect(int userId);
	
	//用户设置头像
	boolean headImgUpdate(int userId,int headImg);
}

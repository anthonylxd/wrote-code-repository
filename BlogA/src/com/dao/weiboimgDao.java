package com.dao;

import com.entity.weiboImg;

public interface weiboimgDao {

	int weiboimgInsert(weiboImg weiboImg);
	
	String weiboimgSelect(int imgId);
}

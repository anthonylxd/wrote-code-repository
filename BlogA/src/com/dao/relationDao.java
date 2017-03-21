package com.dao;

import java.util.List;

import com.entity.relation;

public interface relationDao {
	//增减关注
	int relationInsert(relation relation);
	//查询一个用户的所有关注
	List<Integer> relationSelect(int fanUserId);
	//删除关注
	int relationDelete(relation relation);
	//查询是否关注
	int relationIsSelect(int followUserId,int fanUserId);
	//查询一个用户的所有粉丝
	List<Integer> relationSelectByfollowUserId(int followUserId);
}

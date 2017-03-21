package com.dao;

import java.util.List;

import com.entity.comment;

public interface commentDao {
	
	//发表评论
	int commentInsert(comment comment);
	
	//查询评论
	List<comment> commentById(int commentId);
	
	//删除评论
	int commentDelete(int commentId);
	
	//删除微博时的评论删除
	int commentDeleteByWeibo(int commentWeiboId);
}

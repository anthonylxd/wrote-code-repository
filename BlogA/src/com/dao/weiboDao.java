package com.dao;

import java.util.List;
import java.util.Map;

import com.entity.weibo;

public interface weiboDao {
	//发布微博
	boolean weiboInsert(weibo weibo);
	//根据用户Id查询微博
	List<weibo> weiboSelectByuserId(int userId,int pageSize,int contentSize);
	//用户对某条微博进行评论，评论总数变化
	int weiboLikeAdd(int weiboId,int add);
	//用户对一条微博点赞或取消赞，总数变化
	int weiboCommentAdd(int weiboId,int add);
	//根据用户的关注查询微博
	List<weibo> weiboSelectByRelation(Map<String,Object> map);
	//根据微博Id查询微博
	weibo weiboSelecByWeiboId(int weiboId);
}

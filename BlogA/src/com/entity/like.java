package com.entity;
/*
 * 点赞
 */
public class like {
	//点赞Id
	private int likeId;
	//被点赞的微博Id
	private int weiboId;
	//点赞用户的Id
	private int userId;
	//点赞时间
	private String likeTime;
	public int getLikeId() {
		return likeId;
	}
	public void setLikeId(int likeId) {
		this.likeId = likeId;
	}
	public int getWeiboId() {
		return weiboId;
	}
	public void setWeiboId(int weiboId) {
		this.weiboId = weiboId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getLikeTime() {
		return likeTime;
	}
	public void setLikeTime(String likeTime) {
		this.likeTime = likeTime;
	}
	
}

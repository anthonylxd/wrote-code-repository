package com.entity;
/*
 * 用户的微博数
 * 关注数
 * 粉丝数
 */
public class usernuminfo {
	//用户Id
	private int userId;
	//微博总数
	private int weiboNum;
	//关注总数
	private int followNum;
	//粉丝总数
	private int fanNum;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getWeiboNum() {
		return weiboNum;
	}
	public void setWeiboNum(int weiboNum) {
		this.weiboNum = weiboNum;
	}
	public int getFollowNum() {
		return followNum;
	}
	public void setFollowNum(int followNum) {
		this.followNum = followNum;
	}
	public int getFanNum() {
		return fanNum;
	}
	public void setFanNum(int fanNum) {
		this.fanNum = fanNum;
	}
	
}

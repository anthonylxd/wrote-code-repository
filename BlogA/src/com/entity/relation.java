package com.entity;
/*
 * 关注其它用户
 */
public class relation {
	//关联Id
	private int relationId;
	//被关注用户的Id
	private int followUserId;
	//关注别人的用户Id
	private int fanUserId;
	//关注时间
	private String relationTime;
	public int getRelationId() {
		return relationId;
	}
	public void setRelationId(int relationId) {
		this.relationId = relationId;
	}
	public int getFollowUserId() {
		return followUserId;
	}
	public void setFollowUserId(int followUserId) {
		this.followUserId = followUserId;
	}
	public int getFanUserId() {
		return fanUserId;
	}
	public void setFanUserId(int fanUserId) {
		this.fanUserId = fanUserId;
	}
	public String getRelationTime() {
		return relationTime;
	}
	public void setRelationTime(String relationTime) {
		this.relationTime = relationTime;
	}
	
}

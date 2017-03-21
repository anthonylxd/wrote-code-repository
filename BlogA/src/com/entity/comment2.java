package com.entity;
/*
 * 评论的评论
 */
public class comment2 {
	//评论的评论Id
	private int comment2Id;
	//内容
	private String comment2Content;
	//被评论的评论Id
	private int commentId;
	//评论的用户Id
	private int commentUserId;
	//评论时间
	private String comment2Time;
	//备用属性
	private String info;
	public int getComment2Id() {
		return comment2Id;
	}
	public void setComment2Id(int comment2Id) {
		this.comment2Id = comment2Id;
	}
	public String getComment2Content() {
		return comment2Content;
	}
	public void setComment2Content(String comment2Content) {
		this.comment2Content = comment2Content;
	}
	public int getCommentId() {
		return commentId;
	}
	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}
	public int getCommentUserId() {
		return commentUserId;
	}
	public void setCommentUserId(int commentUserId) {
		this.commentUserId = commentUserId;
	}
	public String getComment2Time() {
		return comment2Time;
	}
	public void setComment2Time(String comment2Time) {
		this.comment2Time = comment2Time;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	
}

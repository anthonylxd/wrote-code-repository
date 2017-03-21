package com.entity;
/*
 * 评论类
 */
public class comment {
	//评论Id
	private int commentId;
	//评论内容
	private String commentContent;
	//被评论的微博Id
	private int commentWeiboId;
	//评论人的Id
	private int commentUserId;
	//评论时间
	private String commentTime;
	//备用属性
	private String info;
	public int getCommentId() {
		return commentId;
	}
	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}
	public String getCommentContent() {
		return commentContent;
	}
	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}
	public int getCommentWeiboId() {
		return commentWeiboId;
	}
	public void setCommentWeiboId(int commentWeiboId) {
		this.commentWeiboId = commentWeiboId;
	}
	public int getCommentUserId() {
		return commentUserId;
	}
	public void setCommentUserId(int commentUserId) {
		this.commentUserId = commentUserId;
	}
	public String getCommentTime() {
		return commentTime;
	}
	public void setCommentTime(String commentTime) {
		this.commentTime = commentTime;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	
}

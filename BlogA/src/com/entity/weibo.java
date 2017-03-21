package com.entity;
/*
 * 微博类
 */
public class weibo {
	//微博Id
	private int weiboId;
	//微博发布时间
	private String weiboTime;
	//微博内容
	private String weiboContent;
	//微博图片
	private String weiboImg;
	//发布微博的用户Id
	private int userId;
	//微博点赞总数
	private int weiboLikeNum;
	//微博评论总数
	private int weiboCommentNum;
	//微博是否转发，原创为空，转发为被转发微博的用户的ID
	private int forwardId;
	//备用信息
	private String info;
	
	public int getWeiboId() {
		return weiboId;
	}
	public void setWeiboId(int weiboId) {
		this.weiboId = weiboId;
	}
	public String getWeiboTime() {
		return weiboTime;
	}
	public void setWeiboTime(String weiboTime) {
		this.weiboTime = weiboTime;
	}
	public String getWeiboContent() {
		return weiboContent;
	}
	public void setWeiboContent(String weiboContent) {
		this.weiboContent = weiboContent;
	}
	public String getWeiboImg() {
		return weiboImg;
	}
	public void setWeiboImg(String weiboImg) {
		this.weiboImg = weiboImg;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getWeiboLikeNum() {
		return weiboLikeNum;
	}
	public void setWeiboLikeNum(int weiboLikeNum) {
		this.weiboLikeNum = weiboLikeNum;
	}
	public int getWeiboCommentNum() {
		return weiboCommentNum;
	}
	public void setWeiboCommentNum(int weiboCommentNum) {
		this.weiboCommentNum = weiboCommentNum;
	}
	public int getForwardId() {
		return forwardId;
	}
	public void setForwardId(int forwardId) {
		this.forwardId = forwardId;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	
}

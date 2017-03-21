package com.entity;
/*
 * 微博图片
 */
public class weiboImg {
//微博图片Id
private int imgId;
//微博名称
private String imgName;
//上传时间
private String loadTime;
//上传用户Id
private int userId;
//备用信息
private String info;

public int getImgId() {
	return imgId;
}
public void setImgId(int imgId) {
	this.imgId = imgId;
}
public String getImgName() {
	return imgName;
}
public void setImgName(String imgName) {
	this.imgName = imgName;
}
public String getLoadTime() {
	return loadTime;
}
public void setLoadTime(String loadTime) {
	this.loadTime = loadTime;
}
public int getUserId() {
	return userId;
}
public void setUserId(int userId) {
	this.userId = userId;
}
public String getInfo() {
	return info;
}
public void setInfo(String info) {
	this.info = info;
}

}

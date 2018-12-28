package com.action;

import com.entity.User;
import com.opensymphony.xwork2.ActionSupport;
/*
 * 使用实体类获取参数
 */
public class Login2Action extends ActionSupport{
	
	public User user;
	public String login() {
		System.out.println(user.getUsername());
		return SUCCESS;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	
}

package com.action;

import com.opensymphony.xwork2.ActionSupport;
/*
 * 使用action属性获取参数
 */
public class LoginAction extends ActionSupport {
	private String username;
	private String password;
	
	
	
	public String login(){
		System.out.println(username+" "+password);
		return SUCCESS;
	}



	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}

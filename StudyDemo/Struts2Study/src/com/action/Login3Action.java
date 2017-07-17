package com.action;

import com.entity.User;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class Login3Action extends ActionSupport implements ModelDriven<User>{

	private User user = new User();

	public User getModel() {
		return user;
	}
	
	public String login() {
		return SUCCESS;
	}
	
}

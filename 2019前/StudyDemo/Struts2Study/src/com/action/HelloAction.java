package com.action;

import com.opensymphony.xwork2.ActionSupport;

public class HelloAction extends ActionSupport {

	public String add() {
		System.out.println("add方法执行了");
		return SUCCESS;
	}
	
	public String update() {
		System.out.println("update方法执行了");
		return SUCCESS;
	}
	
	
	@Override
	public String execute() throws Exception {
		System.out.println("HelloAction执行了");
		return SUCCESS;
	}

}

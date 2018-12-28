package cn.action;

import cn.model.Student;
import cn.service.service;
import com.opensymphony.xwork2.ActionSupport;

public class InputinfoAction extends ActionSupport {
	private Student u;
	
	public Student getU() {
		return u;
	}

	public void setU(Student u) {
		this.u = u;
	}

	public String execute() throws Exception {
	
	String username=u.getUsername();
	String password=u.getPassword();
	if(new service().addProduct(u))
		return "success";
	else
		return "error";
	}
}

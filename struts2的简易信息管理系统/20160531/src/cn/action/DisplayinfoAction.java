package cn.action;

import java.util.List;

import javax.servlet.http.HttpSession;

import cn.model.Student;
import cn.service.service;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class DisplayinfoAction extends ActionSupport {
	private Student u;
	
	public Student getU() {
		return u;
	}

	public void setU(Student u) {
		this.u = u;
	}

	public String execute() throws Exception {
		List  pros=new service().queryAllpro();
		return "success";
	
	}
}

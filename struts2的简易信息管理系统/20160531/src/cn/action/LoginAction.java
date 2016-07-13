package cn.action;

import javax.servlet.http.HttpSession;

import cn.model.Student;
import cn.service.service;

import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport {
	private Student u;
	public Student getU() {
		return u;
	}
	public void setU(Student u) {
		this.u = u;
	}
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		String username=u.getUsername();
		String password=u.getPassword();
		if(new service().vailUser(u)){
			
			return "success";
			}else
		return "error";
	}

	

}

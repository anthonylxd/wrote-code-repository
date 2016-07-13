package cn.action;

import cn.model.Student;
import com.opensymphony.xwork2.ActionSupport;
import cn.service.service;

public class DeleteAction extends ActionSupport {
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
		if(new service().delete(username))
			return "success";
		else
			return "error";
		
	}

}

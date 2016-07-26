package com.action;

import java.sql.SQLException;
import java.util.Map;
import com.model.user;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.service.usercurd;

public class userAction extends ActionSupport implements ModelDriven{
	user user = new com.model.user();
	public user getUser() {
		return user;
	}
	public void setUser(user user) {
		this.user = user;
	}
	public String userlogin() throws SQLException
	{
		user.getUsername();
		user.getPassword();
		if(new usercurd().userlogin(user))
		{
			ActionContext actionContext = ActionContext.getContext();
	        Map session = actionContext.getSession();
	        session.put("username", user.getUsername());
			return "SUCCESS";
		}else
		{
		return "ERROR";
		}
	}
	public String useradd() throws SQLException
	{
		user.getUsername();
		user.getPassword();
		ActionContext actionContext = ActionContext.getContext();
        Map session = actionContext.getSession();
        session.put("username", user.getUsername());		
		if(new usercurd().useradd(user))
		{
			return "SUCCESS";
		}else
		{
		return "ERROR";
		}
	}
	
	public String userdelete()
	{
		String username = user.getUsername();
		try {
			if(new usercurd().deleteuser(username))
			{
			return "SUCCESS";
			}
			else{
				return "ERROR";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "ERROR";
		}
	}
	
	

	

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		return super.execute();
	}
	@Override
	public Object getModel() {
	       if(user == null){
	           user = new user();
	           //user.setUsername("这是原来的User对象");
	       }
	       return user;
	}

	
}

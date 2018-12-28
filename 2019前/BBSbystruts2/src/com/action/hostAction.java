package com.action;

import java.sql.SQLException;
import java.util.Map;

import com.model.host;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.service.hostservice;

public class hostAction extends ActionSupport implements ModelDriven {
	host host = new host();
	public host getHost() {
		return host;
	}
	public void setHost(host host) {
		this.host = host;
	}
	public String hostlogin() throws SQLException
	{
		host.getUsername();
		host.getPassword();
		if(new hostservice().hostlogin(host))
		{
			ActionContext actionContext = ActionContext.getContext();
	        Map session = actionContext.getSession();
	        session.put("username", host.getUsername());
			return "SUCCESS";
		}else
		{
		return "ERROR";
		}
	}
	@Override
	public Object getModel() {
		// TODO Auto-generated method stub
		return host;
	}

}

package com.action;

import java.sql.SQLException;
import java.util.Map;

import javax.servlet.http.HttpSession;

import com.model.post;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.service.postcurd;

public class postAction extends ActionSupport implements ModelDriven {
	post post = new post();
	public post getPost() {
		return post;
	}
	public void setPost(post post) {
		this.post = post;
	}
	public String addtitle(){
		post.getTitle();	
		post.getAuthor();
		post.getDate();
		post.getZan();
		try {
			if(new postcurd().addpost(post))
			{
		        return "SUCCESS";
			}else {
				return "ERROR";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "ERROR";
		}
	
	}
	
	public String addzan()
	{
		String title =post.getTitle();
		try {
			if( new postcurd().dianzan(title))
			{
				return "SUCCESS";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "ERROR";
		}
		return "ERROR";
	}
		
	public String deletepost()
	{
		String title =post.getTitle();
		try {
			if( new postcurd().deletepost(title))
			{
				return "SUCCESS";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "ERROR";
		}
		return "ERROR";
	}
	
	
	
	
	
	@Override
	public Object getModel() {
		// TODO Auto-generated method stub
		return post;
	}

}

package com.service;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.connection.conn;
import com.model.post;
import com.model.user;

public class postcurd {
	private SessionFactory sf;
	private Session session;
	private Transaction tr;

	
	public postcurd()
	{
		sf = conn.getsesSessionFactory();
		session = sf.openSession();
		tr = session.beginTransaction();
	}
	
	public List display(String username) throws SQLException
	{

		Query query = session.createQuery("from post where author="+username);
		List users = query.list();
		tr.commit();
		return users;
	}
	public List display2(String username) throws SQLException
	{
		Query query = session.createQuery("from post where agentname="+username);
		List users = query.list();
		tr.commit();
		return users;
	}
	public boolean deletepost(String title) throws SQLException
	{
		post u = (post)session.get(post.class, title);
		session.delete(u);
		tr.commit();
		return true;
	}
	public boolean addpost(post post) throws SQLException
	{	

		session.save(post);
		tr.commit();
		return true;
	}
	public boolean dianzan(String title) throws SQLException
	{	
		post u = (post)session.get(post.class, title);
		u.setSend("已发货");
		session.save(u);
		tr.commit();
		return true;
	}
	public boolean payzan(String title) throws SQLException
	{	
		post u = (post)session.get(post.class, title);
		u.setPay("已付款");
		session.save(u);
		tr.commit();
		return true;
	}
}

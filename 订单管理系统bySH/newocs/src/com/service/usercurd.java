package com.service;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.connection.conn;
import com.model.user;

public class usercurd {
private SessionFactory sf;
private Session session;
private Transaction tr;

public usercurd()
{
	sf = conn.getsesSessionFactory();
	session = sf.openSession();
	tr = session.beginTransaction();
}
public boolean useradd(user user) throws SQLException
{	

	session.save(user);
	tr.commit();
	return true;
}
public boolean userlogin(user user) throws SQLException
{
	user u = (user)session.get(user.class, user.getUsername());

	
	if(u.getUsername().equals(user.getUsername())&&u.getPassword().equals(user.getPassword()))
	{	System.out.println(user.getUsername()+user.getPassword());
		return true;
	}else
	{	System.out.println(u.getPassword()+u.getUsername());
		return false;}
}


public boolean deleteuser(String username) throws SQLException
{
	user u = (user)session.get(user.class, username);
	session.delete(u);
	tr.commit();
	return true;
}
public List displayuser() throws SQLException
{
	session = sf.openSession();
	tr = session.beginTransaction();
	Query query = session.createQuery("from user");
	List users = query.list();
	tr.commit();
	return users;
}

}

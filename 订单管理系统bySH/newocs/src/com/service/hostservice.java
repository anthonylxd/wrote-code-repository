package com.service;

import java.sql.SQLException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.connection.conn;
import com.model.host;
import com.model.user;

public class hostservice {
		private SessionFactory sf;
		private Session session;
		private Transaction tr;

		public hostservice()
		{
			sf = conn.getsesSessionFactory();
			session = sf.openSession();
			tr = session.beginTransaction();
		}
		public boolean hostlogin(host host) throws SQLException
		{
			host u = (host)session.get(host.class, host.getUsername());

			
			if(u.getUsername().equals(host.getUsername())&&u.getPassword().equals(host.getPassword()))
			{	
				return true;
			}else
			{
				return false;}
		}
		public boolean hostadd(host host) throws SQLException
		{	

			session.save(host);
			tr.commit();
			return true;
		}
}

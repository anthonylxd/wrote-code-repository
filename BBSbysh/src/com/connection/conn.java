package com.connection;



import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class conn {
	private static SessionFactory sf;
	public static SessionFactory getsesSessionFactory()
	{	if(sf==null)
	{
		Configuration cfg = new Configuration();
		cfg.configure();
		SessionFactory sf = cfg.buildSessionFactory();
		return sf;
	}else {
		return sf;
	}
	}
}

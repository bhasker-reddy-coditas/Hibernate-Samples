package com.hbm;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionUtils {

	private static SessionFactory factory;
	private SessionUtils() {}
	
	public static SessionFactory getSessionFactory(Class clz) {
		
		if(null == factory)
			factory = new Configuration()
				.configure()
				.addAnnotatedClass(clz)
				.buildSessionFactory();
		return factory;
	}
	
	public static void closeSessionFactory() {
		factory.close();
	}

}

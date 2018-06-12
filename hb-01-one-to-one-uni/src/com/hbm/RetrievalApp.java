package com.hbm;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class RetrievalApp {

	public static void main(String[] args) {

		
		Configuration cfg = new Configuration().configure();
		cfg.addAnnotatedClass(Student.class);

		SessionFactory fctory = cfg.buildSessionFactory();
		
		Session sess1 = fctory.openSession();
		System.out.println("session 1 : "+sess1.hashCode());
		
		try {
			Student std = sess1.load(Student.class,1);
			System.out.println(std);
			
			Student std1= sess1.load(Student.class, 1);
			System.out.println(std1);

			Student std2= sess1.load(Student.class, 2);
			System.out.println(std2);
			System.out.println("\n");
			
			Student std3 = sess1.get(Student.class, 2);
			System.out.println(std3);

			sess1.close();
			
			Session sess2 =  fctory.openSession();//fctory.getCurrentSession(); try this
			System.out.println("session 2 : "+sess2.hashCode());	
			//Student std4= sess2.load(Student.class, 2);
			//System.out.println(std4);

		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			fctory.close();
		}
	}

}

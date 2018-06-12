package com.hbm;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HbmMain {

	public static void main(String[] args) {

		Configuration cfg = new Configuration();
		cfg.configure();
		//cfg.configure("hibernate.cfg.xml"); to specify cfg file name, if default is not hibernate.cfg.xml 

		cfg.addAnnotatedClass(Student.class);
		
		SessionFactory factory = cfg.buildSessionFactory();
		
		Session session = factory.openSession();
		try {
			
			//create student object
			System.out.println("creating new student");
			Student student = new Student("Ram", "Raj", "ram@raj.in");

			
			//start transaction
			Transaction txn = session.beginTransaction();
			
			//save the student
			System.out.println("Saving new student");
			session.save(student);
			
			//commit the transaction
			txn.commit();
			System.out.println("Done!");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			factory.close();
		}
		
		 
		
		
		
		
	}

}

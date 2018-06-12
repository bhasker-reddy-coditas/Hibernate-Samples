package com.hbm;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class SavePersist {

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
			Serializable rt = session.save(student);
			
			System.out.println("return value of save() :  " + rt);
			//commit the transaction
			txn.commit();
			
			System.out.println("txn committed. \n =================================================");
			
			System.out.println("New student created..");
			student = new Student("varun", "tej", "varun@taj.in");
			
			txn = session.getTransaction();
			txn.begin();
			System.out.println("starting new txn..");
			
			session.persist(student);
			System.out.println("persist method stores student.");
			
			txn.commit();
			System.out.println("new txn committed.");
			session.close();
			System.out.println("Done! - Session closed.");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			factory.close();
		}
		
		 
		
		
		
		
	}

}

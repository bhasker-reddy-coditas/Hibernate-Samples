package com.hbm;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class StateMngmntDemo {

	public static void main(String[] args) {

		Configuration cfg = new Configuration();
		cfg.configure();
		//cfg.configure("hibernate.cfg.xml"); to specify cfg file name, if default is not hibernate.cfg.xml 

		cfg.addAnnotatedClass(Student.class);
		
		SessionFactory factory = cfg.buildSessionFactory();
		
		Session session1 = factory.openSession();
		Transaction txn =  session1.getTransaction();
		try {
			
			txn.begin();
			// transient state
			Student std1= new Student("Ravi", "Teja", "ravi@tej.in");
			
			//persistant state
			session1.save(std1);

			std1.setFirstName("Ramcharan");
			txn.commit();
			session1.close();			// detached state
			
			std1.setFirstName("Sai"); // detatched state object

			Session session2 = factory.openSession();
			
			Transaction txn2 =session2.getTransaction();
			txn2.begin();
			session2.saveOrUpdate(std1); //std1 bacak to persistant state
			
			txn2.commit();
			session2.close(); 			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			factory.close();
		}
		
		 
		
		
		
		
	}

}

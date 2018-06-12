package com.hbm;

import java.util.logging.Logger;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class MergeUpdate {

	public static Logger log = Logger.getLogger("MergeUpdate");
	public static void main(String[] args) {
		
		SessionFactory factory = SessionUtils.getSessionFactory(Student.class);
		
		Session session = factory.openSession();
		
		Student std1  = new Student("Raghu", "Ram");
		std1.setId(2);
		
		Student std2;
		try {
			Transaction t1 = session.beginTransaction();
			std2 = (Student) session.merge(std1); //save or update

			//session.update(std1);
			
			log.info("****"+std2);
			System.out.println(std1);
		//	System.out.println(std2);
			t1.commit();
		}catch(Exception exc) {
			exc.printStackTrace();
		}
		finally {
			session.close();
			SessionUtils.closeSessionFactory();
		}
	}
}
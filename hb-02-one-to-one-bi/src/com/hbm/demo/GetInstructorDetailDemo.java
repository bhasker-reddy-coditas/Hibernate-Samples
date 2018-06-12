package com.hbm.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.hbm.entity.Instructor;
import com.hbm.entity.InstructorDetail;


/*bidirectional*/
public class GetInstructorDetailDemo {

	public static void main(String[] args) {

		Configuration cfg = new Configuration();
		cfg.configure();

		cfg.addAnnotatedClass(InstructorDetail.class);
		cfg.addAnnotatedClass(Instructor.class);

		SessionFactory factory = cfg.buildSessionFactory();

		Session session = factory.openSession();
		try {

			// start transaction
			Transaction txn = session.beginTransaction();
			int id = 3;

			// Bi directional detail<-->instr
			InstructorDetail insDet = session.get(InstructorDetail.class, id);

			System.out.println("Found InstructorDetail : " + insDet);

			//System.out.println("Found Instructor : " + insDet.getInstructor());

			if (insDet != null) {
				session.delete(insDet);
			}
			// commit the transaction
			txn.commit();
			System.out.println("Done!");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
			factory.close();
		}
	}

}

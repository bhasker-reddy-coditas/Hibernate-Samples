package com.hbm.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.hbm.entity.Instructor;
import com.hbm.entity.InstructorDetail;

public class OneToOneUniPtoCDemo {

	public static void main(String[] args) {

		Configuration cfg = new Configuration();
		cfg.configure();

		cfg.addAnnotatedClass(InstructorDetail.class);
		cfg.addAnnotatedClass(Instructor.class);

		SessionFactory factory = cfg.buildSessionFactory();

		Session session = factory.openSession();
		try {

			// create objects
			Instructor instr = new Instructor("sami", "bob", "bob.sam5@rt.lk");

			InstructorDetail instDet = new InstructorDetail("samibon.com", "run");

			// create association
			instr.setInstructorDetail(instDet);

			// start transaction
			Transaction txn = session.beginTransaction();

			// save the instr --> Cascade saves detail also
			System.out.println("Saving " + instr);
			session.save(instr);

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

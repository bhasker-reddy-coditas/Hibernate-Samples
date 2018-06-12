package com.hbm.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.hbm.entity.Instructor;
import com.hbm.entity.InstructorDetail;

public class DeleteDemo {

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
			int id = 2;

			// Uni directional foreign key is present in INSTRUCTOR, this record can refer
			// to the child in other table
			Instructor ins = session.get(Instructor.class, id);

			if (null != ins) {
				session.delete(ins);
			}

			// try to do it in reverse fetch detail try to delete
			/*
			 * No error detail record will get deleted no effect to Parent InstructorDetail
			 * insDet = session.get(InstructorDetail.class, id);
			 * 
			 * System.out.println("Found : " +insDet);
			 * 
			 * if(insDet !=null) { session.delete(insDet); }
			 */

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

package com.hbm;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class FlushRetreive {

	public static void main(String[] args) {

		SessionFactory sf = new Configuration()
							.configure()
							.addAnnotatedClass(Student.class)
							.buildSessionFactory();
		
		Session s1 = sf.openSession();
		
		Transaction t1 = s1.beginTransaction();
		
		//retrieve student objbect
		Student s = s1.load(Student.class, 1);
		// update lastname of student in loop using flush();
		
		/*System.out.println("====flush()======");
		for(int i=0;i<2; i++) {
			System.out.println("\nbefore: "+s);
			s.setLastName("Ram"+i);
			s1.flush();
			System.out.println("after: "+s1.get(Student.class, 1));
		}
		*/
		
		//comment either flush / refresh block to test
		System.out.println("\n====refresh()======");
		//for(int i=0;i<5; i++) {
			System.out.println("\nbefore: "+s);
			s.setLastName("Ram"+99);
			s1.refresh(s);
			System.out.println("after: "+s);
		//}
		
		System.out.println("\nFinal student "+ s);
		//commit txn and close session
		t1.commit();
		s1.close();
	}

}

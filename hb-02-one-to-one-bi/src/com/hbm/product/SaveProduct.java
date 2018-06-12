package com.hbm.product;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.hbm.SessionUtils;

public class SaveProduct {

	public static void main(String[] args) {

		SessionFactory factory = SessionUtils.getSessionFactory(Product.class);
		Session session = factory.openSession();
		Transaction t1 = session.beginTransaction();
		try {
			Product p1 = new Product(3, "HP", 5433);
			Product p2 = new Product(4, "DELL", 4621);

			session.save(p1);
			session.save(p2);

			t1.commit();
			
		} catch(Exception ex){
			ex.printStackTrace();
		}finally {
			session.close();
			SessionUtils.closeSessionFactory();
		}
		
	}

}

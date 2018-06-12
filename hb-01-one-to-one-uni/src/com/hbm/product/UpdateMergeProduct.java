package com.hbm.product;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.hbm.SessionUtils;

public class UpdateMergeProduct {

	public static void main(String[] args) {
		SessionFactory factory = SessionUtils.getSessionFactory(Product.class);

		Session s1 = factory.openSession();

		Product prd = new Product(5, "LG", 555);
		s1.save(prd);
		s1.close();//detached
		prd.setPrice(322); //
		
		Product prd2 =null;
		Session s2 = factory.openSession();
		Transaction t1 = s2.beginTransaction();
		prd2 = s2.load(Product.class, 5);
		prd2.setPrice(432);
		s2.update(prd2);

		t1.commit();
		s2.close();
		factory.close();
	}

}

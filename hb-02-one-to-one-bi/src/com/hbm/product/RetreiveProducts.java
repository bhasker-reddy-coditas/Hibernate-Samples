package com.hbm.product;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.hbm.SessionUtils;

public class RetreiveProducts {

	public static void main(String[] args) {
		SessionFactory factory = SessionUtils.getSessionFactory(Product.class);
		Session s1= factory.openSession();
		Session s2= factory.openSession();
		
		
		try {
			//use get() 
			Object o1= s1.load(Product.class, 1); 
			System.out.println(o1);
			s1.evict(o1);
						Object o2= s1.load(Product.class, 1);
			Object o3= s2.load(Product.class, 1);
			
			System.out.println(o2);
			System.out.println(o3);
			
			s2.clear();
			
			System.out.println("=======CLEARED==========");
			Object o4= s2.load(Product.class, 1);
			System.out.println(o4);
			
			Product p4= (Product)s2.load(Product.class, 4);
			
		} catch(Exception e){
			e.printStackTrace();
		}finally {
			s1.close();
			s2.close();
			SessionUtils.closeSessionFactory();
		}
	}

}

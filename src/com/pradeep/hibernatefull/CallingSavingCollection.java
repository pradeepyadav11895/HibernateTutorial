package com.pradeep.hibernatefull;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.pradeep.hibernatefull.entity.Address;
import com.pradeep.hibernatefull.entity.SavingCollection;

public class CallingSavingCollection {
	
	public static void main(String[] args) {
		
		SessionFactory factory= new Configuration().configure().addAnnotatedClass(SavingCollection.class).buildSessionFactory();
		
		Session session= factory.getCurrentSession();
		
		// craete class entity class obj
		
		SavingCollection collection= new SavingCollection();
		collection.setUsername("papa");
		
		Address address= new Address();
		address.setCity("hyd");
		address.setPincode("2222");
		address.setState("ts");
		address.setStreet("wf ");
		
		
		Address address2= new Address();
		address2.setCity("bhiwadi");
		address2.setPincode("2222");
		address2.setState("raj");
		address2.setStreet("rhb ");
		
		collection.getListofAddress().add(address);
		collection.getListofAddress().add(address2);
		
		// strt trans
		session.beginTransaction();
		
		//perform oper
		
		session.save(collection);
		
		//commit trans
		
		session.getTransaction().commit();
		
		
		
		try {
			
		} finally {
			session.close();
			factory.close();
		}
		
	}
	
	
	
	

}

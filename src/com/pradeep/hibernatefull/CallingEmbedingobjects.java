package com.pradeep.hibernatefull;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.pradeep.hibernatefull.entity.Address;
import com.pradeep.hibernatefull.entity.UserTableEmbeedingvalueObjects;

public class CallingEmbedingobjects {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		SessionFactory factory= new Configuration().configure().addAnnotatedClass(UserTableEmbeedingvalueObjects.class).buildSessionFactory();
		
		Session session=factory.getCurrentSession();
   
		try {
			
			// creating entity class object
			
			UserTableEmbeedingvalueObjects embeedingvalueObjects=new UserTableEmbeedingvalueObjects();
			embeedingvalueObjects.setUserid(1);
			embeedingvalueObjects.setUsername("pardeep");
			
			Address addr= new Address();
			addr.setCity("hyderabad");
			addr.setStreet("white field");
			addr.setState("ts");
			addr.setPincode("852852");
			
			embeedingvalueObjects.setHomeaddress(addr);
			
			Address addr2= new Address();
			embeedingvalueObjects.setOfficeaddress(addr2);
			
			// start transation
			session.beginTransaction();
			
			//perform opertion
			session.save(embeedingvalueObjects);
			
			// commit trans
			
			session.getTransaction().commit();
			
			
			
			
			
		} finally {
			// TODO: handle finally clause
			
			session.close();
			factory.close();
		}
		
	}

}

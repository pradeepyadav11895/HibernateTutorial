package com.pradeep.hibernatefull;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.pradeep.hibernatefull.entity.CascadeTypes;
import com.pradeep.hibernatefull.entity.CascadeVechile;

public class CallingCascadetype {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		SessionFactory factory= new Configuration().configure().addAnnotatedClass(CascadeTypes.class).buildSessionFactory();
		
		Session session=factory.getCurrentSession();
		
		
		
		
		try {
			
			// making entity class obj
			CascadeTypes user=new CascadeTypes();
			user.setUsername("pradeep");
			
			CascadeVechile vechile= new CascadeVechile();
			vechile.setVechilname("car");
			
			CascadeVechile vechile2= new CascadeVechile();
			vechile2.setVechilname("jeep");
			
			user.getVechiles().add(vechile);
			user.getVechiles().add(vechile2);
			
			//start trans
			session.beginTransaction();
			// perform iopration
			
			session.persist(user);
			
			//comit trans
			
			session.getTransaction().commit();
			
 			
		} finally {
            session.close();
            factory.close();
		}

	}

}

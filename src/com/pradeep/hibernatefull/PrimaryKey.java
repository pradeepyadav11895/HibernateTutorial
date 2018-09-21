package com.pradeep.hibernatefull;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.pradeep.hibernatefull.entity.UserDetails;

public class PrimaryKey {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		SessionFactory factory=new Configuration()
								.configure()
								.addAnnotatedClass(UserDetails.class)
								.buildSessionFactory();
		
		Session session= factory.getCurrentSession();
		
		
		try {
			
			UserDetails user= new UserDetails();
			user.setUserId(1);
			user.setUserName("pradeep");
			UserDetails user2= new UserDetails();
			user2.setUserId(2);
			user2.setUserName("raj");

			session.beginTransaction();
			
			
			session.save(user);
			session.save(user2);
			
			session.getTransaction().commit();
			session.close();
			
			
			
		} finally {
			// TODO: handle finally clause
			
			session.close();
			factory.close();
		}
		
	}

}

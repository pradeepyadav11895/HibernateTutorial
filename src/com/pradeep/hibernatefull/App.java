package com.pradeep.hibernatefull;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.pradeep.hibernatefull.entity.UserDetails;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SessionFactory factory=new Configuration()
									.configure()
									.addAnnotatedClass(UserDetails.class)
									.buildSessionFactory();
		
		
		Session session= factory.getCurrentSession();
		
		try {
			
			UserDetails user=new UserDetails();
			user.setUserId(1);
			user.setUserName("deep");
			user.setJoinedDate(new Date());
			user.setAddress("address is coming");
			user.setDescription("a descp is comong here");
			
			session.beginTransaction();
			
			session.save(user);
			session.getTransaction().commit();
			session.close();
			// reterving objects using seesion.get 
			
			user=null;
			
			session=factory.getCurrentSession();
			session.beginTransaction();
			user=session.get(UserDetails.class, 1);
			System.out.println("user name retervied is : "+user.getUserName());
			
			
		} finally {
	          session.close();
	          factory.close();
		
		}
		

	}

}

package com.pradeep.hibernatefull;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.pradeep.hibernatefull.entity.OneToOneRealation;
import com.pradeep.hibernatefull.entity.Vechile;

public class CallingOneToOne {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
		SessionFactory factory=new Configuration().configure().addAnnotatedClass(OneToOneRealation.class).buildSessionFactory();
		
		Session session= factory.getCurrentSession();
		
		try {
			
			//makeing class object
			
			OneToOneRealation oneRealation=new OneToOneRealation();
			oneRealation.setUsername("pardeep");
			
			Vechile vechile= new Vechile();
			vechile.setVechilename("car");
			
			oneRealation.setVechile(vechile);
			
			// start transation
			
			session.beginTransaction();
			
			//perform opreation
			
			session.save(oneRealation);
			session.save(vechile);
			
			// commit trans
			session.getTransaction().commit();
			
			
			
		} finally {
			// TODO: handle finally clause
	      session.close();
	      factory.close();
		}

	}

}

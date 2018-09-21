package com.pradeep.hibernatefull;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.pradeep.hibernatefull.entity.AllVechile;
import com.pradeep.hibernatefull.entity.MappedbyManyToMany;

public class CallingMappedByManyToMany {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		SessionFactory factory= new Configuration().configure().addAnnotatedClass(MappedbyManyToMany.class).buildSessionFactory();
		
		
		Session session= factory.getCurrentSession();
		
		try {
			
			// make entity class object
			
			MappedbyManyToMany user= new MappedbyManyToMany();
			user.setUsername("pradeep");
			
			AllVechile vechile= new AllVechile();
			vechile.setVechilename("car");
			
			AllVechile vechile2= new AllVechile();
			vechile2.setVechilename("jeep");
			
			user.getVechile().add(vechile);
			user.getVechile().add(vechile2);
			
			vechile.getUsers().add(user);
			
			//start trans
			
			session.beginTransaction();
			
			//perform opertaion
			
			session.save(user);
			session.save(vechile);
			session.save(vechile2);
			
			//commit trsns
			
			session.getTransaction().commit();
			
			
		} finally {
			// TODO: handle finally clause
           session.close();
           factory.close();
		}

	}

}

package com.pradeep.hibernatefull;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.pradeep.hibernatefull.entity.OneToManyAndManyToOneRelation;
import com.pradeep.hibernatefull.entity.Vechile;

public class CallingOneToMany {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SessionFactory factory =new Configuration().configure().addAnnotatedClass(OneToManyAndManyToOneRelation.class).buildSessionFactory();
		
		
		Session session= factory.getCurrentSession();
		
		// creating calss obj
		
		OneToManyAndManyToOneRelation user= new OneToManyAndManyToOneRelation();
		
	    user.setUsername("pradeep");
		
		Vechile vechile= new Vechile();
		vechile.setVechilename("car");
		
		Vechile vechile2= new Vechile();
		vechile2.setVechilename("jeep");
		
		user.getVechiles().add(vechile);
		user.getVechiles().add(vechile2);
		
		vechile.setUsers(user);
		vechile2.setUsers(user);
		
		//strt trasn
		session.beginTransaction();
		
		//perform operation
		session.save(user);
		session.save(vechile);
		session.save(vechile2);
		
		//commit trans
		session.getTransaction().commit();
		
		
		try {
			
		} finally {
			// TODO: handle finally clause
		session.close();
		factory.close();
		}

	}

}

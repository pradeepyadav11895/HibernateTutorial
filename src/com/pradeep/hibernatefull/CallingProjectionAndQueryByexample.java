package com.pradeep.hibernatefull;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;

import com.pradeep.hibernatefull.entity.ProjectionAndQueryByexample;

public class CallingProjectionAndQueryByexample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SessionFactory factory= new Configuration().configure().addAnnotatedClass(ProjectionAndQueryByexample.class).buildSessionFactory();
		
		Session session= factory.getCurrentSession();
		
		
		try {
			session.beginTransaction();
			
			/*******************for projectiona and order****************************/
			
		/*	for(int i=0;i<10;i++) {
				ProjectionAndQueryByexample user= new ProjectionAndQueryByexample();
				user.setUsername("username "+i);
				session.save(user);
			}
			
			Criteria criteria= session.createCriteria(ProjectionAndQueryByexample.class)
					//.setProjection(Projections.property("userid"));
					
					//set projection
					//.setProjection(Projections.min("userid"));
					
					//we can aslo use add order
					
					.addOrder(Order.desc("userid"));
					
					
			
			
			List<ProjectionAndQueryByexample> list= criteria.list();
			
			for (ProjectionAndQueryByexample projectionAndQueryByexample : list) {
				System.out.println(projectionAndQueryByexample.getUsername());
			}
			
		    
		    session.getTransaction().commit();*/
			
			
			/***********************************for query by example**************************/
			ProjectionAndQueryByexample exampleuser= new ProjectionAndQueryByexample();
			// if we pass any argument  which is primary key then it will retunn all record
			exampleuser.setUserid(52);
			exampleuser.setUsername("username 2");
			// .excludeProperty("userid") is used suppose we dont want to use that 
			Example example=Example.create(exampleuser).excludeProperty("userid");
			
			Criteria criteria=session.createCriteria(ProjectionAndQueryByexample.class)
					.add(example);
			
			List<ProjectionAndQueryByexample> list=criteria.list();
			
			for (ProjectionAndQueryByexample projectionAndQueryByexample : list) {
				System.out.println(projectionAndQueryByexample.getUserid());
			}
			
			
		} finally {
         session.close();
         factory.close();
		}
		
	}

}

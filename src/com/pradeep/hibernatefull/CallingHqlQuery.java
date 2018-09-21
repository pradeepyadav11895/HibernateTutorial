package com.pradeep.hibernatefull;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.pradeep.hibernatefull.entity.HQLQuery;

public class CallingHqlQuery {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		SessionFactory factory= new Configuration().configure().addAnnotatedClass(HQLQuery.class).buildSessionFactory();
		
		Session session=factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			
			List<HQLQuery> list= session.createQuery("from HQLQuery").setFirstResult(1).setMaxResults(4).getResultList();
			
			session.getTransaction().commit();
			
			for (HQLQuery hqlQuery : list) {
				System.out.println(hqlQuery.getUsername());
				
			}
			
			System.out.println("size of list :"+list.size());
			
		} finally {
                session.close();
                factory.close();
		}

	}

}

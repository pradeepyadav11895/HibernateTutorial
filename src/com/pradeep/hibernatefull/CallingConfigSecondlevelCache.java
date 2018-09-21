package com.pradeep.hibernatefull;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.pradeep.hibernatefull.entity.ConfigSecondlevelCache;

public class CallingConfigSecondlevelCache {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		SessionFactory factory= new Configuration().configure().addAnnotatedClass(ConfigSecondlevelCache.class).buildSessionFactory();
		
		Session session=factory.getCurrentSession();
		
		try {
			
			
			/********************intoduction to seesion cache******************/
			/*// id perteinet object with same parameter calling mutiole times in on session then oly one select is caled
			// if we call it in another sesion sesion then cache wil not woerk 
			// so theer is a need for second level; cavche
			session.beginTransaction();
			
			for(int i=0;i<10;i++) {
				ConfigSecondlevelCache cache= new ConfigSecondlevelCache();
				cache.setUsername("pradeep "+i);
				session.save(cache);
			}
			
			
			
			ConfigSecondlevelCache cache=session.get(ConfigSecondlevelCache.class, 61);
			
			// if we are calling the same then only one select query is woeking
			//ConfigSecondlevelCache cache2=session.get(ConfigSecondlevelCache.class, 61);
			
			session.getTransaction().commit();
			session.close();
			// if we close one sesion and start new then hobernat ewill call select query two times
			
			Session session2=factory.getCurrentSession();
			session2.beginTransaction();
			ConfigSecondlevelCache cache3=session2.get(ConfigSecondlevelCache.class, 61);
			session2.getTransaction().commit();
			session2.close();
			
			*/
			
			/*******************with second level cache*******************************/
			
			session.beginTransaction();
			ConfigSecondlevelCache cache=session.get(ConfigSecondlevelCache.class, 61);
			
			
			ConfigSecondlevelCache cache2=session.get(ConfigSecondlevelCache.class, 61);
			
			session.getTransaction().commit();
			
			
			
		} finally {
          
           //factory.close();
		}

	}

}

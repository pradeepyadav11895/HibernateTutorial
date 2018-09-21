package com.pradeep.hibernatefull;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.pradeep.hibernatefull.entity.NamedQueries;

public class CallingNamedQuery {

	public static void main(String[] args) {
SessionFactory factory= new Configuration().configure().addAnnotatedClass(NamedQueries.class).buildSessionFactory();
		
		Session session=factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			
			/*for(int i=0;i<10;i++) {
				ParameterBindingAndSqlInjection ParameterBindingAndSqlInjection= new ParameterBindingAndSqlInjection();
				ParameterBindingAndSqlInjection.setUsername("username "+i);
				session.save(ParameterBindingAndSqlInjection);
			}*/
			int userids=32;
			
			//calling Named queries
			//Query<NamedQueries> query= session.getNamedQuery("NamedQueries.id");
			 //query.setParameter("userid", userids);
			
			//calling maed native query
			Query<NamedQueries> query= session.getNamedQuery("NamedQueries.name");
			        query.setParameter("username", "username 2");
					/*query.setFirstResult(1);
					query.setMaxResults(4);
					*/
					List<NamedQueries> list=	query.getResultList();

			
			
			session.getTransaction().commit();
			
			for (NamedQueries hqlQuery : list) {
				System.out.println(hqlQuery.getUserid());
				
			}
			
			System.out.println("size of list :"+list.size());
			
		} finally {
                session.close();
                factory.close();
		}

	}

}

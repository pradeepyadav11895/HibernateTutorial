package com.pradeep.hibernatefull;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.pradeep.hibernatefull.entity.ParameterBindingAndSqlInjection;

public class CallingParameterBindingAndSqlInjection {

	public static void main(String[] args) {
	SessionFactory factory= new Configuration().configure().addAnnotatedClass(ParameterBindingAndSqlInjection.class).buildSessionFactory();
		
		Session session=factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			
			/*for(int i=0;i<10;i++) {
				ParameterBindingAndSqlInjection ParameterBindingAndSqlInjection= new ParameterBindingAndSqlInjection();
				ParameterBindingAndSqlInjection.setUsername("username "+i);
				session.save(ParameterBindingAndSqlInjection);
			}*/
			int userids=22;
			Query<ParameterBindingAndSqlInjection> query= session.createQuery("from ParameterBindingAndSqlInjection where userid=:userid");
			        query.setParameter("userid", userids);
					/*query.setFirstResult(1);
					query.setMaxResults(4);
					*/
					List<ParameterBindingAndSqlInjection> list=	query.getResultList();

			
		//List<ParameterBindingAndSqlInjection> list= session.createQuery("from ParameterBindingAndSqlInjection").setFirstResult(1).setMaxResults(4).getResultList();
			
			session.getTransaction().commit();
			
			for (ParameterBindingAndSqlInjection hqlQuery : list) {
				System.out.println(hqlQuery.getUsername());
				
			}
			
			System.out.println("size of list :"+list.size());
			
		} finally {
                session.close();
                factory.close();
		}
	}

}

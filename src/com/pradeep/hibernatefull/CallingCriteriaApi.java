package com.pradeep.hibernatefull;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import com.pradeep.hibernatefull.entity.CriteriaApi;

public class CallingCriteriaApi {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SessionFactory factory= new Configuration().configure().addAnnotatedClass(CriteriaApi.class).buildSessionFactory();
		
		Session session= factory.getCurrentSession();
		
		try {
			
			//start trans
			session.beginTransaction();
			
			// perform opertaion
			
			/*for(int i=0;i<10;i++) {
				CriteriaApi api= new CriteriaApi();
				api.setUsername("username "+i);
				session.save(api);
			}*/
			
			
			// old method 
			Criteria criteria= session.createCriteria(CriteriaApi.class);
			//criteria.add(Restrictions.eq("username", "username 2"));
			
			//criteria.add(Restrictions.between("userid", 43, 47));
			
			criteria.add(Restrictions.or(Restrictions.between("userid", 41, 43), Restrictions.between("userid", 45, 49)));
			
			List<CriteriaApi> list= criteria.list();
			
			
			// new method using java x persistence which is not working
			
		/*	CriteriaBuilder builder= session.getCriteriaBuilder();
			CriteriaQuery<CriteriaApi> criteriaQuery= builder.createQuery(CriteriaApi.class);*/
		
			
			
    
			for (CriteriaApi criteriaApi : list) {
				System.out.println(criteriaApi.getUserid());
				
			}
			
			//commit trans
			session.getTransaction().commit();
			
		} finally {
                  session.close();
                  factory.close();
		}
		
	}

}

package com.pradeep.hibernatefull;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.pradeep.hibernatefull.entity.Address;
import com.pradeep.hibernatefull.entity.ProxyobjectsEagerAndLazyFetchType;

public class callingProxyobjectsEagerAndLazyFetchType {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		SessionFactory factory= new Configuration().configure().addAnnotatedClass(ProxyobjectsEagerAndLazyFetchType.class).buildSessionFactory();
		
		Session session= factory.getCurrentSession();
		
		try {
			
			// create object
			
			ProxyobjectsEagerAndLazyFetchType user= new ProxyobjectsEagerAndLazyFetchType();
			user.setUsername("pradeep");
			
			Address address= new Address();
			address.setCity("hyd");
			address.setPincode("25252");
			address.setState("ts");
			address.setStreet("ws");
			
			
			Address address1= new Address();
			address1.setCity("hydddfwe");
			address1.setPincode("252wfwf52");
			address1.setState("twffs");
			address1.setStreet("wwfwfs");
			
			user.getListofAddress().add(address);
			user.getListofAddress().add(address1);
			
			//starting trasn
			session.beginTransaction();
			//perform operation
			session.save(user);
			
			//commot trans
			session.getTransaction().commit();
			
			session.close();
			
			user=null;
			
			session=factory.openSession();
			user=session.get(ProxyobjectsEagerAndLazyFetchType.class, 1);
			session.close();
			
			//here if we clsoe the seesion error is comg as by default i will call lazy type
			//to get rid of this problem we will set fetch type to eagar 
			System.out.println(user.getListofAddress().size());
			
			
			
		} finally {
			session.close();
			factory.close();
		}

	}

}

package com.pradeep.hibernatefull;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.pradeep.hibernatefull.entity.CRUDOperation;

public class CallingCRUDOperation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SessionFactory factory= new Configuration().configure().addAnnotatedClass(CRUDOperation.class).buildSessionFactory();
		
		Session session= factory.getCurrentSession();
		
		//sttart trans
		
		session.beginTransaction();
		
		//perform opertaiona and entity class obj
		
		/***************creating user using save means c of crud  ********/
		
		/*for(int i=0;i<10;i++) {
			CRUDOperation user= new CRUDOperation();
			user.setUsername("username "+i);
			session.save(user);
		}*/
		
		/******************reterving user r of crud*******************************/
		
		/*CRUDOperation user=session.get(CRUDOperation.class, 5);
		System.out.println("user pulled is :"+user.getUsername());
		*/
		
		/*******************************updating user d of crud********************/

		CRUDOperation updateuser= session.get(CRUDOperation.class, 3);
		updateuser.setUsername("updtaed by pradeep");
		
		
		/******************deleting user d of crud **********************/
		/*
		CRUDOperation userdel=session.get(CRUDOperation.class, 2);
		session.delete(userdel);
		*/
		
		
		//commit trans
		
		session.getTransaction().commit();
		
	}

}

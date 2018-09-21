package com.pradeep.hibernatefull;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.cfgxml.internal.ConfigLoader;
import org.hibernate.cfg.Configuration;

import com.pradeep.hibernatefull.entity.InheritanceFourWheller;
import com.pradeep.hibernatefull.entity.InheritenceVechile;
import com.pradeep.hibernatefull.entity.InhertenceTwowheller;

public class CallingInheritenceVechile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SessionFactory factory= new Configuration().configure().addAnnotatedClass(InheritenceVechile.class).buildSessionFactory();
		
		Session session=factory.getCurrentSession();
		
		try {
			
			// mmmaking object of entity classs
			
			InheritenceVechile vechile= new InheritenceVechile();
			vechile.setVechilename("car");
			
			InhertenceTwowheller byk=new InhertenceTwowheller();
			byk.setVechilename("twister");
			byk.setSteeringHandle("byk steering handle");
			
			InheritanceFourWheller car= new InheritanceFourWheller();
			car.setVechilename("ritz");
			car.setSteeringwheel("ritz wheel steering");
			
			// strt trans
			
			session.beginTransaction();
			
			// perform operation
			
			session.save(vechile);
			session.save(car);
			session.save(byk);
			
			//commit trans
			
			session.getTransaction().commit();
			
			
		} finally {
          session.close();
          factory.close();
		}

	}

}

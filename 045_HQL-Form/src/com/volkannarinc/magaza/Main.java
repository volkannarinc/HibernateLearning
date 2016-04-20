package com.volkannarinc.magaza;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		
		@SuppressWarnings("deprecation")
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		Query qry = session.createQuery("FROM Urun");
		
		List<?> l = qry.list();
		System.out.println("Kayýt Sayýsý:	"+l.size());
		Iterator<?> It = l.iterator();
		
		while (It.hasNext()) {
			Object o = (Object) It.next();
			Urun u = (Urun) o;
			System.out.println("Urun id :	"+u.getUrunId());
			System.out.println("Urun Adý:	"+u.getUrunAdi());
			System.out.println("Urun Fiyatý:	"+u.getUrunFiyati());
			System.out.println("----------------------------------");
		}
		
		session.close();
		sessionFactory.close();
	}

}

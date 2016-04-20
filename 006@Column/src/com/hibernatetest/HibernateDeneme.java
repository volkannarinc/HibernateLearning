package com.hibernatetest;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.volkannarinc.Personel;

public class HibernateDeneme {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Personel personel = new Personel();
		personel.setPersonelId(10);
		personel.setPersonelAdi("Mehmet");
		personel.setPersonelSoyadi("KEskin");
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(personel);
		session.getTransaction().commit();
	}

}

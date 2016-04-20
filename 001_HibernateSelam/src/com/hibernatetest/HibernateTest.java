package com.hibernatetest;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.volkannarinc.Personel;

public class HibernateTest {
	public static void main(String[] args) {

		Personel personel = new Personel();
		personel.setPersonelid(1);
		personel.setPersonelAdi("Volkan");
		personel.setPersonelSoyadi("Narinç");
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(personel);
		session.getTransaction().commit();
		
	}
}

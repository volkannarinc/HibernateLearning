package com.hibernatetest;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.volkannarinc.Personel;

public class HibernateDeneme {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Personel personel = new Personel();
		personel.setPersonelId(1);
		personel.setPersonelAdi("Mehmet Emin");
		personel.setPersonelSoyadi("�pek");
		personel.setPersonelKayitTarihi(new Date());
		personel.setPersonelAdresi("Serdivan/SAKARYA");
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(personel);
		session.getTransaction().commit();
		session.close();
	}

}

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
		//--------------------------------------------------------------------------------------
		personel = null;
		session = sessionFactory.openSession(); 
		session.beginTransaction();
		personel = (Personel) session.get(Personel.class, 1); //1 de�eri hangi id de�erine sahip personeli getrirtti�imizi belirtmek i�in kullan�l�r.
		System.out.println("ID DE�ER� : " + personel.getPersonelId());
		System.out.println("ADI SOYADI : " + personel.getPersonelAdi() + " " + personel.getPersonelSoyadi());
		System.out.println("KAYIT TAR�H� : " + personel.getPersonelKayitTarihi());
		System.out.println("ADRES� : " + personel.getPersonelAdresi());
	}

}	

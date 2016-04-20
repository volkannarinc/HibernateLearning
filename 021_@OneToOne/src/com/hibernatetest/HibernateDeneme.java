package com.hibernatetest;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.volkannarinc.Meslek;
import com.volkannarinc.Personel;


public class HibernateDeneme {

	public static void main(String[] args) {
		//ID DEÐERLERINI GENERAEDVALUE ANOTASYONU SAYESINDE VERMEMIZE GEREK KALMADI.		
		
		Personel personel = new Personel();
		personel.setPersonelAdi("Mehmet");
		personel.setPersonelSoyadi("Keskin");
		personel.setPersonelKayitTarihi(new Date());
		//-------------------------------------------------
		Meslek meslek = new Meslek();
		meslek.setMeslekAdi("Yazýlým Geliþtirici");
		
		personel.setMeslek(meslek);
		
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(personel);
		session.save(meslek);
		session.getTransaction().commit();
		session.close();
		
		
	}

}	

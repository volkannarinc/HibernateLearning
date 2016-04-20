package com.hibernatetest;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.volkannarinc.Personel;

public class HibernateDeneme {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		//ID DEÐERLERINI GENERAEDVALUE ANOTASYONU SAYESINDE VERMEMIZE GEREK KALMADI.		

		Personel personel = new Personel();
		personel.setPersonelAdi("Mehmet");
		personel.setPersonelSoyadi("Keskýn");
		personel.setPersonelKayitTarihi(new Date());
		personel.setPersonelAdresi("Serdivan/SAKARYA");
		personel.setPersonelMaasi("1300");
		personel.setPersonelTelefonu("2342343637");
		
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
		personel = (Personel) session.get(Personel.class, 1); //1 deðeri hangi id deðerine sahip personeli getrirttiðimizi belirtmek için kullanýlýr.
		
		System.out.println("ID DEÐERÝ : " + personel.getPersonelId());
		System.out.println("ADI SOYADI : " + personel.getPersonelAdi() + " " + personel.getPersonelSoyadi());
		System.out.println("KAYIT TARÝHÝ : " + personel.getPersonelKayitTarihi());
		System.out.println("ADRESÝ : " + personel.getPersonelAdresi());
		System.out.println("MAASI : " + personel.getPersonelMaasi());
		System.out.println("TELEFON : " + personel.getPersonelTelefonu());
		
	}

}	

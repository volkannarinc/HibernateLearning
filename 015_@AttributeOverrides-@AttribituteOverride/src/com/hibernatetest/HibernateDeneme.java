package com.hibernatetest;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.volkannarinc.Personel;

public class HibernateDeneme {

	public static void main(String[] args) {
		//ID DE�ERLERINI GENERAEDVALUE ANOTASYONU SAYESINDE VERMEMIZE GEREK KALMADI.		

		Personel personel = new Personel();
		personel.setPersonelAdi("VOLKAN");
		personel.setPersonelSoyadi("NAR�N�");
		personel.setPersonelKayitTarihi(new Date());
		//-------------------------------------------------
		Adres evAdresi1 = new Adres();
		evAdresi1.setSehir("Sakarya");
		evAdresi1.setSemt("Serdivan");
		evAdresi1.setCadde("Yeni Cd.");
		evAdresi1.setKapiNo("Kap� No: 2");
		evAdresi1.setPostaKodu("54050");
		personel.setEvAdresi(evAdresi1);	//ADRESI �LGILI PERSONELE ATIYORUZ.
		
		Adres isAdresi1 = new Adres();
		isAdresi1.setSehir("Sakarya");
		isAdresi1.setSemt("Serdivan");
		isAdresi1.setCadde("Kamp�s");
		isAdresi1.setKapiNo("Kap� No: 05");
		isAdresi1.setPostaKodu("54150");
		personel.setIsAdresi(isAdresi1);	//ADRESI �LGILI PERSONELE ATIYORUZ.

		
		Personel personel2 = new Personel();
		personel2.setPersonelAdi("Mehmet");
		personel2.setPersonelSoyadi("Kesk�n");
		personel2.setPersonelKayitTarihi(new Date());
		//-------------------------------------------------
		Adres evAdresi2 = new Adres();
		evAdresi2.setSehir("Sakarya");
		evAdresi2.setSemt("Serdivan");
		evAdresi2.setCadde("Teni Cd.");
		evAdresi2.setKapiNo("Kap� No: 2");
		evAdresi2.setPostaKodu("54050");
		personel2.setEvAdresi(evAdresi2);	//ADRESI �LGILI PERSONELE ATIYORUZ.

		
		Adres isAdresi2 = new Adres();
		isAdresi2.setSehir("Sakarya");
		isAdresi2.setSemt("Serdivan");
		isAdresi2.setCadde("Teni Cd.");
		isAdresi2.setKapiNo("Kap� No: 2");
		isAdresi2.setPostaKodu("54050");
		personel2.setIsAdresi(isAdresi2);	//ADRESI �LGILI PERSONELE ATIYORUZ.

		
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(personel);
		session.save(personel2);
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
		
		System.out.println("�EH�R " + personel.getEvAdresi().getSehir());
		System.out.println("SEMT : " + personel.getEvAdresi().getSemt());
		System.out.println("CADDE : " + personel.getEvAdresi().getCadde());
		System.out.println("KAPI NO : " + personel.getEvAdresi().getKapiNo());
		System.out.println("POSTA KODU : " + personel.getEvAdresi().getPostaKodu());
		System.out.println(" ");
		System.out.println("�EH�R " + personel.getIsAdresi().getSehir());
		System.out.println("SEMT : " + personel.getIsAdresi().getSemt());
		System.out.println("CADDE : " + personel.getIsAdresi().getCadde());
		System.out.println("KAPI NO : " + personel.getIsAdresi().getKapiNo());
		System.out.println("POSTA KODU : " + personel.getIsAdresi().getPostaKodu());
		
		System.out.println("-----------------------------------------------------------------");
		
		
		personel2 = null;
		personel2 = (Personel) session.get(Personel.class, 2); //1 de�eri hangi id de�erine sahip personeli getrirtti�imizi belirtmek i�in kullan�l�r.
		
		System.out.println("ID DE�ER� : " + personel2.getPersonelId());
		System.out.println("ADI SOYADI : " + personel2.getPersonelAdi() + " " + personel2.getPersonelSoyadi());
		System.out.println("KAYIT TAR�H� : " + personel2.getPersonelKayitTarihi());
		
		System.out.println("�EH�R " + personel2.getEvAdresi().getSehir());
		System.out.println("SEMT : " + personel2.getEvAdresi().getSemt());
		System.out.println("CADDE : " + personel2.getEvAdresi().getCadde());
		System.out.println("KAPI NO : " + personel2.getEvAdresi().getKapiNo());
		System.out.println("POSTA KODU : " + personel2.getEvAdresi().getPostaKodu());
		System.out.println(" ");		
		System.out.println("�EH�R " + personel2.getIsAdresi().getSehir());
		System.out.println("SEMT : " + personel2.getIsAdresi().getSemt());
		System.out.println("CADDE : " + personel2.getIsAdresi().getCadde());
		System.out.println("KAPI NO : " + personel2.getIsAdresi().getKapiNo());
		System.out.println("POSTA KODU : " + personel2.getIsAdresi().getPostaKodu());
	}

}	

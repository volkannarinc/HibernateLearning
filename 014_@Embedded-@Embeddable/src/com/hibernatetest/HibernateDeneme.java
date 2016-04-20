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
		Adres adres = new Adres();
		adres.setSehir("Sakarya");
		adres.setSemt("Serdivan");
		adres.setMahalle("Kemalpa�a Mah.");
		adres.setCadde("Teni Cd.");
		adres.setDaireNo("No: 67");
		adres.setKapiNo("Kap� No: 2");
		adres.setKat("kat:1");
		adres.setPostaKodu("54050");
		personel.setAdres(adres);
		
		
		Personel personel2 = new Personel();
		personel2.setPersonelAdi("Mehmet");
		personel2.setPersonelSoyadi("Kesk�n");
		personel2.setPersonelKayitTarihi(new Date());
		//-------------------------------------------------
		Adres adres2 = new Adres();
		adres2.setSehir("Sakarya");
		adres2.setSemt("Serdivan");
		adres2.setMahalle("Kemalpa�a Mah.");
		adres2.setCadde("Teni Cd.");
		adres2.setDaireNo("No: 67");
		adres2.setKapiNo("Kap� No: 2");
		adres2.setKat("kat:1");
		adres2.setPostaKodu("54050");
		personel2.setAdres(adres);
		
		
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
		
		System.out.println("�EH�R " + personel.getAdres().getSehir());
		System.out.println("SEMT : " + personel.getAdres().getSemt());
		System.out.println("MAHALLE : " + personel.getAdres().getMahalle());
		System.out.println("CADDE : " + personel.getAdres().getCadde());
		System.out.println("DA�RE : " + personel.getAdres().getDaireNo());
		System.out.println("KAPI NO : " + personel.getAdres().getKapiNo());
		System.out.println("KAT : " + personel.getAdres().getKat());
		System.out.println("POSTA KODU : " + personel.getAdres().getPostaKodu());
		
		System.out.println("-----------------------------------------------------------------");
		
		
		personel2 = null;
		personel2 = (Personel) session.get(Personel.class, 2); //1 de�eri hangi id de�erine sahip personeli getrirtti�imizi belirtmek i�in kullan�l�r.
		
		System.out.println("ID DE�ER� : " + personel2.getPersonelId());
		System.out.println("ADI SOYADI : " + personel2.getPersonelAdi() + " " + personel2.getPersonelSoyadi());
		System.out.println("KAYIT TAR�H� : " + personel2.getPersonelKayitTarihi());
		
		System.out.println("�EH�R " + personel2.getAdres().getSehir());
		System.out.println("SEMT : " + personel2.getAdres().getSemt());
		System.out.println("MAHALLE : " + personel2.getAdres().getMahalle());
		System.out.println("CADDE : " + personel2.getAdres().getCadde());
		System.out.println("DA�RE : " + personel2.getAdres().getDaireNo());
		System.out.println("KAPI NO : " + personel2.getAdres().getKapiNo());
		System.out.println("KAT : " + personel2.getAdres().getKat());
		System.out.println("POSTA KODU : " + personel2.getAdres().getPostaKodu());
	}

}	

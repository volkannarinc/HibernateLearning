package com.hibernatetest;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.volkannarinc.Personel;


public class HibernateDeneme {

	public static void main(String[] args) {
		//ID DE�ERLERINI GENERAEDVALUE ANOTASYONU SAYESINDE VERMEMIZE GEREK KALMADI.		

		//�RNEK NOTU :	NORMALDE @JoinTable KULLANINCA ���NC� TABLOYU OTOMAT�K OLARAK OLU�TURUR.
					//AMA BU �RNEKTE KULLANMAMIZA RA�MEN ���NC� TABLOYU B�ZE OLU�TURMADI.BUNUN
					//NEDEN� �L��K� KURAN �K� TABLONUN DA KEND�LER�NE A�T �D ALANLARI OLMAMASIDIR. 
		
		Personel personel = new Personel();
		personel.setPersonelAdi("VOLKAN");
		personel.setPersonelSoyadi("NAR�N�");
		personel.setPersonelKayitTarihi(new Date());
		//-------------------------------------------------
		Adres adres1 = new Adres();
		adres1.setSehir("Sakarya");
		adres1.setSemt("Serdivan");
		adres1.setCadde("Teni Cd.");
		adres1.setKapiNo("Kap� No: 2");
		adres1.setPostaKodu("54050");
		personel.getAdresListesi().add(adres1);
		
		Adres adres2 = new Adres();
		adres2.setSehir("Sakarya");
		adres2.setSemt("Serdivan");
		adres2.setCadde("Teni Cd.");
		adres2.setKapiNo("Kap� No: 2");
		adres2.setPostaKodu("54050");
		personel.getAdresListesi().add(adres2);
		
		
		
		Personel personel2 = new Personel();
		personel2.setPersonelAdi("Mehmet");
		personel2.setPersonelSoyadi("Kesk�n");
		personel2.setPersonelKayitTarihi(new Date());
		//-------------------------------------------------
		Adres adres3 = new Adres();
		adres3.setSehir("Sakarya");
		adres3.setSemt("Serdivan");
		adres3.setCadde("Teni Cd.");
		adres3.setKapiNo("Kap� No: 2");
		adres3.setPostaKodu("54050");
		personel2.getAdresListesi().add(adres3);

		Adres adres4 = new Adres();
		adres4.setSehir("Sakarya");
		adres4.setSemt("Serdivan");
		adres4.setCadde("Teni Cd.");
		adres4.setKapiNo("Kap� No: 2");
		adres4.setPostaKodu("54050");
		personel2.getAdresListesi().add(adres4);
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(personel);
		session.save(personel2);
		session.getTransaction().commit();
		session.close();
		
	}

}	

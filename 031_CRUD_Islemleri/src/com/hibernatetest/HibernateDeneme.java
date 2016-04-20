package com.hibernatetest;

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
		
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		//5 kay�t ekliyoruz
		for(int i = 1 ; i<6 ;i++){
			Personel personel = new Personel();
			personel.setPersonelAdi("ADI");
			personel.setPersonelSoyadi("SOYADI" + i);
			session.save(personel);
		}
		
		Personel personel = (Personel)session.get(Personel.class, 3);
		session.delete(personel);//Id de�eri 3 olan� siliyoruz
		
		personel = (Personel)session.get(Personel.class, 4);
		personel.setPersonelAdi("GUNCEL_AD");
		personel.setPersonelSoyadi("GUNCEL_SOYAD");
		session.update(personel);
		
		session.getTransaction().commit();
		session.close();
		
		System.out.println("G�NCELLENEN VER�: "+personel.getPersonelAdi()+" "+personel.getPersonelSoyadi() );
	}

}	

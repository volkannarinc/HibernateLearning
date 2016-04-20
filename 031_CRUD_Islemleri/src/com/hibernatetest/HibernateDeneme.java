package com.hibernatetest;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.volkannarinc.Personel;


public class HibernateDeneme {

	public static void main(String[] args) {
		//ID DEÐERLERINI GENERAEDVALUE ANOTASYONU SAYESINDE VERMEMIZE GEREK KALMADI.		

		//ÖRNEK NOTU :	NORMALDE @JoinTable KULLANINCA ÜÇÜNCÜ TABLOYU OTOMATÝK OLARAK OLUÞTURUR.
					//AMA BU ÖRNEKTE KULLANMAMIZA RAÐMEN ÜÇÜNCÜ TABLOYU BÝZE OLUÞTURMADI.BUNUN
					//NEDENÝ ÝLÝÞKÝ KURAN ÝKÝ TABLONUN DA KENDÝLERÝNE AÝT ÝD ALANLARI OLMAMASIDIR. 
		
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		//5 kayýt ekliyoruz
		for(int i = 1 ; i<6 ;i++){
			Personel personel = new Personel();
			personel.setPersonelAdi("ADI");
			personel.setPersonelSoyadi("SOYADI" + i);
			session.save(personel);
		}
		
		Personel personel = (Personel)session.get(Personel.class, 3);
		session.delete(personel);//Id deðeri 3 olaný siliyoruz
		
		personel = (Personel)session.get(Personel.class, 4);
		personel.setPersonelAdi("GUNCEL_AD");
		personel.setPersonelSoyadi("GUNCEL_SOYAD");
		session.update(personel);
		
		session.getTransaction().commit();
		session.close();
		
		System.out.println("GÜNCELLENEN VERÝ: "+personel.getPersonelAdi()+" "+personel.getPersonelSoyadi() );
	}

}	
